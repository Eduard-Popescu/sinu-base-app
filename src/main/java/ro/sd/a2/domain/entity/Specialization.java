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
@Table(name = "SPECIALIZATION")
public class Specialization {

  @Id
  @Column(name = "SPECIALIZATION_ID")
  private String specializationId;

  @Column(name = "SPECIALIZATION_NAME")
  private String specializationName;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FACULTY_ID")
  private Faculty faculty;
}
