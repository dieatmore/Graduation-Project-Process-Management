package org.example.graduationprojectprocessmanagement.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.graduationprojectprocessmanagement.dox.Department;
import org.example.graduationprojectprocessmanagement.exception.Code;
import org.example.graduationprojectprocessmanagement.exception.XException;
import org.example.graduationprojectprocessmanagement.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminService {
    private final DepartmentRepository departmentRepository;

    @Transactional
    public void addDepartment(Department department) {
        // 500错误
//        if (departmentRepository.existsByName(department.getName())) {
//            throw XException.builder().number(Code.ERROR).message("专业已存在").build();
//        }
        departmentRepository.save(department);
    }
}
