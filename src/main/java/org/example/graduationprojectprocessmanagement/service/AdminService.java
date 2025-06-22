package org.example.graduationprojectprocessmanagement.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.graduationprojectprocessmanagement.dox.Department;
import org.example.graduationprojectprocessmanagement.exception.Code;
import org.example.graduationprojectprocessmanagement.exception.XException;
import org.example.graduationprojectprocessmanagement.repository.DepartmentRepository;
import org.example.graduationprojectprocessmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminService {
    private final DepartmentRepository departmentRepository;
    private final UserRepository userRepository;


    // 创建专业
    @Transactional
    public void addDepartment(Department department) {
//         500错误
//        if (departmentRepository.existsByName(department.getName())) {
//            throw XException.builder().number(Code.ERROR).message("专业已存在").build();
//        }
        departmentRepository.save(department);
    }

    // 查看所有专业
    public List<Department> listDepartments() {
        return departmentRepository.findAll();
    }

    // 删除没有用户的专业
    public void deleteDepartment(String departmentId) {
        if(userRepository.countByDepartmentId(departmentId) > 0) {
            throw XException.builder()
                    .number(Code.ERROR)
                    .message("专业有用户！")
                    .build();
        }
        departmentRepository.deleteById(departmentId);
    }
}
