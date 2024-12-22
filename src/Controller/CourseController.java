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

                // Получаем или создаем группу для курса
                Vector<Lesson> lessons = student.getGroup(pickedCourse);
                if (lessons == null) {
                    lessons = createLessonsForCourse(pickedCourse);
                    student.addCourse(pickedCourse, lessons); // Добавляем курс с уроками
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
    private Vector<Lesson> createLessonsForCourse(Course course) {
        Vector<Lesson> lessons = new Vector<>();
        // Создаем уроки для разных типов занятий
        lessons.add(createLesson(course, LessonType.LECTURE)); // Лекция
        lessons.add(createLesson(course, LessonType.PRACTICE)); // Практика
        lessons.add(createLesson(course, LessonType.LABORATORY)); // Лабораторная работа

        return lessons;
    }
    private Lesson createLesson(Course course, LessonType lessonType) {
        Lesson lesson = new Lesson();
        lesson.setCourse(course);
        lesson.setLessonType(lessonType);
        return lesson;
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
