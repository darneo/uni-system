package Model;
import uniUtil.*;
import Enum.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;

public class Student extends User{
    private static final long serialVersionUID = 1L;
    private Vector<Transcript> allTranscripts;
    private Faculty faculty;
    private HashMap<Course, Vector<Lesson>> groups;
    private Integer year;


    public Student(String mail, String password, Faculty faculty, Integer year) {
        super(mail, password);
        this.faculty = faculty;
        this.year = year;
    }
    public Mark getMark(Course course) {
        for(Transcript transcript : allTranscripts) {
            if(transcript.getCourses().containsKey(course)) {
                return transcript.getCourses().get(course);
            }
        }
        return null;
    }
    public Vector<Transcript> getTranscripts() {
        return allTranscripts;
    }

    public Vector<Lesson> getGroup(Course pickedCourse) {
        return groups.get(pickedCourse);
    }

    public void addCourse(Course pickedCourse, Vector<Lesson> lessons) {
        groups.put(pickedCourse, lessons);
    }
    public void removeCourse(Course pickedCourse) {
        groups.remove(pickedCourse);
    }
}
