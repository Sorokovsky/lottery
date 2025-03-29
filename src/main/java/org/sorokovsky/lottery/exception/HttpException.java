package org.sorokovsky.lottery.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class HttpException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public HttpException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }
}
