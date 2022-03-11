package com.gd.stream;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {

    private static final List<Student> studentList = StudentDatabase.getAllStudents();

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 3, 5, 7);
        System.out.println(performMultiplication(integers));
        System.out.println(performMultiplicationWithoutIdentity(integers).get());

        if (getStudentWithHighestGPA().isPresent()) {
            System.out.println(getStudentWithHighestGPA().get());
        }
    }

    public static Integer performMultiplication(List<Integer> list) {
        return list.stream()
                .reduce(1, (i, j) -> i * j);
    }

    public static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> list) {
        return list.stream()
                .reduce((i, j) -> i * j);
    }

    public static Optional<Student> getStudentWithHighestGPA() {
        return studentList.stream()
                .reduce((s1, s2) -> (s1.getGpa() > s2.getGpa()) ? s1 : s2);
    }
}
