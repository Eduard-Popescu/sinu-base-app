package ro.sd.a2.domain.entity.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PayFeeDTO {

  private String feeId;

  private String studentId;

}
