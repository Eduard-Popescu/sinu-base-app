package ro.sd.a2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sd.a2.domain.entity.Student;

@Repository
public interface StudentRepository
    extends JpaRepository<Student, String> {
}
