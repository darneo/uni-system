//package Controller;
//import Model.Student;
//import uniUtil.*;
//import Enum.*;
//
//public class MarkController {
//    public static void putFirstAttestation(Course course, double grade, Student student) {
//        Mark mark = student.getMark(course);
//        if(mark != null) {
//            mark.setFirstAttestation(grade);
//            System.out.println("The first attestation is added for the student: " + student.getName());
//
//        }else{
//            System.out.println("The first attestation is not added for the student: " + student.getName());
//        }
//
//    }
//    public static void putSecondAttestation(Course course, double grade, Student student) {
//        Mark mark = student.getMark(course);
//        if(mark != null) {
//            mark.setSecondAttestation(grade);
//            System.out.println("The second attestation is added for the student: " + student.getName());
//        }else{
//            System.out.println("The second attestation is not added for the student: " + student.getName());
//
//        }
//    }
//
//    public static void putFinalExam(Course course, double grade, Student student) {
//        Mark mark = student.getMark(course);
//        if(mark != null) {
//            mark.setFinalExam(grade);
//            System.out.println("The final exam is added for the student: " + student.getName());
//
//        }else{
//            System.out.println("The final exam is not added for the student: " + student.getName());
//        }
//    }
//
//    public static void viewMark(Course course, double grade, Student student) {
//        Mark mark = student.getMark(course);
//        if(mark != null) {
//            System.out.println("Mark of student " + student.getName() + " " + student.getSurname());
//            System.out.println("First attestation: " + mark.getFirstAttestation());
//            System.out.println("Second attestation: " + mark.getSecondAttestation());
//            System.out.println("Final exam: " + mark.getFinalExam());
//
//        }else{
//            System.out.println("The mark is not added for the student: " + student.getName());
//        }
//    }
//}