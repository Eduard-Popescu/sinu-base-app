package ro.sd.a2.service;

import ro.sd.a2.domain.entity.Student;
import ro.sd.a2.domain.entity.dto.ModifiedStudentDTO;
import ro.sd.a2.domain.entity.dto.NewStudentDTO;
import ro.sd.a2.domain.entity.dto.StudentClassBookDTO;
import ro.sd.a2.domain.entity.dto.StudentDTO;

import java.util.List;

public interface StudentService {

  List<StudentClassBookDTO> getClassBookByUser(String userId);

  StudentDTO getStudentById(String studentId);

  void modifyStudent(ModifiedStudentDTO modifiedStudentDTO);

  void deleteStudent(String studentId);

  void addNewStudent(NewStudentDTO newStudentDTO);

  List<Student> getAllStudents();
}
