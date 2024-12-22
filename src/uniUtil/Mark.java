package uniUtil;

import java.io.Serializable;

public class Mark extends Transcript implements Serializable {
    private static final long serialVersionUID = 1L;
    private double firstAttestation;
    private double secondAttestation;
    private double finalExam;

    public Mark(Integer semestr, double firstAttestation, double secondAttestation, double finalExam) {
        super(semestr);
        this.firstAttestation = firstAttestation;
        this.secondAttestation = secondAttestation;
        this.finalExam = finalExam;
    }
    public double calculateTotalScore() {
        double beforfinal = firstAttestation + secondAttestation;
        if(beforfinal > 60.0){
            beforfinal = 60.0;
        }
        return beforfinal + finalExam;
    }

    public double getFirstAttestation() {
        return firstAttestation;
    }
    public double getSecondAttestation() {
        return secondAttestation;
    }
    public double getFinalExam() {
        return finalExam;
    }
    public void setFirstAttestation(double firstAttestation) {
        this.firstAttestation = firstAttestation;
    }
    public void setSecondAttestation(double secondAttestation) {
        this.secondAttestation = secondAttestation;
    }
    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }
}
