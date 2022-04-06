package ro.sd.a2.mapper;

import ro.sd.a2.domain.entity.Address;
import ro.sd.a2.domain.entity.PersonalInfo;
import ro.sd.a2.domain.entity.Teacher;
import ro.sd.a2.domain.entity.dto.NewTeacherDTO;
import ro.sd.a2.domain.entity.dto.TeacherDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TeacherMapper {

    public static TeacherDTO getTeacherDTO(Teacher teacher) {
        return TeacherDTO.builder()
                .teacherId(teacher.getTeacherId())
                .entitling(teacher.getEntitling())
                .name(teacher.getPersonalInfo().getName())
                .email(teacher.getPersonalInfo().getEmail())
                .npc(teacher.getPersonalInfo().getNpc())
                .addressList(teacher.getPersonalInfo().getAddressList())
                .build();
    }

    public static Collection<TeacherDTO> getTeacherDTOs(Collection<Teacher> teachers) {
        return teachers.stream().map(TeacherMapper::getTeacherDTO).collect(Collectors.toList());
    }

    public static Teacher getTeacherFromNewTeacherDTO(NewTeacherDTO newTeacherDTO) {
        Address address = Address.builder()
                .addressId(UUID.randomUUID().toString())
                .street(newTeacherDTO.getStreet())
                .city(newTeacherDTO.getCity())
                .country(newTeacherDTO.getCountry())
                .postalCode(newTeacherDTO.getPostalCode())
                .build();

        List<Address> addressList = new ArrayList<>();
        addressList.add(address);

        PersonalInfo personalInfo = PersonalInfo.builder()
                .personalInfoId(UUID.randomUUID().toString())
                .name(newTeacherDTO.getName())
                .password(newTeacherDTO.getPassword())
                .email(newTeacherDTO.getEmail())
                .npc(newTeacherDTO.getNpc())
                .addressList(addressList)
                .build();
        address.setPersonalInfo(personalInfo);

        return Teacher.builder()
                .teacherId(UUID.randomUUID().toString())
                .personalInfo(personalInfo)
                .entitling(newTeacherDTO.getEntitling())
                .build();
    }
}
