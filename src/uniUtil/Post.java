package uniUtil;

import java.io.Serializable;
import java.util.Date;

public class Post implements Serializable {
    private static final long serialVersionUID = 1L;
    private String Topic;
    private Date date;
    private String Title;
    public Post(String topic, Date date, String title) {
        this.Topic = topic;
        this.date = date;
        this.Title = title;
    }
    public String getTopic() { return Topic; }
    public Date getDate() { return date; }
    public String getTitle() { return Title; }
}
