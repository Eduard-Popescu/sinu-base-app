package ro.sd.a2.service;

import ro.sd.a2.domain.entity.dto.StudentDTO;

import java.util.Collection;
import java.util.List;

public interface AdminService {
    List<StudentDTO> getStudentsOfClass(String classId);
}
