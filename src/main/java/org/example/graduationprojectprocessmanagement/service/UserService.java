package org.example.graduationprojectprocessmanagement.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.graduationprojectprocessmanagement.dox.Process;
import org.example.graduationprojectprocessmanagement.dox.User;
import org.example.graduationprojectprocessmanagement.exception.Code;
import org.example.graduationprojectprocessmanagement.exception.XException;
import org.example.graduationprojectprocessmanagement.repository.ProcessRepository;
import org.example.graduationprojectprocessmanagement.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ProcessRepository processRepository;

    public User getUser(String number) {
        return userRepository.findByNumber(number);
    }

    // 修改密码
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
        userRepository.save(user);
    }

    // 获取对应权限过程
    public List<Process> listProcesses(String departmentId,String role) {
        // 如果为学生，查看BOTH_AUTH权限的子项
        if (role.equals(User.STUDENT)) {
            return processRepository.findByDepartmentIdAndAuth(departmentId,Process.BOTH_AUTH);
        }
        // 导师查看所有子项
        return processRepository.findByDepartmentId(departmentId);
    }



}
