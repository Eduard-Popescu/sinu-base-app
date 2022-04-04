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
@Table(name = "TEACHER")
public class Teacher {

  @Id
  @Column(name = "TEACHER_ID")
  private String teacherId;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "PERSONAL_INFO_ID")
  private PersonalInfo personalInfo;

  @Column(name = "ENTITLING")
  private String entitling;

}
