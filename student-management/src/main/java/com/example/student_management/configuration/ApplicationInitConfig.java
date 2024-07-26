//package com.example.student_management.configuration;
//
//import com.example.student_management.enums.Role;
//import com.example.student_management.model.Lecturer;
//import com.example.student_management.repository.LecturerRepository;
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.HashSet;
//
//@Configuration
//@RequiredArgsConstructor
//@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
//@Slf4j
//public class ApplicationInitConfig {
//
//    PasswordEncoder passwordEncoder;
//
//    @Bean
//    ApplicationRunner applicationRunner(LecturerRepository lecturerRepository){
//        return args -> {
//            if (lecturerRepository.findByUsername("admin").isEmpty()){
//                var roles = new HashSet<String>();
//                roles.add(Role.ADMIN.name());
//                Lecturer lecturer = Lecturer.builder()
//                        .username("admin")
//                        .password(passwordEncoder.encode("admin"))
//                        .roles(roles)
//                        .build();
//
//                lecturerRepository.save(lecturer);
//                log.warn("admin user has been created with default password: admin, please change it");
//            }
//        };
//    }
//}
