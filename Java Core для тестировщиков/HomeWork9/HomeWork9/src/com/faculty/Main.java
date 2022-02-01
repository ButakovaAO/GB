package com.faculty;

import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.groupingBy;

public class Main {

    public static void main(String[] args) {

        Students students1 = new Students("Ivan", Students.Course.ECONOMY);
        Students students2 = new Students("Alexei", Students.Course.MATHEMATICS);
        Students students3 = new Students("Igor", Students.Course.PHILOSOPHY);
        Students students4 = new Students("Daniel", Students.Course.ECONOMY);
        Students students5 = new Students("Valeria", Students.Course.PHILOSOPHY);
        Students students6 = new Students("Anna", Students.Course.PHYSICS);
        Students students7 = new Students("Natalia", Students.Course.MATHEMATICS);
        Students students8 = new Students("Olga", Students.Course.MATHEMATICS);
        Students students9 = new Students("Matvey", Students.Course.PHYSICS);
        Students students10 = new Students("Alexander", Students.Course.PHILOSOPHY);
        Students students11 = new Students("Ivan", Students.Course.PHILOSOPHY);
        Students students12 = new Students("Ivan", Students.Course.ECONOMY);
        Students students13 = new Students("Natalia", Students.Course.ECONOMY);
        Students students14 = new Students("Alexei", Students.Course.PHILOSOPHY);
        Students students15 = new Students("Alexei", Students.Course.PHYSICS);

        ArrayList<Students> students = new ArrayList<>();

        students.add(students1);
        students.add(students2);
        students.add(students3);
        students.add(students4);
        students.add(students5);
        students.add(students6);
        students.add(students7);
        students.add(students8);
        students.add(students9);
        students.add(students10);
        students.add(students11);
        students.add(students12);
        students.add(students13);
        students.add(students14);
        students.add(students15);

        System.out.println(students);
        System.out.println();

        System.out.println("Список уникальных курсов, на которые подписаны студенты");
        getUniqueCourse(students);
        System.out.println();

        System.out.println("Список из трех самых любознательных");
        getCuriosStudent(students);
        System.out.println();

        System.out.println("Список студентов, которые посещают курс:");
        findStudentByCourse(students, Students.Course.PHILOSOPHY);
        System.out.println();
        findStudentByCourse(students, Students.Course.MATHEMATICS);

    }

    static void getUniqueCourse(ArrayList<Students> args) {
        //System.out.println(args);
        List<Students.Course> res = args.stream().map((n) -> n.course).collect(Collectors.toList());
        //System.out.println(res);
        List<Students.Course> resDist = args.stream().map((n) -> n.course).distinct().collect(Collectors.toList());
        System.out.println(resDist);
    }

    static void getCuriosStudent(ArrayList<Students> args) {
        //System.out.println(args);
        Map<String, Long> nameCourse = args.stream().collect(groupingBy(n -> n.name, Collectors.counting()));
        System.out.println(nameCourse);

        nameCourse.entrySet().stream().sorted(Comparator.comparingLong(Map.Entry::getValue)).skip(nameCourse.size() - 3).forEach(n -> System.out.println(n));
    }

    static void findStudentByCourse(ArrayList<Students> args, Students.Course course) {
        //System.out.println(args);
        List<String> result = args.stream().filter(n -> n.course == course).map((n) -> n.name).collect(Collectors.toList());
        System.out.println("Course " + course);
        System.out.println(result);
    }
}