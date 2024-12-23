package Research;

import Model.*;
import java.util.*;
import java.awt.Point; // Используем Point для хранения координат

public class DiplomaProject extends ResearchProject {
    private Researcher supervisor;
    private Student student;

    public DiplomaProject(String title, double budget, Researcher supervisor, Student student) {
        super(title, budget);
        this.supervisor = supervisor;
        this.student = student;
    }

    public Researcher getSupervisor() {
        return supervisor;
    }
    public Student getStudent() {
        return student;
    }

    public void setSupervisor(Researcher supervisor) {
        this.supervisor = supervisor;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void addResearcher(Researcher researcher) {
        super.addResearcher(researcher);
    }
    public Vector<Researcher> getResearchers() {
        return super.getResearchers();
    }


    public void getDiplomaProjectDetails() {
        System.out.println("Diploma Project: " + getTitle() + " with budget: " + getBudget() +
                " supervised by: " + supervisor.getName() + " for student: " + student);
    }

    @Override
    public String toString() {
        return "Supervisor: " + supervisor + ", Student: " + student.toString() + ", Location: " + super.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), student);  // Добавляем координаты в hashCode
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiplomaProject that = (DiplomaProject) o;
        return student.equals(that.student) ;
    }
}
