package org.example.graduationprojectprocessmanagement.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.graduationprojectprocessmanagement.dox.ProcessScore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ProcessScoreRepositoryTest {

    @Autowired
    private ProcessScoreRepository processScoreRepository;

}