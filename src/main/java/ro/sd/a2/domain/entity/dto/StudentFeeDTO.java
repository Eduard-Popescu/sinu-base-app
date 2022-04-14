package ro.sd.a2.domain.entity.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentFeeDTO {

  private String feeId;

  private String feeName;

  private double amount;

  private String status;


}
