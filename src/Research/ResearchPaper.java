package Research;

import Interface.*;

public class ResearchPaper implements Publishable{
    private String title;
    private Researcher author;
    private int year;
    private String topic;

    public ResearchPaper(String title, Researcher author, int year, String topic) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.topic = topic;
    }

    public String getTitle() {return title;}
    public Researcher getAuthor() {return author;}
    public int getYear() {return year;}
    public String getTopic() {return topic;}

    public void setTitle(String title) {this.title = title;}
    public void setAuthor(Researcher author) {this.author = author;}
    public void setYear(int year) {this.year = year;}
    public void setTopic(String topic) {this.topic = topic;}

    @Override
    public String getCitation() {
        return author.getName() + " (" + year + "). " + title + ".";
    }

    @Override
    public String getSummary() {
        return title + " - " + topic + " (" + year + ").";
    }

    public String toString() {
        return ("Title: " + title + ", Author: " + author + ", Year: " + year + ", Topic: " + topic   );
    }
    public int hashCode(){
        return title.hashCode() + author.hashCode() + year + topic.hashCode();
    }
    public boolean equals(Object other){
        if(this == other)return true;
        if(other == null || getClass() != other.getClass())return false;
        ResearchPaper otherPaper = (ResearchPaper) other;
        return otherPaper.getTitle() == title && (otherPaper.getYear() == year && otherPaper.getTopic().equals(topic));
    }
}
