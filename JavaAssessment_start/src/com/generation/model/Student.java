package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Student extends Person {
    public static final double PASS_MIN_GRADE = 3.0;

    private final HashMap<String, EnrolledCourse> enrolledCourses = new HashMap<>();


    public Student(String id, String name, String email, Date birthDate) {
        super(id, name, email, birthDate);
    }

    public boolean enrollToCourse(Course course) {
        //TODO Check if student has already enrolled to the course, if not add the course to enrolledCourses hashmap

        if (this.enrolledCourses.containsKey(course)) {
            return true; //check
        }
        return false;
    }

    public HashMap<String, EnrolledCourse> getEnrolledCourses() {
        //TODO return a Hashmap of all the enrolledCourses
        return this.enrolledCourses; //check

    }

    public void gradeCourse(String courseCode, double grade) {
        //TODO set the grade for the enrolled Course
        EnrolledCourse getCourse = this.enrolledCourses.get(courseCode);
        getCourse.setGrade(grade);

    }

    public Course findCourseById(String courseId) {
        //TODO return a Course from the course Id
        //enrolledcourse object getcode - loop enrolled courses hashmap. check course id against enrolled course ID
        for (int i = 0; i < enrolledCourses.size(); i++) {
            if (this.enrolledCourses.containsKey(courseId)) {
                return this.enrolledCourses.get(courseId);
            }
        }
        return null;

    }

    public HashMap<String, EnrolledCourse> findPassedCourses() {
        //TODO Check the enrolled courses grade and compare to the passing grade
        //loop through enrolled courses, get grade > 3.0
        for (int i = 0; i < enrolledCourses.size(); i++) {
            if (this.enrolledCourses.get(i).getGrade() >= 3.0) {
                return this.enrolledCourses;
            }
        }
        return null;
    }

    public String toString() {
        return "Student {" + super.toString() + "}";
    }

}

