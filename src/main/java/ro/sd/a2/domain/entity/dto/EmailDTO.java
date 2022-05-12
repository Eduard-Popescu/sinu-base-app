package ro.sd.a2.domain.entity.dto;


import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class EmailDTO {

  private String receiverEmail;
  private String topic;
  private String description;
  private String subject;

}
