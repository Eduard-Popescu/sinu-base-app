package ro.sd.a2.domain.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
  private String classBookYear;

  @Column(name = "CLASS_BOOK_SEMESTER")
  private String classBookSemester;

}
