package ro.sd.a2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.sd.a2.domain.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {

  @Query("SELECT T FROM Teacher T WHERE T.personalInfo.name = ?1")
  Teacher getTeacherByName(String teacherName);

  @Query("SELECT T FROM Teacher T WHERE T.personalInfo.email = ?1")
  Teacher getTeacherByEmail(String email);

}
