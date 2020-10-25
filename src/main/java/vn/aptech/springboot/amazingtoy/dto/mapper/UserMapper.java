package vn.aptech.springboot.amazingtoy.dto.mapper;

import org.springframework.transaction.annotation.Transactional;
import vn.aptech.springboot.amazingtoy.dto.model.user.AddressDto;
import vn.aptech.springboot.amazingtoy.dto.model.user.RoleDto;
import vn.aptech.springboot.amazingtoy.dto.model.user.UserDto;
import vn.aptech.springboot.amazingtoy.model.user.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Transactional
    public static UserDto toUserDto(User user) {
        return new UserDto()
                .setUserId(user.getUserId())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setPhoneNumber(user.getPhoneNumber())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setGender(user.getGender())
                .setDateOfBirth(user.getDateOfBirth())
                .setProfilePicture(user.getProfilePicture())
                .setStatus(user.isStatus())
                .setAddressDto(new ModelMapper().map(user.getAddress(), AddressDto.class))
                .setRoleDtos(new HashSet<RoleDto>(user
                    .getRoles()
                    .stream()
                    .map(role -> new ModelMapper().map(role, RoleDto.class))
                    .collect(Collectors.toSet())));
    }

}
