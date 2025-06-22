package org.example.graduationprojectprocessmanagement.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.graduationprojectprocessmanagement.dox.Process;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ProcessRepositoryTest {

    @Autowired
    private ProcessRepository processRepository;

    @Test
    void findByDepartmentIdAndAuth() {
         List<Process> p = processRepository.findByDepartmentIdAndAuth("1385868917132124160","TEA01");
         log.debug("{}",p);
    }

    @Test
    void findByDepartmentId() {
        List<Process> p = processRepository.findByDepartmentId("1385868917132124160");
        log.debug("{}",p);
    }
}