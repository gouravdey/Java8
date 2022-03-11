package com.gd.functionalinterface;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    static Predicate<Integer> isEven1 = (number) -> {
        return number % 2 == 0;
    };
    static Predicate<Integer> isEven2 = (number) -> number % 2 == 0;
    static Predicate<Integer> isDivisibleBy5 = (number) -> number % 5 == 0;

    static List<Student> studentList = StudentDatabase.getAllStudents();

    static Predicate<Student> studentWithHighGradePredicate = (student) -> student.getGrade() >= 3;
    static Predicate<Student> studentWithHighGradePGPA = (student) -> student.getGpa() >= 3.9;

    public static void main(String[] args) {
        System.out.println("3: " + isEven1.test(3));
        System.out.println("4: " + isEven1.test(4));

        System.out.println("3: " + isEven2.test(3));
        System.out.println("4: " + isEven2.test(4));

        System.out.println();
        predicateAnd();
        System.out.println();
        predicateOr();
        System.out.println();
        predicateNegate();
        System.out.println();

        filterStudentByGrade();
        System.out.println();

        filterStudentByGPA();
        System.out.println();

        filterStudentByGradeAndGPA();
        System.out.println();

        filterStudentByGradeOrGPA();
        System.out.println();

        filterStudentByLowGrade();
        System.out.println();
    }

    public static void predicateAnd() {
        System.out.println("predicateAnd 10: " + isEven2.and(isDivisibleBy5).test(10));
        System.out.println("predicateAnd 11: " + isEven2.and(isDivisibleBy5).test(11));
        System.out.println("predicateAnd 12: " + isEven2.and(isDivisibleBy5).test(12));
    }

    private static void predicateOr() {
        System.out.println("predicateOr 10: " + isEven2.or(isDivisibleBy5).test(10));
        System.out.println("predicateOr 11: " + isEven2.or(isDivisibleBy5).test(11));
        System.out.println("predicateOr 12: " + isEven2.or(isDivisibleBy5).test(12));
    }

    private static void predicateNegate() {
        System.out.println("predicateNegate 10: " + isEven2.negate().test(10));
        System.out.println("predicateNegate 11: " + isEven2.negate().test(11));
        System.out.println("predicateNegate 12: " + isEven2.negate().test(12));
    }

    private static void filterStudentByGrade() {
        studentList.forEach(student -> {
            if (studentWithHighGradePredicate.test(student)) {
                System.out.println(student);
            }
        });
    }

    private static void filterStudentByGPA() {
        studentList.forEach(student -> {
            if (studentWithHighGradePGPA.test(student)) {
                System.out.println(student);
            }
        });
    }

    private static void filterStudentByGradeAndGPA() {
        studentList.forEach(student -> {
            if (studentWithHighGradePredicate.and(studentWithHighGradePGPA).test(student)) {
                System.out.println(student);
            }
        });
    }

    private static void filterStudentByGradeOrGPA() {
        studentList.forEach(student -> {
            if (studentWithHighGradePredicate.or(studentWithHighGradePGPA).test(student)) {
                System.out.println(student);
            }
        });
    }

    private static void filterStudentByLowGrade() {
        studentList.forEach(student -> {
            if (studentWithHighGradePredicate.negate().test(student)) {
                System.out.println(student);
            }
        });
    }
}
