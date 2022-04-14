package ro.sd.a2.service.serviceImp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.sd.a2.domain.entity.Fee;
import ro.sd.a2.domain.entity.dto.FeeDto;
import ro.sd.a2.domain.entity.dto.StudentFeeDTO;
import ro.sd.a2.mapper.FeeMapper;
import ro.sd.a2.repository.FeeRepository;
import ro.sd.a2.service.FeeService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FeeServiceImpl implements FeeService {

  private final FeeRepository feeRepository;

  public FeeServiceImpl(FeeRepository feeRepository) {
    this.feeRepository = feeRepository;
  }

  /**
   *
   * @param studentId
   * @return List<StudentFeeDTO>
   */
  @Override
  public List<StudentFeeDTO> getAllStudentFee(String studentId) {
    log.debug("studentId :{}",studentId);
    List<Fee> feeList = feeRepository.getAllFeeByStudentId(studentId);
    return feeList.stream().map(FeeMapper::feeToStudentFeeDTO).collect(Collectors.toList());
  }

  /**
   *
   * @param feeId
   * @return String
   */
  @Override
  @Transactional
  public String pay(String feeId) {
    log.debug("feeId:{}",feeId);
    String message = "";
    try{
      feeRepository.updateFeeStatus("Payed",feeId);
      message = "Success";
    }catch (Exception ex){
      message = ex.getMessage();
    }
    log.debug("Response message:{}",message);
    return  message;
  }


}
