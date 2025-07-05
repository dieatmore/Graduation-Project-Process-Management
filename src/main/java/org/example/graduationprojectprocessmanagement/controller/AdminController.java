package org.example.graduationprojectprocessmanagement.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.graduationprojectprocessmanagement.dox.Department;
import org.example.graduationprojectprocessmanagement.dox.User;
import org.example.graduationprojectprocessmanagement.service.AdminService;
import org.example.graduationprojectprocessmanagement.service.UserService;
import org.example.graduationprojectprocessmanagement.vo.ResultVO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("departments")
    public ResultVO listDepartments() {
        return ResultVO.success(adminService.listDepartments());
    }

    @PostMapping("departments")
    public ResultVO addDepartment(@RequestBody Department department) {
        adminService.addDepartment(department);
        return ResultVO.success(department);
    }

    @DeleteMapping("departments/{departmentId}")
    public ResultVO deleteDepartment(@PathVariable String departmentId) {
        adminService.deleteDepartment(departmentId);
        return ResultVO.ok();
    }

    @GetMapping("search/{name}")
    public ResultVO listSearch(@PathVariable String name) {
        List<Department> ds = adminService.searchByName(name);
        return ResultVO.success(ds);
    }

    @PostMapping("teachers/{departmentId}")
    public ResultVO teacherFile(@PathVariable String departmentId, @RequestBody ArrayList<User> teachers) {
        adminService.addUsers(departmentId,User.TEACHER,teachers);
        return ResultVO.ok();
    }
}
