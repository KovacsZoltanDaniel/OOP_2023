package lab6_1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        for (int i = 0; i < 150; i++) {
            bankAccounts.add(new BankAccount());
        }
        System.out.println(bankAccounts);

        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("John", "Black"));
        customers.add(new Customer("Mary", "White"));
        customers.add(new Customer("Walter", "White"));
        for (int i = 0; i < customers.size(); i++) {
            customers.get(i).addAccount(bankAccounts.get(i));
        }
        System.out.println(customers);
    }


}
