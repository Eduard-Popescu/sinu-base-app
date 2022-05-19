package ro.sd.a2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.sd.a2.service.serviceImp.StudentServiceImpl;

@Controller
public class MainController {

  private final StudentServiceImpl studentService;

  public MainController(StudentServiceImpl studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/")
  public String root(Model model) {
    SimpleGrantedAuthority studentAuth = new SimpleGrantedAuthority("STUDENT USER");
    SimpleGrantedAuthority adminAuth = new SimpleGrantedAuthority("ADMIN USER");
    SimpleGrantedAuthority teachAuth = new SimpleGrantedAuthority("TEACHER USER");
    UserDetails userDetails = studentService.getUserDetails();
    if(userDetails.getAuthorities().contains(studentAuth)) {
      model.addAttribute("user", userDetails.getUsername());
      return "student-home";
    }
    if(userDetails.getAuthorities().contains(adminAuth)){
      model.addAttribute("user",userDetails.getUsername());
      return "admin-home";
    }
    if(userDetails.getAuthorities().contains(teachAuth)){
      model.addAttribute("user",userDetails.getUsername());
      return "teachingTopics";
    }
    return HttpStatus.UNAUTHORIZED.toString();
  }

  @GetMapping("/login")
  public String login(Model model) {
    return "login";
  }

  @GetMapping("/user")
  public String userIndex() {
    return "user/student-home";
  }

}
