package com.gd.parallelstream;

import com.gd.domain.Student;
import com.gd.domain.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamMultipleOperationsExample {

    public static void main(String[] args) {
        getListOfStudentActivitiesSequential();
        getListOfStudentActivitiesParallel();
    }

    public static List<String> getListOfStudentActivitiesSequential() {
        Long startTime = System.currentTimeMillis();
        List<String> collect = StudentDatabase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
        Long endTime = System.currentTimeMillis();
        System.out.println("Duration of sequential: " + (endTime - startTime));
        return collect;
    }

    public static List<String> getListOfStudentActivitiesParallel() {
        Long startTime = System.currentTimeMillis();
        List<String> collect = StudentDatabase.getAllStudents().stream()
                .parallel()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
        Long endTime = System.currentTimeMillis();
        System.out.println("Duration of parallel: " + (endTime - startTime));
        return collect;
    }
}
