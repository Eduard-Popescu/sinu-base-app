package ro.sd.a2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.sd.a2.domain.entity.dto.TeacherDTO;
import ro.sd.a2.service.TopicService;

import java.util.Collection;

@Controller
@RequestMapping("/topic")
public class TopicController {

    private final TopicService topicService;

    public TopicController (TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/get-teachers")
    public ModelAndView getAllTopicTeachers(@RequestParam String topicId) {
        ModelAndView mav = new ModelAndView();

        Collection<TeacherDTO> teachers = topicService.getAllTopicTeachers(topicId);

        mav.addObject("teachers", teachers);

        mav.setViewName("topicTeachers");

        return mav;
    }
}
