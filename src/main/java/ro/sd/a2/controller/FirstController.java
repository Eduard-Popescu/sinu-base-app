package ro.sd.a2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ro.sd.a2.domain.entity.dto.StudentGradeDTO;
import ro.sd.a2.service.TopicClassBookService;
import ro.sd.a2.service.UserService;

import java.util.List;


@Controller
public class FirstController {

    private static final Logger log = LoggerFactory.getLogger(FirstController.class);

    private UserService userService = new UserService();

    private final TopicClassBookService topicClassBookService;

    @Autowired
    public FirstController(TopicClassBookService topicClassBookService) {
        this.topicClassBookService = topicClassBookService;
    }

    public void testMethod(String userId){
        List<StudentGradeDTO> studentGradeDTOList = topicClassBookService.studentGrades(userId);
        for(StudentGradeDTO studentGradeDTO : studentGradeDTOList){
            System.out.println("Topic name:"+studentGradeDTO.getTopicName()+"\n"
            +"Year:"+ studentGradeDTO.getYear()+"\n"+
                "Semester:"+ studentGradeDTO.getSemester()+"\n"+
                "Grade:"+ studentGradeDTO.getGrade()+"\n"+
                "Examination: "+ studentGradeDTO.getExaminationMethod()+"\n");
        }
    }

//    @GetMapping("/profile")
//    public ModelAndView showProfile() {
//        //validation if needed
//        //shall we log a little?
//        ModelAndView mav = new ModelAndView();
//
//        //User user = new User("Bubu");
//        //mav.addObject("fullUserObj", user);
//        //mav.addObject("numeStudent", user.getName());
//        // adaugi x obiecte
//        mav.setViewName("profile");
//        //log the final outcome: Success y?
//        return mav;
//    }

}
