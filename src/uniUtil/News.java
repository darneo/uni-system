package uniUtil;
import Enum.LevelImportance;

import java.time.LocalDateTime;
import java.util.Date;

public class News extends Post {
    private LevelImportance levelImportance;
    private static final long serialVersionUID = 1L;
    public News(String title, LocalDateTime date, String topic, LevelImportance levelImportance) {
        super(title, date, topic);
        this.levelImportance = levelImportance;
    }

    public LevelImportance getLevelImportance() {
        return levelImportance;
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
