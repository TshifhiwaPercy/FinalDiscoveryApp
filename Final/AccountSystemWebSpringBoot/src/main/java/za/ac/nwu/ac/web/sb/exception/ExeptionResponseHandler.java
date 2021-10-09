package za.ac.nwu.ac.web.sb.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ExeptionResponseHandler extends ResponseEntityExceptionHandler{
    /*@ExceptionHandler(value = {RuntimeException.class})
    private ResponseEntity<Object> handleGeneralException(Exception ex, WebRequest request){
        ErrorResponse
    }*/

}
