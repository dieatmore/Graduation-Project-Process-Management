package org.example.graduationprojectprocessmanagement.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.graduationprojectprocessmanagement.dox.ProcessScore;
import org.example.graduationprojectprocessmanagement.service.StudentService;
import org.example.graduationprojectprocessmanagement.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/student/")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("processScore/{processId}")
    public ResultVO getProcessScore(@PathVariable String processId, @RequestAttribute("uid") String studentId) {
        ProcessScore ps = studentService.getProcessScore(processId,studentId);
        return ResultVO.success(ps);
    }
}
