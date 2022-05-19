package ro.sd.a2.controller;

import liquibase.pro.packaged.M;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sd.a2.domain.entity.dto.*;
import ro.sd.a2.service.AdminService;
import ro.sd.a2.service.StudentService;
import ro.sd.a2.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    private final AdminService adminService;
    private final TeacherService teacherService;
    private final StudentService studentService;

    public AdminController(AdminService adminService, TeacherService teacherService, StudentService studentService) {
        this.adminService = adminService;
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    @GetMapping("/selIdT")
    public String selIdT(){
        return "select-id-teacher";
    }
    @GetMapping("/selIdS")
    public String selIdS(){
        return "select-id-student";
    }

    @GetMapping("/viewclass")
    public ModelAndView viewGroup(@RequestParam String classId) {
        ModelAndView mav = new ModelAndView();

        List<StudentDTO> students = adminService.getStudentsOfClass(classId);

        mav.addObject("students", students);

        mav.setViewName("view-class");

        return mav;
    }

    @GetMapping(value="/teacher")
    public ModelAndView crudTeacherView(@RequestParam String teacherId) {
        ModelAndView mav = new ModelAndView();

        TeacherDTO teacherDTO = teacherService.getTeacherById(teacherId);
        mav.addObject("teacherDTO", teacherDTO);
        mav.addObject("modifiedTeacherDTO", new ModifiedTeacherDTO());
        mav.setViewName("teacher-crud");

        return mav;
    }

    @RequestMapping(value="/modify-teacher", method=RequestMethod.POST, params="action=submit")
    public ModelAndView modifyTeacher(@ModelAttribute ModifiedTeacherDTO modifiedTeacherDTO) {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("home");

        if (StringUtils.isEmpty(modifiedTeacherDTO.getName())
                || StringUtils.isEmpty(modifiedTeacherDTO.getEmail())
                || StringUtils.isEmpty(modifiedTeacherDTO.getNpc())
                || StringUtils.isEmpty(modifiedTeacherDTO.getEntitling())
                || StringUtils.isEmpty(modifiedTeacherDTO.getStreet())
                || StringUtils.isEmpty(modifiedTeacherDTO.getCity())
                || StringUtils.isEmpty(modifiedTeacherDTO.getCountry())
                || StringUtils.isEmpty(modifiedTeacherDTO.getPostalCode())
        ) {
            return mav;
        }

        teacherService.updateTeacher(modifiedTeacherDTO);

        return mav;
    }

    @RequestMapping(value="/modify-teacher", method=RequestMethod.POST, params="action=delete")
    public ModelAndView deleteTeacher(@ModelAttribute ModifiedTeacherDTO modifiedTeacherDTO) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");

        teacherService.deleteTeacher(modifiedTeacherDTO.getTeacherId());

        return mav;
    }

    @GetMapping("/new-student")
    public ModelAndView addStudentForm() {
        ModelAndView mav = new ModelAndView();

        mav.addObject("newStudentDTO", new NewStudentDTO());
        mav.setViewName("student-add");

        return mav;
    }

    @PostMapping("/add-new-student")
    public ModelAndView addNewStudent(@ModelAttribute NewStudentDTO newStudentDTO) {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("home");
        if (StringUtils.isEmpty(newStudentDTO.getName())
                || StringUtils.isEmpty(newStudentDTO.getEmail())
                || StringUtils.isEmpty(newStudentDTO.getPassword())
                || StringUtils.isEmpty(newStudentDTO.getNpc())
                || StringUtils.isEmpty(newStudentDTO.getStreet())
                || StringUtils.isEmpty(newStudentDTO.getCity())
                || StringUtils.isEmpty(newStudentDTO.getCountry())
                || StringUtils.isEmpty(newStudentDTO.getPostalCode())
        ) {
            return mav;
        }

        studentService.addNewStudent(newStudentDTO);

        return mav;
    }

    @GetMapping("student")
    public ModelAndView studentView(@RequestParam String studentId) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("student-modify");

        mav.addObject("studentDTO", studentService.getStudentById(studentId));
        mav.addObject("modifiedStudentDTO", new ModifiedStudentDTO());

        return mav;
    }

    @RequestMapping(value="/modify-student", method=RequestMethod.POST, params="action=submit")
    public ModelAndView modifyStudent(@ModelAttribute ModifiedStudentDTO modifiedStudentDTO) {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("home");

        if (StringUtils.isEmpty(modifiedStudentDTO.getName())
                || StringUtils.isEmpty(modifiedStudentDTO.getEmail())
                || StringUtils.isEmpty(modifiedStudentDTO.getNpc())
                || StringUtils.isEmpty(modifiedStudentDTO.getStreet())
                || StringUtils.isEmpty(modifiedStudentDTO.getCity())
                || StringUtils.isEmpty(modifiedStudentDTO.getCountry())
                || StringUtils.isEmpty(modifiedStudentDTO.getPostalCode())
                || StringUtils.isEmpty(modifiedStudentDTO.getClassId())
        ) {
            return mav;
        }

        studentService.modifyStudent(modifiedStudentDTO);

        return mav;
    }

    @RequestMapping(value="/modify-student", method=RequestMethod.POST, params="action=delete")
    public ModelAndView deleteStudent(@ModelAttribute ModifiedStudentDTO modifiedStudentDTO) {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("home");

        studentService.deleteStudent(modifiedStudentDTO.getStudentId());

        return mav;
    }
}
