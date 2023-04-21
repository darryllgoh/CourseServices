package com.generation.service;

import com.generation.model.Course;
import com.generation.model.EnrolledCourse;
import com.generation.model.Student;

import java.util.Date;
import java.util.HashMap;

public class StudentService
{
    private final HashMap<String, Student> students = new HashMap<>();

    public void registerStudent( Student student )
    {
        //TODO Add new student to the students hashmap
        this.students.put(student.getId(), student);
    }

    public Student findStudent( String studentId )
    {
        //TODO Find the student from the Hashmap with the student id
        if(this.students.containsKey(studentId)) {
            return this.students.get(studentId);
        }
        return null; // check
    }


    public void enrollToCourse( String studentId, Course course )
    {
        //TODO check if students hashmap contains the studentsId, if have, add the course to the student enrolledCourse
        Student getStudent = findStudent(studentId);
        getStudent.enrollToCourse(course);
    }

    public void showSummary()
    {
        //TODO Loop through students hashmap and print out students' details including the enrolled courses
        //return msg no enrolled course

        for (Student i : students.values()) {
            System.out.println(i); //check
            //check
        }
    }

    public HashMap<String, EnrolledCourse> enrolledCourses(Student student)
    {
        //TODO return a HashMap of all the enrolledCourses
        this.students.get(student);
        return student.getEnrolledCourses();

        //return null;
    }

    public Course findEnrolledCourse( Student student, String courseId )
    {
        //TODO return the course enrolled by the student from the course Id

        this.students.get(student);

        return student.findCourseById(courseId); //check

    }

    public void gradeStudent(Student student, Course course, double grade) {
        student.gradeCourse(course.getCode(), grade);
    }



    public HashMap<String, EnrolledCourse> getPassedCourses(Student student) {
        return student.findPassedCourses();
    }
}
