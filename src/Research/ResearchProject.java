package Research;

import Interface.*;
import java.util.*;

public class ResearchProject {
    private String title;
    private Vector<Researcher> researchers;
    private double budget;

    public ResearchProject(String title, double budget) {
        this.title = title;
        this.budget = budget;
        this.researchers = new Vector<>();
    }
    public ResearchProject(String title , Vector<Researcher> researchers , double budget)
    {
        this.title = title;
        this.researchers = researchers;
        this.budget = budget;
    }

    public String getTitle() {
        return title;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addResearcher(Researcher researcher) {
        researchers.add(researcher);
    }

    public Vector<Researcher> getResearchers() {
        return researchers;
    }

    public void getProjectDetails() {
        System.out.println("Project: " + title + " with budget: " + budget);
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nBudget: " + budget;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResearchProject that = (ResearchProject) o;
        return title.equals(that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);  // Используем title для хэш-кода
    }
}
