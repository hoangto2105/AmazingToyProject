package vn.aptech.springboot.amazingtoy.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import vn.aptech.springboot.amazingtoy.dto.mapper.UserMapper;
import vn.aptech.springboot.amazingtoy.dto.model.user.UserDto;
import vn.aptech.springboot.amazingtoy.exception.ApplicationException;
import vn.aptech.springboot.amazingtoy.exception.EntityType;
import vn.aptech.springboot.amazingtoy.exception.ExceptionType;
import vn.aptech.springboot.amazingtoy.model.user.Role;
import vn.aptech.springboot.amazingtoy.model.user.User;
import vn.aptech.springboot.amazingtoy.repository.user.RoleRepository;
import vn.aptech.springboot.amazingtoy.repository.user.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import vn.aptech.springboot.amazingtoy.service.UserService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import static vn.aptech.springboot.amazingtoy.exception.EntityType.USER;
import static vn.aptech.springboot.amazingtoy.exception.ExceptionType.DUPLICATE_ENTITY;
import static vn.aptech.springboot.amazingtoy.exception.ExceptionType.ENTITY_NOT_FOUND;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public UserDto findUserByEmail(String email) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));
        if (user.isPresent()) {
            return UserMapper.toUserDto(user.get());
        }
        throw exception(USER, ENTITY_NOT_FOUND, email);
    }

    private RuntimeException exception(EntityType entityType, ExceptionType exceptionType, String... args) {
        return ApplicationException.throwException(entityType, exceptionType, args);
    }
}
