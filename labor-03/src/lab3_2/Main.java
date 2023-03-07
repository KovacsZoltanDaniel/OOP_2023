package lab3_2;

import lab3_1.BankAccount;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Kovacs", "Daniel");
        Customer customer2 = new Customer("Fabrizio", "Romano");

        BankAccount account1 = new BankAccount("OTP0001");
        BankAccount account2 = new BankAccount("OTP0002");
        BankAccount account3 = new BankAccount("OTP0003");
        BankAccount account4 = new BankAccount("OTP0004");
        BankAccount account5 = new BankAccount("OTP0005");
        BankAccount account6 = new BankAccount("OTP0006");
        BankAccount account7 = new BankAccount("OTP0007");
        BankAccount account8 = new BankAccount("OTP0008");
        BankAccount account9 = new BankAccount("OTP0009");

        customer1.addAccount(account1);
        customer1.addAccount(account2);
        customer1.addAccount(account3);
        customer1.addAccount(account4);
        customer1.addAccount(account5);

        customer2.addAccount(account1);
        customer2.addAccount(account2);
        customer2.addAccount(account3);
        customer2.addAccount(account4);
        customer2.addAccount(account5);
        customer2.addAccount(account6);
        customer2.addAccount(account7);
        customer2.addAccount(account8);
        customer2.addAccount(account9);

        System.out.println(customer1);
        System.out.println(customer2);

        account1.deposit(1000);
        account2.deposit(2000);
        account3.deposit(8000);
        account4.deposit(9000);
        account5.deposit(3000);
        account6.deposit(4000);
        account7.deposit(7000);
        account8.deposit(6000);
        account9.deposit(5000);

        customer1.closeAccount("OTP0001");
        customer2.closeAccount("OTP0009");

        System.out.println(customer1);
        System.out.println(customer2);
    }
}

