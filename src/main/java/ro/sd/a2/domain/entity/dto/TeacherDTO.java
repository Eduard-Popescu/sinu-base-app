package ro.sd.a2.domain.entity.dto;

import lombok.*;
import ro.sd.a2.domain.entity.Address;
import ro.sd.a2.domain.entity.PersonalInfo;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeacherDTO {

    private String teacherId;

    private String entitling;

    private String name;

    private String email;

    private String npc;

    private List<Address> addressList;
}
