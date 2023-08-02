package com.example.kakao._core.errors;

import com.example.kakao._core.errors.exception.*;
import com.example.kakao.log.ErrorLog;
import com.example.kakao.log.ErrorLogJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RequiredArgsConstructor
@Component
public class GlobalExceptionHandler {

    private final ErrorLogJPARepository errorLogJPARepository;

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException e, HttpServletRequest request) {
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            errors.add(violation.getMessage());
        }

        ErrorLog errorLog = ErrorLog.builder()
                .message(errors.toString())
                .userAgent(request.getHeader("User-Agent"))
                .userIp(request.getRemoteAddr())
                .build();
        errorLogJPARepository.save(errorLog);

        Exception400 ex = new Exception400(errors.get(0));
        return new ResponseEntity<>(
                ex.body(),
                ex.status()
        );
    }

    public ResponseEntity<?> handle(RuntimeException e, HttpServletRequest request){
        if(e instanceof Exception400){
            Exception400 ex = (Exception400) e;
            return new ResponseEntity<>(
                    ex.body(),
                    ex.status()
            );
        }else if(e instanceof Exception401){
            Exception401 ex = (Exception401) e;
            return new ResponseEntity<>(
                    ex.body(),
                    ex.status()
            );
        }else if(e instanceof Exception403){
            Exception403 ex = (Exception403) e;
            return new ResponseEntity<>(
                    ex.body(),
                    ex.status()
            );
        }else if(e instanceof Exception404){
            Exception404 ex = (Exception404) e;
            return new ResponseEntity<>(
                    ex.body(),
                    ex.status()
            );
        }else if(e instanceof Exception500){
            ErrorLog errorLog = ErrorLog.builder()
                    .message(e.getMessage())
                    .userAgent(request.getHeader("User-Agent"))
                    .userIp(request.getRemoteAddr())
                    .build();
            errorLogJPARepository.save(errorLog);
            Exception500 ex = (Exception500) e;
            return new ResponseEntity<>(
                    ex.body(),
                    ex.status()
            );
        }else{
            ErrorLog errorLog = ErrorLog.builder()
                    .message(e.getMessage())
                    .userAgent(request.getHeader("User-Agent"))
                    .userIp(request.getRemoteAddr())
                    .build();
            errorLogJPARepository.save(errorLog);
            return new ResponseEntity<>(
                    "unknown server error",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}