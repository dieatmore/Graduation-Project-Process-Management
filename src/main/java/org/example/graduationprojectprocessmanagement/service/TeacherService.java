package org.example.graduationprojectprocessmanagement.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.graduationprojectprocessmanagement.dox.Process;
import org.example.graduationprojectprocessmanagement.exception.Code;
import org.example.graduationprojectprocessmanagement.exception.XException;
import org.example.graduationprojectprocessmanagement.repository.ProcessRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    // 删除过程
    @Transactional
    public void deleteProcess(String processId) {
        processRepository.deleteById(processId);
    }

    // 修改过程
    @Transactional
    public void updateProcess(String departmentId,Process process) {
        Process p = processRepository.findByIdAndDepartmentId(process.getId(),departmentId);
        p.setName(process.getName());
        p.setItems(process.getItems());
        p.setPoint(process.getPoint());
        p.setAuth(process.getAuth());
        p.setStudent_attach(process.getStudent_attach());
        processRepository.save(p);
    }
}
