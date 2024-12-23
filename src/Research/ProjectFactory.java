package Research;

import Model.*;

public class ProjectFactory {
    public static ResearchProject createProject(String type, String title, double budget, Researcher supervisor, Student student) {
        if (type.equals("Research")) {
            return new ResearchProject(title, budget);
        } else if (type.equals("Diploma")) {
            return new DiplomaProject(title, budget, supervisor, student);
        }
        throw new IllegalArgumentException("Unknown project type");
    }
}
