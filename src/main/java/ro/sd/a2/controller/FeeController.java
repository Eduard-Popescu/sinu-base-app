package ro.sd.a2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sd.a2.domain.entity.dto.FeeInformationToSendDTO;
import ro.sd.a2.domain.entity.dto.PayFeeDTO;
import ro.sd.a2.domain.entity.dto.StudentFeeDTO;
import ro.sd.a2.service.FeeService;
import ro.sd.a2.service.serviceImp.RabbitMqSender;

import java.util.Collection;

@Controller
@RequestMapping(path = "/fee")
public class FeeController {

  private final FeeService feeService;

  private final RabbitMqSender rabbitMqSender;

  @Value("${app.message}")
  private String message;

  public FeeController(FeeService feeService,RabbitMqSender rabbitMqSender) {
    this.feeService = feeService;
    this.rabbitMqSender = rabbitMqSender;
  }

  /**
   *
   * @param userId
   * @return ModelAndView
   */
  @GetMapping
  public ModelAndView getFee(@RequestParam String userId){
    ModelAndView mav = new ModelAndView();
    Collection<StudentFeeDTO> response = feeService.getAllStudentFee(userId);

    mav.addObject("feeList", response);
    // adaugi x obiecte
    mav.setViewName("plata-taxe");
    //log the final outcome: Success y?
    return mav;
  }

  /**
   *
   * @param studentId
   * @param feeId
   * @return ModelAndView
   */
  @PostMapping("/pay")
  public ModelAndView pay(@RequestParam String studentId,@RequestParam(value = "feeId", required = false) String feeId){
    if(feeId != null){
      String responseFee = feeService.pay(feeId);

      FeeInformationToSendDTO feeInformationToSendDTO = feeService.getDetailsForEmail(feeId);
      rabbitMqSender.send(feeInformationToSendDTO);

      ModelAndView mav = new ModelAndView();
      Collection<StudentFeeDTO> response = feeService.getAllStudentFee(studentId);
      mav.addObject("feeList", response);
      mav.setViewName("plata-taxe");
      return mav;
    }
    ModelAndView mav = new ModelAndView();
    Collection<StudentFeeDTO> response = feeService.getAllStudentFee(studentId);
    mav.addObject("feeList", response);
    mav.setViewName("plata-taxe");
    return mav;
  }

}
