package uniUtil;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import Enum.*;

public class Request extends Post implements Serializable {
    private static final long serialVersionUID = 1L;
    private Boolean isSigned = false;
    private LevelImportance levelImportance;

    public Request(String topic, LocalDateTime date, String title, LevelImportance levelImportance) {
        super(topic, date, title);
        this.levelImportance = levelImportance;
    }

    public void signTheRequest(){
        this.isSigned = true;
    }

    public LevelImportance getLevelImportance(){
        return levelImportance;
    }
}
