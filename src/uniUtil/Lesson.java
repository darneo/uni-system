package uniUtil;
import Enum.LessonType;

import java.io.Serializable;

public class Lesson implements Serializable {
    private static final long serialVersionUID = 1L;
    private LessonType lessonType;
    private Course course;

    public void setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
}
