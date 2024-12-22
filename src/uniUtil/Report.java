package uniUtil;
import Enum.Urgencylevel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class Report extends Post implements Serializable {
    private static final long serialVersionUID = 1L;
    private Urgencylevel urgencylevel;

    public Report(String title, LocalDateTime date, String topic, Urgencylevel urgencylevel) {
        super(title, date, topic);
        this.urgencylevel = urgencylevel;
    }
}
