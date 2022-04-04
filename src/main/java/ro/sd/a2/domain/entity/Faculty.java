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
@Table(name = "FACULTY")
public class Faculty {

  @Id
  @Column(name = "FACULTY_ID")
  private String facultyId;

  @Column(name = "FACULTY_NAME")
  private String facultyName;
}
