package uz.muhandis.employeeservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailAreadyExistException extends RuntimeException{
    public EmailAreadyExistException(String message){
        super(message);
    }
}
