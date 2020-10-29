package vn.aptech.springboot.amazingtoy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.springboot.amazingtoy.dto.mapper.RoleMapper;
import vn.aptech.springboot.amazingtoy.dto.model.user.RoleDto;
import vn.aptech.springboot.amazingtoy.model.user.Role;
import vn.aptech.springboot.amazingtoy.repository.user.RoleRepository;
import vn.aptech.springboot.amazingtoy.service.RoleService;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleDto> findAll() {
        List<Role> roles = roleRepository.findAll();
        List<RoleDto> roleDtos = new ArrayList<>();
        roles.forEach(role -> roleDtos.add(RoleMapper.toRoleDto(role)));

        return roleDtos;
    }
}
