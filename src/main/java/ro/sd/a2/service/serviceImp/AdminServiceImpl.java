package ro.sd.a2.service.serviceImp;

import org.springframework.stereotype.Service;
import ro.sd.a2.domain.entity.Student;
import ro.sd.a2.domain.entity.dto.StudentDTO;
import ro.sd.a2.mapper.StudentMapper;
import ro.sd.a2.repository.StudentRepository;
import ro.sd.a2.service.AdminService;

import java.util.Collection;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final StudentRepository studentRepository;

    public AdminServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     *
     * @param classId group id
     * @return a collection with all student presents in this class
     */
    @Override
    public List<StudentDTO> getStudentsOfClass(String classId) {
        Collection<Student> students = studentRepository.getStudentsByAClass_ClassId(classId);
        return StudentMapper.studentsToStudentDTOs(students);
    }
}
