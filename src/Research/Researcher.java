package Research;

import java.util.*;

public class Researcher {
    private String name;
    private int researchId;
    private Vector<ResearchPaper> papers = new Vector<>();

    public Researcher(String name, int researchId) {
        this.name = name;
        this.researchId = researchId;
    }

    public String getName(){return name;}
    public int getResearchId(){return researchId;}
    public Vector<ResearchPaper> getPapers(){return papers;}

    public void setName(String name){this.name = name;}
    public void setResearchId(int researchId){this.researchId = researchId;}
    public void addPaper(ResearchPaper paper){papers.add(paper);}
    public void removePaper(ResearchPaper paper){papers.remove(paper);}

    public String toString(){
        return ("Name : " + name + " , research id : " + researchId + " , papers : " + papers);
    }
    public int hashCode(){return name.hashCode() + researchId + papers.size();}
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Researcher researcher = (Researcher) o;
        return researchId == researcher.researchId && name.equals(researcher.name);
    }
}
