package com.gd.functionalinterface;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    static List<Student> studentList = StudentDatabase.getAllStudents();

    static Consumer<Student> studentConsumer = (student) -> System.out.println(student);
    static Consumer<Student> studentNameConsumer = (student) -> System.out.println(student.getName());
    static Consumer<Student> studentActivityConsumer = (student) -> System.out.println(student.getActivities());

    public static void main(String[] args) {

        Consumer<String> consumer1 = (s) -> System.out.println(s.toUpperCase());
        consumer1.accept("Gourav");

        printStudent();
        printNameAndActivities();
        printNameAndActivitiesHavingHighGPA();
    }

    public static void printStudent() {
        System.out.println("printStudent");
        studentList.forEach(studentConsumer);
        System.out.println();
        System.out.println();
    }

    private static void printNameAndActivities() {
        System.out.println("printNameAndActivities");
        studentList.forEach(studentNameConsumer.andThen(studentActivityConsumer)); //Consumer Chaining
        System.out.println();
        System.out.println();
    }

    private static void printNameAndActivitiesHavingHighGPA() {
        System.out.println("printNameAndActivitiesHavingHighGPA");
        studentList.forEach(student -> {
            if (student.getGrade() >= 3 && student.getGpa() >= 3.9) {
                studentNameConsumer.andThen(studentActivityConsumer).accept(student);
            }
        });
        System.out.println();
        System.out.println();
    }
}
