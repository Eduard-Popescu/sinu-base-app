package ro.sd.a2.mapper;

import org.springframework.stereotype.Component;
import ro.sd.a2.domain.entity.Fee;
import ro.sd.a2.domain.entity.dto.StudentFeeDTO;

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

}
