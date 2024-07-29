package com.example.student_management.mapper;

import com.example.student_management.dto.role.RoleRequest;
import com.example.student_management.dto.role.RoleResponse;
import com.example.student_management.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest roleRequest);

    RoleResponse toRoleResponse(Role role);
}
