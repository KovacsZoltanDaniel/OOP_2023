package lab_11_2;

import lab11_1.MyDate;

public class Manager extends Employee{
    private String department;

    public Manager(String firstName, String lastName, double salary, MyDate birthDate, String department) {
        super(firstName, lastName, salary, birthDate);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Manager{" + this.getID() + " " + this.getFirstName() + " " + this.getLastName() + " " +
                "department='" + department + '\'' +
                '}';
    }
}
