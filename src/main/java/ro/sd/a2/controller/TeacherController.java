package ro.sd.a2.controller;

import liquibase.pro.packaged.M;
import liquibase.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sd.a2.domain.entity.dto.NewTeacherDTO;
import ro.sd.a2.domain.entity.dto.TopicDTO;
import ro.sd.a2.service.TeacherService;

import java.util.Collection;

@Controller
@RequestMapping(path = "/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) { this.teacherService = teacherService; }


    @GetMapping("/new")
    public ModelAndView newTeacher() {
        ModelAndView mav = new ModelAndView();

        mav.addObject("teacher", new NewTeacherDTO());

        mav.setViewName("addTeacherForm");

        return mav;
    }

    @PostMapping("/add")
    public ModelAndView addNewTeacher(NewTeacherDTO teacher) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("teacher", teacher);

        if (StringUtils.isEmpty(teacher.getName())
                || StringUtils.isEmpty(teacher.getEmail())
                || StringUtils.isEmpty(teacher.getNpc())
                || StringUtils.isEmpty(teacher.getEntitling())
                || StringUtils.isEmpty(teacher.getStreet())
                || StringUtils.isEmpty(teacher.getCity())
                || StringUtils.isEmpty(teacher.getCountry())
                || StringUtils.isEmpty(teacher.getPostalCode())
        ) {
            mav.addObject("error", "AT LEAST ONE FIELD IS EMPTY");
            mav.setViewName("addTeacherForm");
            return mav;
        }

        if (!StringUtils.isNumeric(teacher.getNpc())
                || !StringUtils.isNumeric(teacher.getPostalCode())
        ) {
            mav.addObject("error", "NPC or Postal Code is not numerical");
            mav.setViewName("addTeacherForm");
            return mav;
        }

        teacherService.addTeacher(teacher);

        mav.setViewName("home");

        return mav;
    }

    @GetMapping("/get-topics")
    public ModelAndView getTeachingTopics(@RequestParam String teacherId) {
        //validation if needed
        //shall we log a little?
        ModelAndView mav = new ModelAndView();

        Collection<TopicDTO> teachingTopics = teacherService.getAllTeachingTopics(teacherId);

        mav.addObject("topics", teachingTopics);
        // adaugi x obiecte
        mav.setViewName("teachingTopics");
        //log the final outcome: Success y?
        return mav;
    }
}
