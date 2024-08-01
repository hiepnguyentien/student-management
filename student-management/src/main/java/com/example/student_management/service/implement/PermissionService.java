package com.example.student_management.service.implement;

import com.example.student_management.dto.permission.PermissionRequest;
import com.example.student_management.dto.permission.PermissionResponse;
import com.example.student_management.mapper.PermissionMapper;
import com.example.student_management.model.Permission;
import com.example.student_management.repository.PermissionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

//    @PreAuthorize("hasRole('ADMIN')")
@PreAuthorize("hasAuthority('CREATE_PERMISSIONS')")
public PermissionResponse create(PermissionRequest request){
        Permission permission = permissionMapper.toPermission(request);
        permission = permissionRepository.save(permission);
        return permissionMapper.toPermissionResponse(permission);
    }

    @PreAuthorize("hasAuthority('FIND_ALL_PERMISSIONS')")
//    @PreAuthorize("hasRole('ADMIN')")
    public List<PermissionResponse> findAll(){
        var permissions = permissionRepository.findAll();
        return permissions.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    @PreAuthorize("hasAuthority('DELETE_PERMISSIONS')")
//    @PreAuthorize("hasRole('ADMIN')")
    public void delete(String permissionName){
        permissionRepository.deleteById(permissionName);
    }
}
