package oop.labor05.model;

public class Course {
    private final String name;
    private final String description;
    private  final int numHours;

    public Course(String name, String description, int numHours){
        this.name = name;
        this.description = description;
        this.numHours = numHours;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getNumHours() {
        return numHours;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", numHours=" + numHours +
                '}';
    }
}
