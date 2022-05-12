package ro.sd.a2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.sd.a2.domain.entity.Student;

import java.util.Collection;

@Repository
public interface StudentRepository
    extends JpaRepository<Student, String> {

    @Query("SELECT s FROM Student s WHERE s.aClass.classId=?1")
    Collection<Student> getStudentsByAClass_ClassId(String classId);
}
