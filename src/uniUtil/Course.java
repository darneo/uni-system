package uniUtil;
import Enum.Faculty;

import Model.Teacher;

import java.io.Serializable;
import java.util.Vector;

public class Course extends Transcript implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int credits;
    private Vector<Teacher> lecturers;
    private Faculty faculty;

    public Course(Integer semestr, String name, int credits, Faculty faculty){
        super(semestr);
        this.name = name;
        this.credits = credits;
        this.faculty  = faculty;
        this.lecturers = new Vector<>();
    }
    public int getCredits(){
        return credits;
    }
}