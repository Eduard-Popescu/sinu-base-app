package ro.sd.a2.domain.entity.dto;

import lombok.*;
import ro.sd.a2.annotations.FieldMatch;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@FieldMatch.List({
    @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
    @FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRegistrationDTO {

  @NotEmpty
  private String name;

  @NotEmpty
  private String password;

  @NotEmpty
  private String confirmPassword;

  @Email
  @NotEmpty
  private String email;

  @Email
  @NotEmpty
  private String confirmEmail;

  @NotEmpty
  private String npc;

  @NotEmpty
  private String street;

  @NotEmpty
  private String city;

  @NotEmpty
  private String country;

  @NotEmpty
  private String postalCode;

  @NotEmpty
  private String classId;

  @AssertTrue
  private Boolean terms;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getConfirmEmail() {
    return confirmEmail;
  }

  public void setConfirmEmail(String confirmEmail) {
    this.confirmEmail = confirmEmail;
  }

  public Boolean getTerms() {
    return terms;
  }

  public void setTerms(Boolean terms) {
    this.terms = terms;
  }
}
