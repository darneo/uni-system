package Controller;

import data.*;
import Model.*;
import uniUtil.Course;
import uniUtil.Lesson;
import uniUtil.Transcript;
import Enum.LessonType;
import uniUtil.Request;
import java.util.Vector;


public class CourseController {
    // Открыть регистрацию
    public boolean openRegistration() {
        Database.isOpenRegistration = true;
        return true;
    }

    // Закрыть регистрацию
    public boolean closeRegistration() {
        Database.isOpenRegistration = false;
        return true;
    }

    public boolean pickCourse(Student student, Course pickedCourse) {
        if (Database.isOpenRegistration) {
            // Проверим, что курс существует
            Vector<Course> courses = Database.Courses;
            if (courses.contains(pickedCourse)) {
                // Проверяем, не проходил ли студент уже этот курс
                for (Transcript transcript : student.getTranscripts()) {
                    if (transcript.getCourses().containsKey(pickedCourse)) {
                        return false; // Студент не может пройти курс снова
                    }
                }

                // Проверка лимита кредитов
                Transcript currentTranscript = student.getTranscripts().lastElement(); // Предполагается, что это текущий семестр
                int totalCredits = 0;
                for (Course course : currentTranscript.getCourses().keySet()) {
                    totalCredits += course.getCredits();
                }

                if (totalCredits + pickedCourse.getCredits() > 30) {
                    return false; // Нельзя добавить курс, превышающий лимит кредитов
                }

                // Сохраняем изменения
                Database.saveStudents();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    public boolean dropCourse(Student student, Course course) {
        if (student.getTranscripts().contains(course)) {
            student.removeCourse(course);
            Database.saveStudents();
            return true;
        } else {
            return false;
        }
    }

    public void viewCourse(){
        for (Course course : Database.getCourse()){
            System.out.println(course.getName() + ": " + course.getDescription());
        }
    }

    public boolean addCourse(Course newCourse){
        Database.Courses.add(newCourse);
        Database.saveCourse();
        return true;
    }


    // Удалить курс
    public boolean deleteCourse(Course courseToDelete) {
        if (Database.Courses.contains(courseToDelete)) {
            Database.Courses.remove(courseToDelete);
            Database.saveCourse();
            return true;
        } else {
            return false;
        }
    }

    public void submitRegistration(Student student){

    }

    // Добавить преподавателя к курсу
    public boolean addTeacher(Course course, Teacher teacher) {
        if (course != null && teacher != null) {
            course.addTeacher(teacher);
            Database.saveCourse();
            return true;
        } else {
            return false;
        }
    }
}
