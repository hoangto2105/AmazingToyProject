package vn.aptech.springboot.amazingtoy.dto.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;
import vn.aptech.springboot.amazingtoy.model.user.Address;
import vn.aptech.springboot.amazingtoy.model.user.User;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private String userId;
    private String email;
    private boolean emailConfirmed;
    private String password;
    private String phoneNumber;
    private boolean phoneConfirmed;
    private String firstName;
    private String lastName;
    public User.GenderType gender;
    public Date dateOfBirth;
    public String profilePicture;
    public boolean status = false;
    public AddressDto addressDto;
    private Set<RoleDto> roleDtos;

    public UserDto() {
    }

    public UserDto(String email, boolean emailConfirmed, String password, String phoneNumber, boolean phoneConfirmed, String firstName, String lastName, User.GenderType gender, Date dateOfBirth, String profilePicture, boolean status, AddressDto addressDto, Set<RoleDto> roleDtos) {
        this.email = email;
        this.emailConfirmed = emailConfirmed;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.phoneConfirmed = phoneConfirmed;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.profilePicture = profilePicture;
        this.status = status;
        this.addressDto = addressDto;
        this.roleDtos = roleDtos;
    }

    public UserDto(String userId, String email, boolean emailConfirmed, String password, String phoneNumber, boolean phoneConfirmed, String firstName, String lastName, User.GenderType gender, Date dateOfBirth, String profilePicture, boolean status, AddressDto addressDto, Set<RoleDto> roleDtos) {
        this.userId = userId;
        this.email = email;
        this.emailConfirmed = emailConfirmed;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.phoneConfirmed = phoneConfirmed;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.profilePicture = profilePicture;
        this.status = status;
        this.addressDto = addressDto;
        this.roleDtos = roleDtos;
    }

    public String getFullName() {
        return firstName != null ? firstName.concat(" ").concat(lastName) : "";
    }
}
