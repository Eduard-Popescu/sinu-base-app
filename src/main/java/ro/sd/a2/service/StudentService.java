package ro.sd.a2.service;

import ro.sd.a2.domain.entity.Student;
import ro.sd.a2.domain.entity.dto.StudentClassBookDTO;

import java.util.List;

public interface StudentService {

  List<StudentClassBookDTO> getClassBookByUser(String userId);
  List<Student> getAllStudents();
}
