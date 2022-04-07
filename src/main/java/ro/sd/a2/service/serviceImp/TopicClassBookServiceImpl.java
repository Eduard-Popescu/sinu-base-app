package ro.sd.a2.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.domain.entity.TopicClassBook;
import ro.sd.a2.domain.entity.dto.StudentClassBookDTO;
import ro.sd.a2.domain.entity.dto.StudentGradeDTO;
import ro.sd.a2.repository.TopicClassBookRepository;
import ro.sd.a2.service.StudentService;
import ro.sd.a2.service.TopicClassBookService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicClassBookServiceImpl implements TopicClassBookService {

  private final StudentService studentService;
  private final TopicClassBookRepository topicClassBookRepository;

  @Autowired
  public TopicClassBookServiceImpl(StudentService studentService, TopicClassBookRepository topicClassBookRepository) {
    this.studentService = studentService;
    this.topicClassBookRepository = topicClassBookRepository;
  }

  @Override
  public List<StudentGradeDTO> studentGrades(String studentId) {
    List<StudentClassBookDTO> classBookDTOs = studentService.getClassBookByUser(studentId);
    List<StudentGradeDTO> studentGradeDTOS = new ArrayList<>();
    for(StudentClassBookDTO studentClassBookDTO: classBookDTOs){
      TopicClassBook topicClassBook = topicClassBookRepository.getTopicClassBookByClassBookId(studentClassBookDTO.getClassBookId());
      StudentGradeDTO studentGradeDTO = StudentGradeDTO.builder()
          .topicName(topicClassBook.getTopic().getTopicName())
          .grade(topicClassBook.getGrade())
          .semester(studentClassBookDTO.getClassBookSemester())
          .year(studentClassBookDTO.getClassBookYear())
          .examinationMethod(topicClassBook.getTopic().getExaminationType())
          .build();
      studentGradeDTOS.add(studentGradeDTO);
    }
    return studentGradeDTOS;
  }
}
