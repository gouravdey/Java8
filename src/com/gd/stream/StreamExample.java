package com.gd.stream;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {

        Predicate<Student> studentGradePredicate = student -> student.getGrade() >= 3;
        Predicate<Student> studentGPAPredicate = student -> student.getGpa() >= 3.9;

        Map<String, List<String>> stringListMap = StudentDatabase.getAllStudents()
                .stream()
                .peek(student -> {
                    System.out.println("Without Filter\n" + student + "\n");
                })
                .filter(studentGradePredicate)
                .peek(student -> {
                    System.out.println("After First Filter\n" + student + "\n");
                })
                .filter(studentGPAPredicate)
                .peek(student -> {
                    System.out.println("After Second Filter\n" + student + "\n");
                })
                .collect(Collectors.toMap(Student::getName, Student::getActivities));

        System.out.println(stringListMap);
    }
}
