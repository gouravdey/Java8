package com.gd.methodreference;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.function.Predicate;

public class RefactorMethodReference {

    static Predicate<Student> studentWithHighGradePredicate = RefactorMethodReference::greaterThanHigherGrade;

    static boolean greaterThanHigherGrade(Student student) {
        return student.getGrade() >= 3;
    }

    public static void main(String[] args) {
        System.out.println(studentWithHighGradePredicate.test(StudentDatabase.studentSupplier.get()));
    }
}
