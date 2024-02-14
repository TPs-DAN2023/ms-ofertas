package dan.ms.tp.msofertas.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

import jakarta.validation.ConstraintViolationException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<ExceptionInfo> handleInvalidArgument(MethodArgumentNotValidException e) {
        
        ExceptionInfo info = new ExceptionInfo();

        info.setStatus(400);
        info.setMessage(e.getMessage());
        info.setName(e.getFieldError().toString());
        
        return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity<ExceptionInfo> handleNotFound(NotFoundException e) {
        
        ExceptionInfo info = new ExceptionInfo();

        info.setStatus(404);
        info.setMessage(e.getMessage());
        info.setName(e.getClass().getName());
        
        return new ResponseEntity<>(info, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<ExceptionInfo> handleViolation(ConstraintViolationException e) {
        
        ExceptionInfo info = new ExceptionInfo();

        info.setStatus(400);
        info.setMessage(e.getMessage());
        info.setName(e.getConstraintViolations().toString());
        
        return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {RestClientException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ResponseEntity<ExceptionInfo> handleViolation(RestClientException e) {
        
        ExceptionInfo info = new ExceptionInfo();

        info.setStatus(500);
        info.setMessage("Error comunicando con otro microservicio: \n" + e.getMessage());
        info.setName(e.getClass().getName());
        
        return new ResponseEntity<>(info, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
