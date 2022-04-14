package ro.sd.a2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.sd.a2.domain.entity.dto.StudentGradeDTO;
import ro.sd.a2.service.TopicClassBookService;

import java.util.Collection;

@Controller
@RequestMapping(path = "/class-book-topic")
public class ClassBookTopicController {

  private final TopicClassBookService topicClassBookService;

  public ClassBookTopicController(TopicClassBookService topicClassBookService) {
    this.topicClassBookService = topicClassBookService;
  }

  /**
   *
   * @param studentId
   * @param classBookYear
   * @return ModelAndView
   */
  @GetMapping("/grades")
  public ModelAndView getAllGradesForASingleYear(@RequestParam String studentId, @RequestParam String classBookYear){
    ModelAndView mav = new ModelAndView();
    int year = 0;
    if(classBookYear.equals("Note Anul 3")){
      year =3;
    }
    if(classBookYear.equals("Note Anul 2")){
      year=2;
    }
    if(classBookYear.equals("Note Anul 1")){
      year =1;
    }
    Collection<StudentGradeDTO> response = topicClassBookService.studentGrades(studentId,year);

    mav.addObject("gradesList", response);
    // adaugi x obiecte
    mav.setViewName("grade");
    //log the final outcome: Success y?
    return mav;
  }

}
