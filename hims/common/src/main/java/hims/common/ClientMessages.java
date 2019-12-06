package hims.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public enum ClientMessages {

    SUCCESSFULLY_ADDED ("successfully_added","001"),
    SUCCESSFULLY_UPDATED ("successfully_updated","002"),
    SUCCESSFULLY_DELETED ("successfully_deleted","003"),
    RECORDS_FOUND ("no_records_found","004"),
    NO_RECORDS_FOUND ("no_records_found","005"),

    FAILED_ADD ("failed_to_add","005"),
    FAILED_UPDATE ("failed_to_update","006"),
    FAILED_DELETE ("failed_to_delete","007"),

    VALIDATION_FAILED("validation_failed","008"),
    UNKNOWN_ERROR("unknown_error","009"),

    AUTHENTICATION_FAILED("authentication_failure","000");


    private String msgTitle;
    private String msgCode;

    private ClientMessages(String msgTitle, String msgCode) {

        this.msgTitle = msgTitle;
        this.msgCode = msgCode;
    }

    public String getMsgTitle() {

        return this.msgTitle;
    }

    public String getMsgCode() {
        return msgCode;
    }
}
