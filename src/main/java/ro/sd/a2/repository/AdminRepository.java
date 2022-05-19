package ro.sd.a2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.sd.a2.domain.entity.Administrator;
import ro.sd.a2.domain.entity.ClassBook;
import ro.sd.a2.domain.entity.Student;

@Repository
public interface AdminRepository extends JpaRepository<ClassBook, String> {

  @Query("SELECT A FROM Administrator A WHERE A.personalInfo.email = ?1")
  Administrator getAdministratorByEmail(String email);

}
