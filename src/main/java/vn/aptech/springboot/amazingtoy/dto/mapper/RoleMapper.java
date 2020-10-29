package vn.aptech.springboot.amazingtoy.dto.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import vn.aptech.springboot.amazingtoy.dto.model.user.RoleDto;
import vn.aptech.springboot.amazingtoy.dto.model.user.UserDto;
import vn.aptech.springboot.amazingtoy.model.user.Role;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class RoleMapper {

    public static RoleDto toRoleDto(Role role) {
        return new RoleDto()
                .setId(role.getId())
                .setName(role.getName())
                .setUserDtos(new HashSet<UserDto>(role
                        .getUsers()
                        .stream()
                        .map(user -> new ModelMapper().map(user, UserDto.class))
                        .collect(Collectors.toSet())
                ));

    }
}
