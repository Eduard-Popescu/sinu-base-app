package ro.sd.a2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.sd.a2.domain.entity.dto.TeacherEvaluationDTO;
import ro.sd.a2.service.TeacherEvaluationService;

@Controller
@RequestMapping(path = "/evaluation")
@Slf4j
public class TeacherEvaluationController {

  private final TeacherEvaluationService teacherEvaluationService;


  public TeacherEvaluationController(TeacherEvaluationService teacherEvaluationService) {
    this.teacherEvaluationService = teacherEvaluationService;
  }

  /**
   *
   * @return ModelAndView
   */
  @GetMapping
  public ModelAndView evaluation(){
    ModelAndView mav = new ModelAndView();
    mav.addObject("teacherEvaluationDTO",new TeacherEvaluationDTO());
    mav.setViewName("evaluare-cadru-didactic");
    return mav;
  }

  /**
   *
   * @param teacherEvaluationDTO
   * @return ModelAndView
   */
  @PostMapping
  public ModelAndView createEvaluation(@ModelAttribute TeacherEvaluationDTO teacherEvaluationDTO){
    ModelAndView mav = new ModelAndView();
    String response = teacherEvaluationService.addEvaluation(teacherEvaluationDTO);
    mav.addObject("teacherEvaluationDTO",teacherEvaluationDTO);
    mav.setViewName("evaluare-cadru-didactic");
    log.info("Response from addEvaluation: {}",response);
    return mav;
  }

}
