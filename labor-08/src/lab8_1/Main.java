package lab8_1;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new SavingsAccount(50);
        BankAccount account2 = new CheckingAccount(5000);
        BankAccount account3 = new SavingsAccount(50);
        BankAccount account4 = new CheckingAccount(5000);
        account1.deposit(100);
        account2.deposit(200);
        account3.deposit(300);
        account4.deposit(400);
        Bank bank = new Bank("OTP");
        Customer customer1 = new Customer(" Jani ", " vagyok ");
        Customer customer2 = new Customer(" Walter ", " White ");
        customer1.addAccount(account1);
        customer1.addAccount(account2);
        customer2.addAccount(account3);
        customer2.addAccount(account4);
        System.out.println(customer1);
        System.out.println(customer2);
        ((SavingsAccount) account1).addInterest();
        ((SavingsAccount) account3).addInterest();
        System.out.println("+++++++++++++++++++");
        System.out.println(customer1);
        System.out.println(customer2);
        account1.withDraw(500);
        account2.withDraw(500);
        account3.withDraw(500);
        account4.withDraw(500);
        System.out.println("+++++++++++++++++++++++++++++");
        System.out.println(customer1);
        System.out.println(customer2);
    }
}
