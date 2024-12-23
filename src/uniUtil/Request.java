package uniUtil;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import Enum.*;

public class Request extends Post implements Serializable {
    private static final long serialVersionUID = 1L;
    private Boolean isSigned = false;

    public Request(String title, LocalDateTime date, String topic){
        super(title, date, topic);
    }

    public void signTheRequest(){

        this.isSigned = true;
    }

    public Boolean getIsSigned() {
        return isSigned;
    }
}
