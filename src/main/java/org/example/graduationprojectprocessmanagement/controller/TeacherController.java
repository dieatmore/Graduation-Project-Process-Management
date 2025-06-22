package org.example.graduationprojectprocessmanagement.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.graduationprojectprocessmanagement.dox.Process;
import org.example.graduationprojectprocessmanagement.dox.ProcessScore;
import org.example.graduationprojectprocessmanagement.dox.User;
import org.example.graduationprojectprocessmanagement.service.TeacherService;
import org.example.graduationprojectprocessmanagement.service.UserService;
import org.example.graduationprojectprocessmanagement.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/teacher/")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    private final UserService userService;

    @PostMapping("process")
    public ResultVO addProcess(@RequestBody Process process, @RequestAttribute("departmentId") String departmentId ) {
        process.setDepartmentId(departmentId);
        teacherService.addProcess(process);
        return ResultVO.success(process);
    }

    @DeleteMapping("process/{processId}")
    public ResultVO deleteProcess(@PathVariable String processId) {
        teacherService.deleteProcess(processId);
        return ResultVO.ok();
    }

    @PatchMapping("process")
    public ResultVO updateProcess(@RequestBody Process process, @RequestAttribute("departmentId") String departmentId) {
        teacherService.updateProcess(departmentId,process);
        return ResultVO.success(process);
    }

    @GetMapping("students/teach")
    public ResultVO listStudentsWho(@RequestAttribute("departmentId") String departmentId,@RequestAttribute("uid") String teacherId) {
        List<User> u = teacherService.listStudentsWho(departmentId,teacherId);
        return ResultVO.success(u);
    }

    @GetMapping("students/group")
    public ResultVO listGroupUser(@RequestAttribute("departmentId") String departmentId,@RequestAttribute("groupNumber") int groupNumber) {
        List<User> u = teacherService.listGroupUser(departmentId,groupNumber);
        return ResultVO.success(u);
    }

    @PostMapping("processScore/{studentId}/{processId}")
    public ResultVO mark(@PathVariable String studentId,@PathVariable String processId,@RequestAttribute("uid") String teacherId,@RequestBody ProcessScore processScore) {
        teacherService.mark(processScore,studentId,processId,teacherId);
        return ResultVO.success(processScore);
    }
}
