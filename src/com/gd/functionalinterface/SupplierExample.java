package com.gd.functionalinterface;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    static List<Student> studentList = StudentDatabase.getAllStudents();

    static Supplier<List<Student>> studentsSupplier = () -> studentList;
    static Supplier<Student> firstStudentSupplier = () -> studentList.get(0);

    public static void main(String[] args) {
        System.out.println(studentsSupplier.get());
        System.out.println();
        System.out.println(firstStudentSupplier.get());
    }
}
