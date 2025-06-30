package org.example.graduationprojectprocessmanagement.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.graduationprojectprocessmanagement.dox.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.security.auth.login.LoginContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void existsByName() {
        boolean result = departmentRepository.existsByName("软件工程");
        log.debug("存在：{}",result);
    }

    @Test
    void findByNameContaining() {
        List<Department> ds = departmentRepository.findByNameContaining("工");
        log.debug(ds.toString());
    }
}