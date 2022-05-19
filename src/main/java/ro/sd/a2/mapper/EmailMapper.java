package ro.sd.a2.mapper;

import org.springframework.stereotype.Component;
import ro.sd.a2.domain.entity.PersonalInfo;
import ro.sd.a2.domain.entity.dto.EmailDTO;
import ro.sd.a2.domain.entity.dto.EmailInformationForSendDTO;

@Component
public class EmailMapper {

  public static EmailInformationForSendDTO emailInformationForSendMapper(PersonalInfo personalInfo, EmailDTO emailDTO){
    return EmailInformationForSendDTO.builder()
        .description(emailDTO.getDescription())
        .receiverEmail(emailDTO.getReceiverEmail())
        .subject(emailDTO.getSubject())
        .topic(emailDTO.getTopic())
        .receiverName(personalInfo.getName())
        .build();
  }

}
