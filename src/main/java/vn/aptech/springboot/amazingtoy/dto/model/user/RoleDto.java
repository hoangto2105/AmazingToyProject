package vn.aptech.springboot.amazingtoy.dto.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Set;

/**
 * Created by Arpit Khandelwal.
 */
@Getter
@Setter
@Accessors(chain = true)
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleDto {

    private Long id;

    private String name;

    private Set<UserDto> userDtos;

    public RoleDto() {
    }

    public RoleDto(String role) {
        this.name = name;
    }

    public RoleDto(String role, Set<UserDto> userDtos) {
        this.name = name;
        this.userDtos = userDtos;
    }

    public RoleDto(Long id, String role, Set<UserDto> userDtos) {
        this.id = id;
        this.name = name;
        this.userDtos = userDtos;
    }
}
