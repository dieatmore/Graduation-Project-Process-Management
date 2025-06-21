package org.example.graduationprojectprocessmanagement.service;

import lombok.RequiredArgsConstructor;
import org.example.graduationprojectprocessmanagement.dox.User;
import org.example.graduationprojectprocessmanagement.repository.UserRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InitService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        String name = "admin";
        if(userRepository.count() > 0) {
            return;
        }
        User admin = User.builder()
                .name(name)
                .number(name)
                .password(passwordEncoder.encode(name))
                .role(User.ADMIN)
                .departmentId(name)
                .build();
        userRepository.save(admin);
    }
}
