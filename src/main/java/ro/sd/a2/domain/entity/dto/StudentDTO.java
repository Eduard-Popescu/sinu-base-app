package ro.sd.a2.domain.entity.dto;

import lombok.*;
import ro.sd.a2.domain.entity.*;
import ro.sd.a2.domain.entity.Class;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDTO {

    private String studentId;

    private PersonalInfo personalInfo;

    private Class aClass;

    private List<ClassBook> classBooks;
}
