package ro.sd.a2.mapper;

import org.springframework.stereotype.Component;
import ro.sd.a2.domain.entity.Fee;
import ro.sd.a2.domain.entity.dto.FeeInformationToSendDTO;
import ro.sd.a2.domain.entity.dto.StudentFeeDTO;

import java.time.LocalDate;

@Component
public class FeeMapper  {

  public static StudentFeeDTO feeToStudentFeeDTO(Fee fee){
    return StudentFeeDTO.builder()
        .feeId(fee.getFeeId())
        .feeName(fee.getFeeName())
        .amount(fee.getAmount())
        .status(fee.getStatus())
        .build();
  }

  public static FeeInformationToSendDTO feeToFeeInformationToSendDTO(Fee fee){
    return FeeInformationToSendDTO.builder()
        .dateOfPayment(LocalDate.now().toString())
        .feeAmount(fee.getAmount())
        .studentName(fee.getStudent().getPersonalInfo().getName())
        .feeName(fee.getFeeName())
        .studentEmail(fee.getStudent().getPersonalInfo().getEmail())
        .build();
  }

}
