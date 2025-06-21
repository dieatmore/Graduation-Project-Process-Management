package org.example.graduationprojectprocessmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.graduationprojectprocessmanagement.exception.Code;
import org.example.graduationprojectprocessmanagement.exception.XException;
import org.example.graduationprojectprocessmanagement.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ExceptionController {

    @ExceptionHandler(XException.class)
    public ResultVO handleXException(XException e) {
        if (e.getCode() != null) {
            return ResultVO.error(e.getCode());
        }
        return ResultVO.error(e.getNumber(),e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResultVO handleException(Exception e) {
        return ResultVO.error(Code.ERROR,e.getMessage());
    }
}
