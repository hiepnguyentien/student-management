package com.example.student_management.service.implement;

import com.example.student_management.dto.authentication.AuthenticationRequest;
import com.example.student_management.dto.authentication.AuthenticationResponse;
import com.example.student_management.exception.AppException;
import com.example.student_management.exception.ErrorCode;
import com.example.student_management.repository.StudentRepository;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class AuthenticationService {
    StudentRepository studentRepository;
    MessageSource messageSource;

    @NonFinal
    protected static final String SIGNER_KEY =
            "HlGkehtqKtJEkg48o3alJctXyqmGGlKHgeMtTcU3rh96r+WPzS3thkwQx5daQd9Q";

    public AuthenticationResponse authenticate(AuthenticationRequest request, Locale locale){
        var student = studentRepository
                .findByUsername(request.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.STUDENT_NOT_FOUND, messageSource, locale));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean authenticated = passwordEncoder.matches(request.getPassword(), student.getPassword());

        if(!authenticated){
            throw new AppException(ErrorCode.UNAUTHORIZED, messageSource, locale);
        }
        var token = generateToken(request.getUsername());

        return AuthenticationResponse.builder()
                .token(token)
                .authenticated(true)
                .build();
    }
    private String generateToken(String username){
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(username)
                .issuer("hiep.com")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                ))
                .claim("customClaim", "Custom")
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);

        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            log.error("Cannot create token: ", e);
            throw new RuntimeException(e);
        }
    }
}
