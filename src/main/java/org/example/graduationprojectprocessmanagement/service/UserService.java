package org.example.graduationprojectprocessmanagement.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.graduationprojectprocessmanagement.dox.User;
import org.example.graduationprojectprocessmanagement.exception.Code;
import org.example.graduationprojectprocessmanagement.exception.XException;
import org.example.graduationprojectprocessmanagement.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User getUser(String number) {
        return userRepository.findByNumber(number);
    }

    @Transactional
    public void updateUserPassword(String number) {
        User user = userRepository.findByNumber(number);
        if (user == null) {
            throw  XException.builder()
                    .number(Code.ERROR)
                    .message("用户不存在")
                    .build();
        }
        user.setPassword(passwordEncoder.encode(number));
    }

    @Transactional
    public void updateUserPasswordById(String uid, String password) {
        User user = userRepository.findById(uid).orElse(null);
        if (user == null) {
            throw  XException.builder()
                    .number(Code.ERROR)
                    .message("用户不存在")
                    .build();
        }
        user.setPassword(passwordEncoder.encode(password));
    }
}
