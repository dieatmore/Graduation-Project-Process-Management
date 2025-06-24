package org.example.graduationprojectprocessmanagement.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.graduationprojectprocessmanagement.dox.ProcessScore;
import org.example.graduationprojectprocessmanagement.repository.ProcessScoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {
    private final ProcessScoreRepository processScoreRepository;

    // 获取某过程的评分
    public ProcessScore getProcessScore(String processId, String studentId) {
        return processScoreRepository.findByProcessIdAndStudentId(processId, studentId);
    }
}
