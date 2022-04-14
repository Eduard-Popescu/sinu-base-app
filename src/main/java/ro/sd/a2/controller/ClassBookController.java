package ro.sd.a2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.sd.a2.service.ClassBookService;

import java.util.Collection;

@Controller
@RequestMapping(path = "/class-book")
public class ClassBookController {

  private final ClassBookService classBookService;

  public ClassBookController(ClassBookService classBookService) {
    this.classBookService = classBookService;
  }

  /**
   *
   * @param studentId
   * @return
   */
  @GetMapping("/grades")
  public ModelAndView getEachClassBookWithDifferentYear(@RequestParam  String studentId){
    ModelAndView mav = new ModelAndView();
    Collection<String> response = classBookService.getGradesForEachYears(studentId);

    mav.addObject("gradesList", response);
    // adaugi x obiecte
    mav.setViewName("grades");
    //log the final outcome: Success y?
    return mav;
  }

}
