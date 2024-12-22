package uniUtil;

import java.io.Serializable;
import java.util.HashMap;

public class Transcript implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer semestr;
    private HashMap<Course, Mark> courses;
    public Transcript(Integer semestr) {
        this.semestr = semestr;
        courses = new HashMap<>();
    }
    public double calculateGPA(){
        double totalPoints = 0;
        double totalCredits = 0;

        for(Course c : courses.keySet()){
            Mark mark = courses.get(c);
            double coureScore = mark.calculateTotalScore();
            totalPoints += coureScore*c.getCredits();
            totalCredits += c.getCredits();
        }
        if(totalCredits == 0)return 0.0;
        return totalPoints/totalCredits;
    }
    public HashMap<Course, Mark> getCourses() {
        return courses;
    }

}