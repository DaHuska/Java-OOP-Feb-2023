package com.company._03_StudentSystem;

import java.util.Scanner;

public class Main {

    public static final String EXIT_COMMAND = "Exit";
    public static final String CREATE_COMMAND = "Create";
    public static final String SHOW_COMMAND = "Show";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();

        String[] input = scanner.nextLine().split(" ");

        while (!input[0].equals(EXIT_COMMAND)) {
            String command = input[0];
            String name = input[1];

            switch (command) {
                case CREATE_COMMAND:
                    int age = Integer.parseInt(input[2]);
                    double grade = Double.parseDouble(input[3]);

                    if (!studentSystem.getStudents().containsKey(name)) {
                        Student student = new Student(name, age, grade);

                        studentSystem.addStudent(name, student);
                    }
                    break;
                case SHOW_COMMAND:
                    if (studentSystem.getStudents().containsKey(name)) {
                        Student student = studentSystem.getStudents().get(name);

                        String commentary = createCommentary(student.getGrade());

                        printMessage(student.getName(), student.getAge(), commentary);
                    }
                    break;
            }

            input = scanner.nextLine().split("\\s+");
        }
    }

    public static void printMessage(String name, int age, String commentary) {
        System.out.printf("%s is %d years old. %s%n", name, age, commentary);
    }

    public static String createCommentary(Double grade) {
        if (grade >= 5.00) {
            return "Excellent student.";
        } else if (grade < 5.00 && grade >= 3.50) {
            return "Average student.";
        } else {
            return "Very nice person.";
        }
    }
}
