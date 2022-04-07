package ro.sd.a2.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassBookDTO {

  private String classBookId;

  private String classBookYear;

  private String classBookSemester;
}
