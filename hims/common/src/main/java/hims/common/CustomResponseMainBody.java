package hims.common;

import org.springframework.http.HttpStatus;

public class CustomResponseMainBody<T> {

    private HttpStatus httpStatusCode;

    private String code;

    private String message;

    private T entityBody;

    public CustomResponseMainBody(HttpStatus httpStatusCode,String code, String message,T entityBody){

        this.httpStatusCode = httpStatusCode;
        this.code = code;
        this.message = message;
        this.entityBody = entityBody;
    }

    public CustomResponseMainBody(T entityBody) {
        this.entityBody = entityBody;
    }

    public HttpStatus getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public T getEntityBody() {
        return entityBody;
    }

    public void setEntityBody(T entityBody) {
        this.entityBody = entityBody;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}
