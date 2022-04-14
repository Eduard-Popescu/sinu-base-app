package ro.sd.a2.service.serviceImp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.sd.a2.domain.entity.PersonalInfo;
import ro.sd.a2.repository.PersonalInfoRepository;
import ro.sd.a2.service.PersonalInfoService;

@Service
@Slf4j
public class PersonalInfoServiceImpl implements PersonalInfoService {

  private final PersonalInfoRepository personalInfoRepository;

  public PersonalInfoServiceImpl(PersonalInfoRepository personalInfoRepository) {
    this.personalInfoRepository = personalInfoRepository;
  }

  /**
   *
   * @param personalName
   * @return PersonalInfo
   */
  @Override
  public PersonalInfo getPersonalInfoByName(String personalName) {
    log.debug("Personal name for getPersonalInfoByName:{}",personalName);
    PersonalInfo personalInfo = personalInfoRepository.getPersonalInfoByName(personalName);
    log.debug("PersonalInfo:{}",personalInfo.toString());
    return  personalInfo;
  }
}
