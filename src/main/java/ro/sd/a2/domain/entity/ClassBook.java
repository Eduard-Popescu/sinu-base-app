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
@Table(name = "CLASS_BOOK")
public class ClassBook {

  @Id
  @Column(name = "CLASS_BOOK_ID")
  private String classBookId;

  @Column(name = "CLASS_BOOK_YEAR")
  private Integer classBookYear;

  @Column(name = "CLASS_BOOK_SEMESTER")
  private Integer classBookSemester;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "STUDENT_ID", nullable = false)
  private Student student;

}
