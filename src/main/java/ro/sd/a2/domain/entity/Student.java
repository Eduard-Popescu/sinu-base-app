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
@Table(name = "STUDENT")
public class Student {

  @Id
  @Column(name = "STUDENT_ID")
  private String studentId;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "PERSONAL_INFO_ID")
  private PersonalInfo personalInfo;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "CLASS_ID")
  private Class aClass;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "CLASS_BOOK_ID")
  private ClassBook classBook;

}
