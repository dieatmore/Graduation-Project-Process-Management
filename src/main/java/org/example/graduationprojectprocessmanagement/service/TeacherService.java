package org.example.graduationprojectprocessmanagement.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.graduationprojectprocessmanagement.dox.Process;
import org.example.graduationprojectprocessmanagement.dox.ProcessScore;
import org.example.graduationprojectprocessmanagement.dox.User;
import org.example.graduationprojectprocessmanagement.dto.ProcessScoreUserDTO;
import org.example.graduationprojectprocessmanagement.exception.Code;
import org.example.graduationprojectprocessmanagement.exception.XException;
import org.example.graduationprojectprocessmanagement.repository.ProcessRepository;
import org.example.graduationprojectprocessmanagement.repository.ProcessScoreRepository;
import org.example.graduationprojectprocessmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeacherService {
    private final ProcessRepository processRepository;
    private final UserRepository userRepository;
    private final ProcessScoreRepository processScoreRepository;

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

    // 获取该导师指导的所有学生
    public List<User> listStudentsWho(String departmentId, String teacherId) {
        return userRepository.findStudentByTeacherId(departmentId,teacherId);
    }

    // 获取导师所在组的学生
    public List<User> listGroupUser(String departmentId, int groupNumber) {
        return userRepository.findByRoleAndGroupNumber(departmentId,User.STUDENT,groupNumber);
    }

    // 给所在分组学生的过程打分
    @Transactional
    public void mark(ProcessScore processScore,String studentId,String processId,String teacherId) {
        if (processScore.getId()==null) {
            processScore.setStudentId(studentId);
            processScore.setProcessId(processId);
            processScore.setTeacherId(teacherId);
            processScoreRepository.save(processScore);
        } else {
            processScoreRepository.updateScore(processScore.getId(),processScore.getDetail());
        }
    }

//    // 查看该导师给某过程的评分 ---考虑后觉得没有该视图，舍去
//    public List<ProcessScore> listProcessScore(String teacherId, String processId) {
//        return processScoreRepository.findByTeacherIdAndProcessId(teacherId, processId);
//    }

     // 查看该导师指导的所有学生的某过程的评分
    public List<ProcessScoreUserDTO> listProcessScoreTeacher(String teacherId, String processId) {
        return processScoreRepository.findByUteacherId(teacherId,processId);
    }

    // 查看该导师所在组的所有学生的某过程的评分
    public List<ProcessScoreUserDTO> listProcessScoreGroup(String departmentId, String processId, int groupNumber,String teacherId) {
        return processScoreRepository.findByGroupNumber(departmentId,processId,groupNumber,teacherId);
    }
}
