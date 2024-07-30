package com.example.student_management.service.implement;

import com.example.student_management.dto.role.RoleRequest;
import com.example.student_management.dto.role.RoleResponse;
import com.example.student_management.mapper.RoleMapper;
import com.example.student_management.repository.PermissionRepository;
import com.example.student_management.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    RoleMapper roleMapper;

    public RoleResponse createRole(RoleRequest request) {
        var role = roleMapper.toRole(request);

        var permissions = permissionRepository.findAllById(request.getPermission());
        role.setPermissions(new HashSet<>(permissions));

        role = roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }

    public List<RoleResponse> getAllRoles() {
        return roleRepository.findAll()
                .stream().map(roleMapper::toRoleResponse)
                .toList();
    }

    public void deleteRole(String role) {
        roleRepository.deleteById(role);
    }
}