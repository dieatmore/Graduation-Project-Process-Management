package org.example.graduationprojectprocessmanagement.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.graduationprojectprocessmanagement.component.JWTComponent;
import org.example.graduationprojectprocessmanagement.dox.User;
import org.example.graduationprojectprocessmanagement.exception.Code;
import org.example.graduationprojectprocessmanagement.service.UserService;
import org.example.graduationprojectprocessmanagement.vo.ResultVO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class LoginController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JWTComponent jwtComponent;
    @PostMapping("login")
    public ResultVO login(@RequestBody User user, HttpServletResponse response) {
        User userR = userService.getUser(user.getNumber());
        if(userR == null || !passwordEncoder.matches(user.getPassword(), userR.getPassword())) {
            return ResultVO.error(Code.LOGIN_ERROR);
        }
        String token = null;
        if(userR.getGroupNumber()!=null) {
            token = jwtComponent.encode(Map.of("uid",userR.getId(),"role",userR.getRole(),"departmentId",userR.getDepartmentId(),"groupNumber",userR.getGroupNumber()));
        } else {
            token = jwtComponent.encode(Map.of("uid",userR.getId(),"role",userR.getRole(),"departmentId",userR.getDepartmentId()));
        }
        response.setHeader("token",token);
        response.setHeader("role", userR.getRole());
        return ResultVO.success(userR);
    }
}