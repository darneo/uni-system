package uniUtil;

import Model.Researcher;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

public class ResearchPaper extends Post implements Serializable {
    private static final long serialVersionUID = 1L;
    private Vector<Researcher> authors;

    public ResearchPaper(String topic, Date date, String title) {
        super(topic, date, title);
        authors = new Vector<Researcher>();
    }
    public void addAuthor(Researcher r) {
        authors.add(r);
    }
}
