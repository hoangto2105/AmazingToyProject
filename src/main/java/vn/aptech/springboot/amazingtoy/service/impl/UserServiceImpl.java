package vn.aptech.springboot.amazingtoy.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import vn.aptech.springboot.amazingtoy.dto.mapper.UserMapper;
import vn.aptech.springboot.amazingtoy.dto.model.user.UserDto;
import vn.aptech.springboot.amazingtoy.exception.ApplicationException;
import vn.aptech.springboot.amazingtoy.exception.EntityType;
import vn.aptech.springboot.amazingtoy.exception.ExceptionType;
import vn.aptech.springboot.amazingtoy.model.user.Address;
import vn.aptech.springboot.amazingtoy.model.user.Role;
import vn.aptech.springboot.amazingtoy.model.user.User;
import vn.aptech.springboot.amazingtoy.repository.user.AddressRepository;
import vn.aptech.springboot.amazingtoy.repository.user.RoleRepository;
import vn.aptech.springboot.amazingtoy.repository.user.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import vn.aptech.springboot.amazingtoy.service.UserService;
import vn.aptech.springboot.amazingtoy.util.FileUtil;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static vn.aptech.springboot.amazingtoy.exception.EntityType.USER;
import static vn.aptech.springboot.amazingtoy.exception.ExceptionType.DUPLICATE_ENTITY;
import static vn.aptech.springboot.amazingtoy.exception.ExceptionType.ENTITY_NOT_FOUND;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    private final String PROFILE_IMAGE_PATH = "backend/dist/img/user-picture";


    @Transactional
    public UserDto findByEmail(String email) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));
        if (user.isPresent()) {
            return UserMapper.toUserDto(user.get());
        }
        throw exception(USER, ENTITY_NOT_FOUND, email);
    }

    @Override
    public UserDto findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return UserMapper.toUserDto(user.get());
        }
        throw exception(USER, ENTITY_NOT_FOUND, id.toString());
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> userDtos.add(UserMapper.toUserDto(user)));

        return userDtos;

    }

    @Override
    public UserDto register(UserDto userDto, MultipartFile profilePicture) throws IOException {
        Set<Role> roles = new HashSet<>();
        Optional<Role> role = roleRepository.findById(Long.parseLong(userDto.getRole()));
        User user = userRepository.findByEmail(userDto.getEmail());

        try {
            String uniqueFileName = FileUtil.UploadedFile(profilePicture, PROFILE_IMAGE_PATH);

            if (user == null) {
                roles.add(role.get());
                user = new User()
                        .setEmail(userDto.getEmail())
                        .setEmailConfirmed(true)
                        .setPassword(passwordEncoder.encode(userDto.getPassword()))
                        .setPhoneNumber(userDto.getPhoneNumber())
                        .setPhoneConfirmed(true)
                        .setFirstName(userDto.getFirstName())
                        .setLastName(userDto.getLastName())
                        .setGender(userDto.getGender())
                        .setDateOfBirth(userDto.getDateOfBirth())
                        .setProfilePicture(uniqueFileName)
                        .setAddress(addressRepository.save(new Address()))
                        .setRoles(roles);
                return UserMapper.toUserDto(userRepository.save(user));
            }
            throw exception(USER, DUPLICATE_ENTITY, userDto.getEmail());
        } catch (IOException ioException) {
            throw new RuntimeException(ioException.getMessage());
        }

    }

    @Override
    public UserDto update(UserDto userDto, MultipartFile filePicture) throws IOException {
        Optional<User> user = userRepository.findById(userDto.getId());
        String uniqueFileName = null;

        if (user.isPresent()) {
            User userUpdate = user.get();
            String originPicture = userUpdate.getProfilePicture();
            if (!(userDto.getPassword().isEmpty())) {
                userUpdate.setPassword(passwordEncoder.encode(userDto.getPassword()));
            }
            if (!filePicture.isEmpty()) {
                uniqueFileName = FileUtil.UploadedFile(filePicture, PROFILE_IMAGE_PATH);
                if (uniqueFileName != null) {
                    userUpdate.setProfilePicture(uniqueFileName);
                    FileUtil.DeletedFile(PROFILE_IMAGE_PATH, originPicture);
                }
            }
            userUpdate.setPhoneNumber(userDto.getPhoneNumber());
            userUpdate.setFirstName(userDto.getFirstName());
            userUpdate.setLastName(userDto.getLastName());
            userUpdate.setGender(userDto.getGender());
            userUpdate.setDateOfBirth(userDto.getDateOfBirth());


            return UserMapper.toUserDto(userRepository.save(userUpdate));
        }
        throw exception(USER, ENTITY_NOT_FOUND, userDto.getId().toString());
    }

    @Override
    public void delete(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        } else {
            throw exception(USER, ENTITY_NOT_FOUND, id.toString());
        }
    }

    private RuntimeException exception(EntityType entityType, ExceptionType exceptionType, String... args) {
        return ApplicationException.throwException(entityType, exceptionType, args);
    }
}
