package com.gd.methodreference;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerMethodReference {

    static List<Student> studentList = StudentDatabase.getAllStudents();

    static Consumer<Student> studentConsumer = System.out::println;
    static Consumer<Student> studentConsumerMethod = Student::printStudentActivities;
    ;

    public static void main(String[] args) {
        studentList.forEach(student -> studentConsumer.accept(student));
        System.out.println();
        studentList.forEach(student -> studentConsumerMethod.accept(student));
    }

}
