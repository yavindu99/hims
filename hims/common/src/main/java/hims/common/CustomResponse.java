package hims.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomResponse {

    private String currentDateTime;

    private CustomResponseMainBody mainBody;


    public CustomResponse(CustomResponseMainBody mainBody) {

        this.mainBody = mainBody;

    }

    public String getCurrentDateTime(){

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

       this.currentDateTime = df.format(new Date());

       return this.currentDateTime;
    }


    public CustomResponseMainBody getMainBody() {
        return mainBody;
    }


}
