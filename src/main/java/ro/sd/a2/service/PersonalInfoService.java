package ro.sd.a2.service;

import ro.sd.a2.domain.entity.PersonalInfo;

public interface PersonalInfoService {

  PersonalInfo getPersonalInfoByName(String personalName);

}
