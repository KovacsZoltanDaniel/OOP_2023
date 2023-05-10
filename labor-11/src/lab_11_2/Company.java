package lab_11_2;

import lab11_1.MyDate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Company {
    private String name;
    private ArrayList<Employee> employees = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void hire(Employee employee){
        employees.add(employee);
    }
    public void hireAll(String csvFile){
        try (Scanner scanner = new Scanner(new File(csvFile))){
            while (scanner.hasNext()){
                String line = scanner.next();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(",");
                if(items.length == 6) {
                    String firstname = items[0].trim();
                    String lastName = items[1].trim();
                    double salary = Double.parseDouble(items[2].trim());
                    int year = Integer.parseInt(items[3].trim());
                    int month = Integer.parseInt(items[4].trim());
                    int day = Integer.parseInt(items[5].trim());
                    employees.add(new Employee(firstname, lastName, salary, new MyDate(year, month, day)));
                }
                else{
                    String firstname = items[0].trim();
                    String lastName = items[1].trim();
                    double salary = Double.parseDouble(items[2].trim());
                    int year = Integer.parseInt(items[3].trim());
                    int month = Integer.parseInt(items[4].trim());
                    int day = Integer.parseInt(items[5].trim());
                    String department = items[6].trim();
                    employees.add(new Manager(firstname, lastName, salary, new MyDate(year, month, day),department));
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       }
       public  void fire(int ID){
           for (int i = 0; i < employees.size(); i++) {
               if(employees.get(i).getID() == ID);
               employees.remove(employees.get(i));
           }
       }
    }


