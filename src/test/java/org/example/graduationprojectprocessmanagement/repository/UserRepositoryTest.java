package org.example.graduationprojectprocessmanagement.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.graduationprojectprocessmanagement.dox.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findStudentByTeacherId() {
        List<User> u = userRepository.findStudentByTeacherId("1385868917132124160","1385826789966927296");
        log.debug("{}",u);
    }

    @Test
    void countByDepartmentId() {
        int a = userRepository.countByDepartmentId("1385885254290137088");
        log.debug("用户个数为：{}",a);
    }

}