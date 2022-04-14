package ro.sd.a2.service;

import ro.sd.a2.domain.entity.dto.FeeDto;
import ro.sd.a2.domain.entity.dto.StudentFeeDTO;

import java.util.List;

public interface FeeService {

  List<StudentFeeDTO> getAllStudentFee(String studentId);
  String pay(String feeId);

}
