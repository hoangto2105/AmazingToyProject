package vn.aptech.springboot.amazingtoy.service;

import vn.aptech.springboot.amazingtoy.dto.model.user.RoleDto;

import java.util.List;

public interface RoleService {

    List<RoleDto> findAll();
}
