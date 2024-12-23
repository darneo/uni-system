package uniUtil;

import Enum.Urgencylevel;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Report extends Post implements Serializable {
    private static final long serialVersionUID = 1L;
    private Urgencylevel urgencylevel;

    public Report(String topic, Urgencylevel urgencylevel) {
        super("Complaint Report", LocalDateTime.now(), topic);
        this.urgencylevel = urgencylevel;
    }

    public Urgencylevel getUrgencylevel() {
        return urgencylevel;
    }

    public void setUrgencylevel(Urgencylevel urgencylevel) {
        this.urgencylevel = urgencylevel;
    }

    @Override
    public String toString() {
        return "Report{" +
                "title='" + getTitle() + '\'' +
                ", date=" + getDate() +
                ", topic='" + getTopic() + '\'' +
                ", urgencylevel=" + urgencylevel +
                '}';
    }
}
