package lab6_1;

import java.io.PrintStream;
import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Customer getCustomer(int customerId) {
        for (Customer customer : customers) {
            if (customer.getID() == customerId) {
                return customer;
            }
        }
        System.out.println("Customer not found by the given id!");
        return null;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public int numCustomers() {
        return customers.size();
    }

    private void printCustomers(PrintStream ps) {
        ps.println("ID, Firstname, Lastname, Number of bank accounts");
        for (Customer customer : customers) {
            ps.println(customer.getID()+ ", " + customer.getFirstName() + ", " +
                    customer.getLastName() + ", " + customer.getNumAccounts());
        }
        ps.close();
    }

    public void printCustomersToStdout() {
        printCustomers(System.out);
    }

    public void printCustomersToFile( String filename ) {
        try {
            printCustomers(new PrintStream(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
