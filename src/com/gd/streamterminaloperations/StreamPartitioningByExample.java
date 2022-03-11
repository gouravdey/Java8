package com.gd.streamterminaloperations;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamPartitioningByExample {

    public static final List<Student> studentList = StudentDatabase.getAllStudents();

    public static void main(String[] args) {
        System.out.println("partitioningBy1:" + partitioningBy1());
        System.out.println();
        System.out.println("partitioningBy2:" + partitioningBy2());
        System.out.println();
    }

    public static Map<Boolean, List<Student>> partitioningBy1() {
        Predicate<Student> gpaPredicate = student -> student.getGpa() >= 3.9;
        return studentList.stream()
                .collect(Collectors.partitioningBy(gpaPredicate));
    }

    public static Map<Boolean, Set<Student>> partitioningBy2() {
        Predicate<Student> gpaPredicate = student -> student.getGpa() >= 3.9;
        return studentList.stream()
                .collect(Collectors.partitioningBy(gpaPredicate, Collectors.toSet()));
    }
}
