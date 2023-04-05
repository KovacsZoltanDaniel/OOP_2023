package lab4_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customers = readFromCSVFile("lab4_2_input.csv");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
    public static ArrayList<Customer> readFromCSVFile(String fileName) {
        ArrayList<Customer> customers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int i = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(",");

                while (scanner.hasNextLine()) {
                    if(items[0].trim().equals("Customer")){
                        String firstName = items[1].trim();
                        String lastName = items[2].trim();
                        customers.add(new Customer(firstName, lastName));
                        i++;
                        if (scanner.hasNextLine()) {
                            line = scanner.nextLine();
                            items = line.split(",");
                        }
                        else {
                            break;
                        }
                    }
                    else if (items[0].trim().equals("Account")){
                        String accountNumber = items[1].trim();
                        double balance = Double.parseDouble(items[2].trim());
                        customers.get(i-1).addAccount(new BankAccount(accountNumber, balance));
                        if (scanner.hasNextLine()) {
                            line = scanner.nextLine();
                            items = line.split(",");
                        }
                        else {
                            break;
                        }
                     }
                    }
                }
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
