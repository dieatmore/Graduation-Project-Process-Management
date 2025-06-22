package org.example.graduationprojectprocessmanagement.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.graduationprojectprocessmanagement.component.JWTComponent;
import org.example.graduationprojectprocessmanagement.exception.Code;
import org.example.graduationprojectprocessmanagement.exception.XException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {
    private final JWTComponent jwtComponent;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if(token == null) {
            throw XException.builder().code(Code.UNAUTHORIZED).build();
        }
        DecodedJWT decode = jwtComponent.decode(token);
        String uid = decode.getClaim("uid").asString();
        String role = decode.getClaim("role").asString();
        String departmentId = decode.getClaim("departmentId").asString();
        request.setAttribute("uid",uid);
        request.setAttribute("role",role);
        request.setAttribute("departmentId",departmentId);
        if (!decode.getClaim("groupNumber").isMissing()) {
            request.setAttribute("groupNumber", decode.getClaim("groupNumber").asInt());
        }
        return true;
    }
}
