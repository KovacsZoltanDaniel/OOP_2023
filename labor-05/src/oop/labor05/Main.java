package oop.labor05;

import oop.labor02.MyDate;
import oop.labor05.model.Course;
import oop.labor05.model.Student;
import oop.labor05.model.Training;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Course> courses = readCourses("lab5_courses.csv");
        for (Course cours : courses) {
            System.out.println(cours);
        }
        System.out.println();

        ArrayList<Student> students = readStudents("lab5_students.csv");
        for (Student student : students) {
            System.out.println(student);
        }

        ArrayList<Training> trainings = new ArrayList<>();

        Random rand = new Random();
        int minPrice = 1000;
        int maxPrice = 2000;

        for (Course cours : courses) {
            int randomPrice = rand.nextInt(maxPrice - minPrice) + minPrice;
            Training training = new Training(cours, new MyDate(2022, 3, 21), new MyDate(2022, 3, 25), randomPrice);
            trainings.add(training);
        }
        for (Training value : trainings) {
            while (value.numEnrolled() < 10) {
                int randomStudent = rand.nextInt(10);
                    if (value.findStudentById(students.get(randomStudent).getID()) == null) {
                      value.enroll(students.get(randomStudent));
                }
            }
        }

        for (Training training : trainings) {
            training.printToFile();
        }


        for (Training training : trainings) {
            System.out.println(training);
            System.out.println();
        }
    }

    private static ArrayList<Course> readCourses(String fileName) {
        ArrayList<Course> courses = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(",");
                String name = items[0].trim();
                String description = items[1].trim();
                int numHours = Integer.parseInt(items[2].trim());
                courses.add(new Course(name, description, numHours));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return courses;
    }

    private static ArrayList<Student> readStudents(String fileName) {
        ArrayList<Student> students = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(",");
                String ID = items[0].trim();
                String firstName = items[1].trim();
                String lastName = items[2].trim();
                students.add(new Student(ID, firstName, lastName));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }
}
