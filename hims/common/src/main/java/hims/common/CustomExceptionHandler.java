package hims.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseFinalize rf;

    @Autowired
    public CustomExceptionHandler(ResponseFinalize rf) {
        this.rf = rf;
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> lastHandle(Exception ex,WebRequest request) {

        CustomResponseMainBody mainBody = new CustomResponseMainBody<>(HttpStatus.INTERNAL_SERVER_ERROR,
                ClientMessages.UNKNOWN_ERROR.getMsgCode(),"unknown_error",ex);

        return this.respond(request, mainBody);

    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<String> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        CustomResponseMainBody mainBody = new CustomResponseMainBody<>(HttpStatus.BAD_REQUEST,
                ClientMessages.VALIDATION_FAILED.getMsgCode(),"invalid_data_type"/*details.get(0)*/,null);

        return this.respond(request, mainBody);

    }

    private ResponseEntity<Object> respond(WebRequest request,CustomResponseMainBody mainBody){

        Map<String,String> header = new HashMap<String,String>();
        header.put("Accept-Language", request.getHeader("Accept-Language"));

        CustomResponse response  = rf.responseFinalize(mainBody,header);

        return new ResponseEntity<>(response,mainBody.getHttpStatusCode());

    }

}
