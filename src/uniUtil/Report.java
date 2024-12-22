package uniUtil;
import Enum.Urgencylevel;

import java.io.Serializable;
import java.util.Date;

public class Report extends Post implements Serializable {
    private static final long serialVersionUID = 1L;
    private Urgencylevel urgencylevel;

    public Report(String topic, Date date, String title, Urgencylevel urgencylevel) {
        super(topic, date, title);
        this.urgencylevel = urgencylevel;
    }
}