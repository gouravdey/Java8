package com.gd.streamterminaloperations;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamMappingExample {

    public static final List<Student> studentList = StudentDatabase.getAllStudents();

    public static void main(String[] args) {
        List<String> namesList = studentList.stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toList()));

        System.out.println("namesList: " + namesList);

        Set<String> namesSet = studentList.stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toSet()));

        System.out.println("namesSet: " + namesSet);
    }
}
