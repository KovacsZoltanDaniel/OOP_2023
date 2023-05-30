package lab_12_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bac {
    private Map<Long, Student> students = new HashMap<>();

    public void readNames(String fileName) {
        try(Scanner scanner = new Scanner(new File(fileName))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] items = line.split(" ");

                long id = Long.parseLong(items[0].trim());

                Student student = new Student(id, items[1].trim(), items[2].trim());
                students.put(id, student);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void readSubject(String subject) {
        try(Scanner scanner = new Scanner(new File(subject + ".txt"))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] items = line.split(" ");

                long id = Long.parseLong(items[0].trim());
                double grade = Double.parseDouble(items[1].trim());

                Student student = this.students.get(id);
                if (student == null) {
                    System.out.println("Invalid id: " + id);
                    continue;
                }

                student.addGrade(subject, grade);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void calcAverages() {
        for (Student student: students.values()) {
            student.calcAvg();
        }
    }

    public int numPassed() {
        int numPassed = 0;
        for (Student student: students.values()) {
            if (student.getAvg() > 0) {
                numPassed++;
            }
        }
        return numPassed;
    }

    public void printFailed() {
        students.values().forEach((student) -> {
            if (student.getAvg() == 0) {
                System.out.println(student);
            }
        });
    }
}
