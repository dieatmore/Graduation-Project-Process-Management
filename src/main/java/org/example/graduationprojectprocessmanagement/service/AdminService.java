package org.example.graduationprojectprocessmanagement.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.graduationprojectprocessmanagement.dox.Department;
import org.example.graduationprojectprocessmanagement.dox.User;
import org.example.graduationprojectprocessmanagement.exception.Code;
import org.example.graduationprojectprocessmanagement.exception.XException;
import org.example.graduationprojectprocessmanagement.repository.DepartmentRepository;
import org.example.graduationprojectprocessmanagement.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminService {
    private final DepartmentRepository departmentRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // 创建专业
    @Transactional
    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    // 查看所有专业
    public List<Department> listDepartments() {
        return departmentRepository.findAll();
    }

    // 删除没有用户的专业
    @Transactional
    public void deleteDepartment(String departmentId) {
        if(userRepository.countByDepartmentId(departmentId) > 0) {
            throw XException.builder()
                    .number(Code.ERROR)
                    .message("专业有用户！")
                    .build();
        }
        departmentRepository.deleteById(departmentId);
    }

    // 根据名称模糊搜索专业
    public List<Department> searchByName(String name) {
        return departmentRepository.findByNameContaining(name);
    }

    // 添加老师(to learn 批量处理)
    @Transactional
    public void addUsers(String departmentId, String role, ArrayList<User> users) {
        users.forEach(teacher -> {
            teacher.setDepartmentId(departmentId);
            teacher.setPassword(passwordEncoder.encode(teacher.getNumber()));
            teacher.setRole(role);
            userRepository.save(teacher);
        });
//        for (User user : users) {
//            user.setDepartmentId(departmentId);
//            user.setPassword(passwordEncoder.encode(user.getNumber()));
//            user.setRole(role);
//        }
//        userRepository.saveAll(users);
    }
}
