package org.example.graduationprojectprocessmanagement.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.graduationprojectprocessmanagement.dox.Department;
import org.example.graduationprojectprocessmanagement.service.AdminService;
import org.example.graduationprojectprocessmanagement.service.UserService;
import org.example.graduationprojectprocessmanagement.vo.ResultVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/admin/")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping("departments")
    public ResultVO addDepartment(@RequestBody Department department) {
        adminService.addDepartment(department);
        return ResultVO.success(department);
    }
}
