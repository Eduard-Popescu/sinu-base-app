package ro.sd.a2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.sd.a2.domain.entity.PersonalInfo;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, String> {

  @Query("SELECT PI FROM PersonalInfo PI WHERE PI.name=?1")
  PersonalInfo getPersonalInfoByName(String personalName);

  @Query("SELECT PI FROM PersonalInfo PI WHERE PI.email=?1")
  PersonalInfo getPersonalInfoByEmail(String email);

}
