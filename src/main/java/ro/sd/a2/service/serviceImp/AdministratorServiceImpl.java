package ro.sd.a2.service.serviceImp;

import liquibase.pro.packaged.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ro.sd.a2.domain.entity.PersonalInfo;
import ro.sd.a2.domain.entity.dto.EmailDTO;
import ro.sd.a2.domain.entity.dto.EmailInformationForSendDTO;
import ro.sd.a2.mapper.EmailMapper;
import ro.sd.a2.repository.PersonalInfoRepository;
import ro.sd.a2.service.AdministratorService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

  private final String URI_EMAIL_SENDER = "http://localhost:8082/send-email";

  @Autowired
  private RestTemplate restTemplate;
  private final PersonalInfoRepository personalInfoRepository;

  @Autowired
  public AdministratorServiceImpl(PersonalInfoRepository personalInfoRepository) {
    this.personalInfoRepository = personalInfoRepository;
  }

  @Override
  public List<String> getInformationForEmailSend() {
    List<PersonalInfo> personalInfos = personalInfoRepository.findAll();
    List<String> emails = new ArrayList<>();
    for(PersonalInfo personalInfo :personalInfos){
      emails.add(personalInfo.getEmail());
    }
    return emails;
  }

  @Override
  public String emailSender(EmailDTO emailDTO) {
    PersonalInfo personalInfo = personalInfoRepository.getPersonalInfoByEmail(emailDTO.getReceiverEmail());
    EmailInformationForSendDTO emailInformationForSendDTO = EmailMapper.emailInformationForSendMapper(personalInfo,emailDTO);
    ResponseEntity<EmailInformationForSendDTO> response = restTemplate.postForEntity(URI_EMAIL_SENDER, emailInformationForSendDTO, EmailInformationForSendDTO.class);
    return HttpStatus.ACCEPTED.getReasonPhrase();
  }
}
