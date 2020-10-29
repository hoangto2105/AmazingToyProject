package vn.aptech.springboot.amazingtoy.controller.v1.command;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;
import vn.aptech.springboot.amazingtoy.dto.model.user.RoleDto;
import vn.aptech.springboot.amazingtoy.model.user.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Data
@Accessors(chain = true)
public class UserRegisterFormCommand {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 5)
    private String password;

    @NotBlank
    @Size(min = 5, max = 13)
    private String phoneNumber;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private User.GenderType gender;

    public Date dateOfBirth;

    private MultipartFile profilePicture;

    private String role;

    public enum GenderType {
        Male,
        Female
    }

}
