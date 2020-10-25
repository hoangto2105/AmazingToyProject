package vn.aptech.springboot.amazingtoy.service;

import vn.aptech.springboot.amazingtoy.dto.model.user.UserDto;

public interface UserService {

    UserDto findUserByEmail(String email);

}
