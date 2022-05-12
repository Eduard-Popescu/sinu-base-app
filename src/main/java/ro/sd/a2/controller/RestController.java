package ro.sd.a2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ro.sd.a2.domain.entity.dto.StudentGradeDTO;
import ro.sd.a2.service.TopicClassBookService;

import java.util.Collection;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(path = "/rest-class-book-topic")
public class RestController {

  private final TopicClassBookService topicClassBookService;

  @Autowired
  public RestController(TopicClassBookService topicClassBookService) {
    this.topicClassBookService = topicClassBookService;
  }

  @GetMapping("/grades")
  public ResponseEntity<Collection<StudentGradeDTO>> getAllGradesForASingleYear(@RequestParam String studentId, @RequestParam String classBookYear){
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
    Collection<StudentGradeDTO> response = topicClassBookService.studentGrades(studentId,3);

    return ResponseEntity.ok().body(response);
  }


}
