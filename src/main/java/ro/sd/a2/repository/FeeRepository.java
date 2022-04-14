package ro.sd.a2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.sd.a2.domain.entity.Fee;

import java.util.List;

@Repository
public interface FeeRepository extends JpaRepository<Fee, String> {

  @Query("SELECT F FROM Fee F WHERE F.student.studentId = ?1")
  List<Fee> getAllFeeByStudentId(String studentId);

  @Modifying
  @Query("UPDATE Fee F SET F.status = ?1 WHERE F.feeId = ?2")
  void updateFeeStatus(String status,String feeId);

}
