package com.example.student_management.mapper;

import com.example.student_management.dto.permission.PermissionRequest;
import com.example.student_management.dto.permission.PermissionResponse;
import com.example.student_management.model.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
