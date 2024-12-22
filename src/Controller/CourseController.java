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
    public void OpenReegistration(){
        Database.isOpenRegistration = true;
    }

    public void CloseReegistration(){
        Database.isOpenRegistration = false;
    }

    public void pickCourse(Student student, Course pickedCourse) {
        if (Database.isOpenRegistration) {
            // Проверим, что курс существует
            Vector<Course> courses = Database.Courses;
            if (courses.contains(pickedCourse)) {
                // Проверяем, не проходил ли студент уже этот курс
                for (Transcript transcript : student.getTranscripts()) {
                    if (transcript.getCourses().containsKey(pickedCourse)) {
                        System.out.println("Студент уже прошел курс: " + pickedCourse.getName());
                        return;
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
                System.out.println("Курс добавлен: " + pickedCourse.getName());
            } else {
                System.out.println("Курс не найден.");
            }
        } else {
            System.out.println("Регистрация на курсы закрыта.");
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

    public void dropCourse(Student student, Course course) {
        if (student.getTranscripts().contains(course)) {
            student.removeCourse(course);
            // Сохраняем изменения
            Database.saveStudents();
            System.out.println("Курс удален: " + course.getName());
        } else {
            System.out.println("Студент не записан на этот курс.");
        }
    }

    public void viewCourse(){
        for (Course course : Database.getCourse()){
            System.out.println(course.getName() + ": " + course.getDescription());
        }
    }

    public void addCourse(Course newCourse){
        Database.Courses.add(newCourse);
        System.out.println("Course " + newCourse.getName() + " has been added.");
        Database.saveCourse();
    }

    public void deleteCourse(Course courseToDelete){
        if(Database.Courses.contains(courseToDelete)){
            Database.Courses.remove(courseToDelete);
            System.out.println("Course " + courseToDelete.getName() + " has been deleted.");
            Database.saveCourse();
        }else{
            System.out.println("Course " + courseToDelete.getName() + " does not exist.");
        }
    }

    public void submitRegistration(Student student){
        
    }

    public void addTeacher(Course course, Teacher teacher){
        if(course != null && teacher != null){
            course.addTeacher(teacher);
            System.out.println(teacher.getName() + " has been assigned to the course: " + course.getName());
            Database.saveCourse();
        } else {
            System.out.println("Error: Teacher or Course is null.");
        }
    }
}
