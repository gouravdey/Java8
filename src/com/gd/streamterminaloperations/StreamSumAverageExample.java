package com.gd.streamterminaloperations;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamSumAverageExample {

    public static final List<Student> studentList = StudentDatabase.getAllStudents();

    public static void main(String[] args) {
        System.out.println("sumNoteBooks: " + sumNoteBooks());
        System.out.println("averageNoteBooks: " + averageNoteBooks());
    }

    public static int sumNoteBooks() {
        return studentList.stream()
                .collect(Collectors.summingInt(Student::getNoteBooks));
    }

    public static double averageNoteBooks() {
        return studentList.stream()
                .collect(Collectors.averagingInt(Student::getNoteBooks));
    }
}
