package ro.sd.a2.service;


import ro.sd.a2.domain.entity.dto.StudentGradeDTO;

import java.util.List;

public interface TopicClassBookService {

   List<StudentGradeDTO> studentGrades(String studentId);

}
