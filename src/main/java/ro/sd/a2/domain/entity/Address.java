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
@Table(name = "ADDRESS")
public class Address {

  @Id
  @Column(name = "ADDRESS_ID")
  private String addressId;

  @Column(name = "STREET")
  private String street;

  @Column(name = "CITY")
  private String city;

  @Column(name = "COUNTRY")
  private String country;

  @Column(name = "POSTAL_CODE")
  private String postalCode;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PERSONAL_INFO_ID", nullable = false)
  private PersonalInfo personalInfo;

}
