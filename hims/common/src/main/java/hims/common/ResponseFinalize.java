package hims.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ResponseFinalize {

    private HeaderService hs;

    @Autowired
    public ResponseFinalize(HeaderService hs) {
        this.hs = hs;
    }

    public CustomResponse responseFinalize(CustomResponseMainBody mainBody, Map<String,String> header){

        String resolvedMsg = hs.getMessageAcceptLanguage(mainBody.getMessage(), header.get("Accept-Language"));
        mainBody.setMessage(resolvedMsg);

        CustomResponse response= new CustomResponse(mainBody);

        return response;
    }

}
