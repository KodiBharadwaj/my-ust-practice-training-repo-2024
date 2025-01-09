package com.ust.webapp.exception;

import com.ust.webapp.dto.ErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestControllerAdvice
public class TraineeApiErrorController {
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleRecordNotFoundError(RecordNotFoundException ex, HttpServletRequest request){
        var status = HttpStatus.NOT_FOUND;
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(errorResponseDto);
    }
}
