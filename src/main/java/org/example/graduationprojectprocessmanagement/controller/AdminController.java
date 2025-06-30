package org.example.graduationprojectprocessmanagement.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.graduationprojectprocessmanagement.dox.Department;
import org.example.graduationprojectprocessmanagement.service.AdminService;
import org.example.graduationprojectprocessmanagement.service.UserService;
import org.example.graduationprojectprocessmanagement.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

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
}
