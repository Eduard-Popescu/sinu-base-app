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
@Table(name = "ADMINISTRATOR")
public class Administrator {

  @Id
  @Column(name = "ADMINISTRATOR_ID")
  private String administratorId;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "PERSONAL_INFO_ID")
  private PersonalInfo personalInfo;

}
