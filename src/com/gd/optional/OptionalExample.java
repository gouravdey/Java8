package com.gd.optional;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        String name = getStudentName();
        if (name != null) {
            System.out.println("Length of student name: " + name.length());
        } else {
            System.out.println("Name not found");
        }

        Optional<String> nameOptional = getStudentNameOptional();

        if (nameOptional.isPresent()) {
            System.out.println("Length of student name: " + nameOptional.get().length());
        } else {
            System.out.println("Name not found");
        }
    }

    public static String getStudentName() {
        Student student = StudentDatabase.studentSupplier.get();
//        student = null;
        if (student != null) {
            return student.getName();
        }
        return null;
    }

    public static Optional<String> getStudentNameOptional() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDatabase.studentSupplier.get());
        studentOptional = Optional.ofNullable(null);
        if (studentOptional.isPresent()) {
            return studentOptional.map(Student::getName);
        }
        return Optional.empty();
    }
}
