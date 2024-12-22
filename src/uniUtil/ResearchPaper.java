package uniUtil;

import Model.Researcher;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Vector;

public class ResearchPaper extends Post implements Serializable {
    private static final long serialVersionUID = 1L;
    private Vector<Researcher> authors;

    public ResearchPaper(String title, LocalDateTime date, String topic) {
        super(title, date, topic);
        authors = new Vector<Researcher>();
    }
    public void addAuthor(Researcher r) {
        authors.add(r);
    }
}

