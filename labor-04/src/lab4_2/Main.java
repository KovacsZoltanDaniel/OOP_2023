package lab4_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Customer> readFromCSVFile(String fileName) {
        ArrayList<Customer> persons = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(",");
                String type = items[0].trim();
                if(type.equals("Customer")){
                String firstName = items[1].trim();
                String lastName = items[2].trim();
                customers.add(new Customer(firstName,lastName));
                }

                int birthYear = Integer.parseInt(items[2].trim());
                persons.add(new Customer(firstName, lastName));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
