package org.example.graduationprojectprocessmanagement.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.graduationprojectprocessmanagement.dox.Process;
import org.example.graduationprojectprocessmanagement.repository.ProcessRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeacherService {
    private final ProcessRepository processRepository;

    // 创建过程
    @Transactional
    public void addProcess(Process process) {
        processRepository.save(process);
    }
}
