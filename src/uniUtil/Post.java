package uniUtil;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


public class Post implements Serializable {
    private static final long serialVersionUID = 1L;
    private String topic;
    private LocalDateTime date;
    private String title;
    public Post(String title, LocalDateTime date, String topic) {
        this.topic = topic;
        this.date = date;
        this.title = title;
    }
    public String getTopic() { return topic; }
    public LocalDateTime getDate() { return date; }
    public String getTitle() { return title; }
}
