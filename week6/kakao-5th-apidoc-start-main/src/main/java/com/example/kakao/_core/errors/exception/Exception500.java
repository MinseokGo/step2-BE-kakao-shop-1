package com.example.kakao._core.errors.exception;

import com.example.kakao._core.utils.ApiUtils;
import lombok.Getter;
import org.springframework.http.HttpStatus;

// 서버 에러
@Getter
public class Exception500 extends HttpStatusException {
    public Exception500(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
