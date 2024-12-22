package uniUtil;

import java.io.Serializable;
import java.util.Date;

public class Request extends Post implements Serializable {
    private static final long serialVersionUID = 1L;
    private Boolean isSigned;

    public Request(String topic, Date date, String title, Boolean isSigned) {
        super(topic, date, title);
        this.isSigned = isSigned;
    }
}