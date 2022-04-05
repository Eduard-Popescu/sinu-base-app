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
@Table(name = "PERSONAL_INFO")
public class PersonalInfo {

  @Id
  @Column(name = "PERSONAL_INFO_ID")
  private String personalInfoId;

  @Column(name = "NAME")
  private String name;

  @Column(name = "PASSWORD")
  private String password;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "NPC")
  private String npc;

  @OneToMany(mappedBy = "personalInfo" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Address> addressList;

}
