package oop.labor05.model;

import oop.labor02.MyDate;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Training {
    private final Course course;
    private final MyDate startDate;
    private final MyDate endDate;
    private final double pricePerStudent;
    private ArrayList<Student> enrolledStudents = new ArrayList<>();

    public Training(Course course, MyDate startDate, MyDate endDate, double pricePerStudent) {
        this.course = course;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pricePerStudent = pricePerStudent;
    }

    public boolean enroll(Student student) {
        if ((findStudentById(student.getID()) == null)) {
            enrolledStudents.add(student);
            return true;
        } else {
            System.out.println("Student is already enrolled!");
            return false;
        }
    }

    public Student findStudentById(String ID) {
        for (Student enrolledStudent : enrolledStudents) {
            if (enrolledStudent.getID().equals(ID)) {
                return enrolledStudent;
            }
        }
        return null;
    }

    public Course getCourse() {
        return course;
    }

    public int numEnrolled() {
        int db = 0;
        for (Student enrolledStudent : enrolledStudents) {
            //if (enroll(enrolledStudent)) {
            db++;
            //}
        }
        return db;
    }

    public void printToFile() {
        try {
            String filename = String.format("%s_%d.%d.%d_%d.%d.%dcsv", course.getName(), startDate.getYear(), startDate.getMonth(), startDate.getDay(), endDate.getYear(), endDate.getMonth(), endDate.getDay());
            System.out.println(filename);
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(String.valueOf(enrolledStudents)); //atalakitotta a listat stringe hogy tudja kiiratni
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void unEnroll(String ID) {
        enrolledStudents.remove(findStudentById(ID));
    }

    @Override
    public String toString() {
        return "Training{" + "\n" +
                "\tcourse=" + course + "\n" +
                "\tstartDate= year " + startDate.getYear() +" month "+ startDate.getMonth() + " day " + startDate.getDay() + "\n" +
                "\tendDate= year " + endDate.getYear() + " month " + endDate.getMonth()+ " day " + endDate.getDay()+"\n" +
                "\t\tStudents=" + enrolledStudents +
                '}';
    }
}
