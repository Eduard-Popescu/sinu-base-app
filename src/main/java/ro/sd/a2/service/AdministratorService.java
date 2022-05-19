package ro.sd.a2.service;

import ro.sd.a2.domain.entity.dto.EmailDTO;

import java.util.List;

public interface AdministratorService {

  List<String> getInformationForEmailSend();
  String emailSender(EmailDTO emailDTO);

}
