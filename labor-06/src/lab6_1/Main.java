package lab6_1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bankAccounts.add(new BankAccount());
        }
        for (BankAccount account : bankAccounts) {
            System.out.println(account);
        }
        System.out.println();

        ArrayList<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer("John", "Black");
        Customer customer2 = new Customer("Mary", "White");
        Customer customer3 = new Customer("Walter", "White");
        customer1.addAccount(bankAccounts.get(0));
        customer2.addAccount(bankAccounts.get(1));
        customer3.addAccount(bankAccounts.get(2));
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        Bank OTP = new Bank("OTP");
        OTP.addCustomer(customer1);
        OTP.addCustomer(customer2);
        customer1.addAccount(bankAccounts.get(3));
        customer2.addAccount(bankAccounts.get(4));
        System.out.println(OTP.getCustomer(1));
        OTP.getCustomer(1).getAccount(OTP.getCustomer(1).getAccountNumbers().get(0)).deposit(500);
        OTP.getCustomer(1).getAccount(OTP.getCustomer(1).getAccountNumbers().get(1)).deposit(2500);
        OTP.getCustomer(2).getAccount(OTP.getCustomer(2).getAccountNumbers().get(0)).deposit(320);
        OTP.getCustomer(2).getAccount(OTP.getCustomer(2).getAccountNumbers().get(1)).deposit(1000);
        System.out.println(OTP.getCustomer(2));
        String OTPBankFilename = String.format("%s_customers.csv", OTP.getName());
        OTP.printCustomersToFile(OTPBankFilename);
    }
}
