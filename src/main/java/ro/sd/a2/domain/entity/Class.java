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
@Table(name = "CLASS")
public class Class {

  @Id
  @Column(name = "CLASS_ID")
  private String classId;

  @Column(name = "CLASS_NAME")
  private String className;

  @Column(name = "SERIES_NAME")
  private String seriesName;

  @Column(name = "CLASS_YEAR")
  private String classYear;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "SPECIALIZATION_ID")
  private Specialization specialization;

}
