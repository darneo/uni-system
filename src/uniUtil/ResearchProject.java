package uniUtil;

import Model.Researcher;

import java.io.Serializable;
import java.util.Vector;

public class ResearchProject implements Serializable {
    private static final long serialVersionUID = 1L;
    private String topic;
    private Researcher ReseachProject;
    private Vector<Researcher> Participants;
    private Vector<ResearchPaper> topics;
    private Integer citations;

    public void joinToProject(Researcher participant) {
        Participants.add(participant);
    }
}
