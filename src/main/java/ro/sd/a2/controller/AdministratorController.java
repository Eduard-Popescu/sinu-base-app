package ro.sd.a2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sd.a2.domain.entity.dto.EmailDTO;
import ro.sd.a2.service.serviceImp.AdministratorServiceImpl;

import java.util.Collection;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdministratorController {

  private final AdministratorServiceImpl administratorService;

  public AdministratorController(AdministratorServiceImpl administratorService) {
    this.administratorService = administratorService;
  }

  @GetMapping("/home")
  public ModelAndView homePage(){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("admin-home");
    return mav;
  }

  @GetMapping("/email-users-informations")
  public ModelAndView getUsersInformation(){
    ModelAndView mav = new ModelAndView();
    Collection<String> response = administratorService.getInformationForEmailSend();
    mav.addObject("personalInformations", response);
    mav.addObject("emailDTO",new EmailDTO());
    // adaugi x obiecte
    mav.setViewName("admin-email-send");
    //log the final outcome: Success y?
    return mav;
  }

  //todo
  @PostMapping("/send-email")
  public ModelAndView sendEmailAsAdmin(@ModelAttribute EmailDTO emailDTO){
    ModelAndView mav = new ModelAndView();
    String response = administratorService.emailSender(emailDTO);
    mav.addObject("emailDTO",emailDTO);
    mav.setViewName("admin-email-send");
    log.info("Response from sendEmailAsAdmin: {}",response);
    return mav;
  }

}
