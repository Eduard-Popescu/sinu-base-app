package ro.sd.a2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.sd.a2.domain.entity.ClassBook;

import java.util.List;

@Repository
public interface ClassBookRepository extends JpaRepository<ClassBook, String> {

  @Query("SELECT CB FROM ClassBook CB WHERE CB.student.studentId = ?1")
  List<ClassBook> getClassBookByUser(String studentId);

}
