package ro.sd.a2.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Data
@Table(name = "FEE")
public class Fee {

  @Id
  @Column(name = "FEE_ID")
  private String feeId;

  @Column(name = "FEE_NAME")
  private String feeName;

  @Column(name = "AMOUNT")
  private double amount;

  @Column(name = "STATUS")
  private String status;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "STUDENT_ID")
  private Student student;


}
