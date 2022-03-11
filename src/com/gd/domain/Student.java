package com.gd.domain;

import java.util.List;

public class Student {

    private String name;
    private Integer grade;
    private Double gpa;
    private String gender;
    private Integer noteBooks;
    private List<String> activities;

    public Student(String name, Integer grade, Double gpa, String gender, Integer noteBooks, List<String> activities) {
        this.name = name;
        this.grade = grade;
        this.gpa = gpa;
        this.gender = gender;
        this.noteBooks = noteBooks;
        this.activities = activities;
    }

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getNoteBooks() {
        return noteBooks;
    }

    public void setNoteBooks(Integer noteBooks) {
        this.noteBooks = noteBooks;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                ", gpa=" + gpa +
                ", gender='" + gender + '\'' +
                ", noteBooks=" + noteBooks +
                ", activities=" + activities +
                '}';
    }

    public void printStudentActivities() {
        System.out.println(this.getName() + " : " + this.getActivities());
    }
}
