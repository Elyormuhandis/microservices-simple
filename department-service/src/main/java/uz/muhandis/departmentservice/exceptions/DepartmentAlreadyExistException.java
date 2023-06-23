package uz.muhandis.departmentservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DepartmentAlreadyExistException extends RuntimeException{
    private String message;

    public DepartmentAlreadyExistException(String message){
        super(message);
    }
}
