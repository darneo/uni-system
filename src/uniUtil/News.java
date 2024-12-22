package uniUtil;
import Enum.LevelImportance;

import java.util.Date;

public class News extends Post {
    private LevelImportance levelImportance;
    private static final long serialVersionUID = 1L;
    public News(String topic, Date date, String title, LevelImportance levelImportance) {
        super(topic, date, title);
        this.levelImportance = levelImportance;
    }
    public String toString() {
        return "News{" +
                "topic='" + getTopic() + '\'' +
                ", date=" + getDate() +
                ", title='" + getTitle() + '\'' +
                ", levelImportance=" + levelImportance +
                '}';
    }
}
