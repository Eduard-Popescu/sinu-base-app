package ro.sd.a2.mapper;

import org.springframework.stereotype.Component;
import ro.sd.a2.domain.entity.ClassBook;
import ro.sd.a2.domain.entity.Student;
import ro.sd.a2.domain.entity.dto.StudentClassBookDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {

  public static List<StudentClassBookDTO> studentToStudentClassBookDTO(Student student){
    List<StudentClassBookDTO> classBookDTOS = new ArrayList<>();
    for(ClassBook classBook: student.getClassBooks()){
      StudentClassBookDTO studentClassBookDTO = StudentClassBookDTO.builder()
          .studentId(student.getStudentId())
          .classBookId(classBook.getClassBookId())
          .classBookSemester(classBook.getClassBookSemester())
          .classBookYear(classBook.getClassBookYear())
          .build();
      classBookDTOS.add(studentClassBookDTO);
    }
    return classBookDTOS;
  }

}
