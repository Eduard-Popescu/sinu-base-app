package ro.sd.a2.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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

  @OneToMany(mappedBy = "student" ,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private List<ClassBook> classBooks;

}
