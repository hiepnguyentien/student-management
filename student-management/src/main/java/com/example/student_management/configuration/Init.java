package com.example.student_management.configuration;

import com.example.student_management.constant.PredefinedRole;
import com.example.student_management.model.Role;
import com.example.student_management.model.Lecturer;
import com.example.student_management.model.ManagementClass;
import com.example.student_management.repository.LecturerRepository;
import com.example.student_management.repository.RoleRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;

@Component
@Configuration
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Init implements CommandLineRunner {
    PasswordEncoder passwordEncoder;
    LecturerRepository lecturerRepository;
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (lecturerRepository.count() == 0) {
            ManagementClass managementClass = new ManagementClass();
            managementClass.setManagementClassId(9L);
            Role adminRole = roleRepository.save(Role.builder()
                        .name(PredefinedRole.ADMIN_ROLE)
                        .description("Admin role")
                        .build());
            
            var roles = new HashSet<Role>();
               roles.add(adminRole);
        
            Lecturer adminLecturer = Lecturer.builder()
                    .firstName("admin")
                    .lastName("admin")
                    .username("admin")
                    .password(passwordEncoder.encode("admin"))
                    .email("hiep8ams@gmail.com")
                    .phoneNumber("0379913071")
                    .address("1, 3, Quang Trung, Hà Đông")
                    .gender("nam")
                    .dateOfBirth(LocalDate.of(1990, 1, 1))
                    .facultyId(1L)
                    .managementClass(managementClass)
                    .roles(roles)
                    .build();
        
            lecturerRepository.save(adminLecturer);


        }
    }
}
