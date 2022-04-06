package ro.sd.a2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sd.a2.domain.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {

}
