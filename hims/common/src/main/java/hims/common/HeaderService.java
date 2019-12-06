package hims.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Map;

@Component
public class HeaderService {

    private CommonProperties commonProperties;
    private LocaleConfig localeConfig;

    @Autowired
    public HeaderService(CommonProperties commonProperties, LocaleConfig localeConfig) {
        this.commonProperties = commonProperties;
        this.localeConfig = localeConfig;
    }

    public String getMessageAcceptLanguage(String message,String acceptLanguage) {

        String lang = acceptLanguage;

        if(lang == null){

            lang  = commonProperties.getLocale();

        }

        try{

            String msg = localeConfig.resourceBundleMessageSource().getMessage(message,null, new Locale(lang));

            return msg;

        }catch (NoSuchMessageException ex){

           return message;
        }

    }


}
