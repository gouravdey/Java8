package com.gd.functionalinterface;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample {

    static List<Student> studentList = StudentDatabase.getAllStudents();

    Predicate<Student> studentWithHighGradePredicate = (student) -> student.getGrade() >= 3;
    Predicate<Student> studentWithHighGPAPredicate = (student) -> student.getGpa() >= 3.9;

    BiPredicate<Integer, Double> studentWithHighGradeANDGPAPredicate = (grade, gpa) -> grade >= 3 && gpa >= 3.9;

    BiConsumer<String, List<String>> studentBiConsumer = (name, activities) -> System.out.println(name + " : " + activities);

    Consumer<Student> studentConsumer1 = (student) -> {
        if (studentWithHighGradePredicate.and(studentWithHighGPAPredicate).test(student)) {
            studentBiConsumer.accept(student.getName(), student.getActivities());
        }
    };

    Consumer<Student> studentConsumer2 = (student) -> {
        if (studentWithHighGradeANDGPAPredicate.test(student.getGrade(), student.getGpa())) {
            studentBiConsumer.accept(student.getName(), student.getActivities());
        }
    };

    public static void main(String[] args) {
        new PredicateAndConsumerExample().printNameAndActivities(studentList);
    }

    public void printNameAndActivities(List<Student> students) {
        students.forEach(studentConsumer1);
        System.out.println();
        students.forEach(studentConsumer2);
    }
}
