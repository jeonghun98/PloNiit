package com.plonit.ploggingservice.common.exception;

import com.plonit.plonitservice.common.ApiResponse;
import com.plonit.plonitservice.common.DataHeader;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@Getter
public class ErrorResponse {
    private DataHeader resultStatus;
    private String resultBody;

    public ErrorResponse(DataHeader dataHeader, String dataBody) {
        this.resultStatus = dataHeader;
        this.resultBody = dataBody;
    }

    public static ResponseEntity<ErrorResponse> toResponseEntity(ErrorCode errorCode) {
        return ResponseEntity
                .ok()
                .body(new ErrorResponse(new DataHeader(1, String.valueOf(errorCode.getHttpStatus().value()), errorCode.getDescription()), null));
    }
}