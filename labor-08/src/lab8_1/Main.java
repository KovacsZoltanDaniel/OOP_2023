package lab8_1;

public class Main {
    public static void main(String[] args) {
        Bank OTP = new Bank("OTP");

        Customer customer1 = new Customer(" Jani ", " vagyok ");
        Customer customer2 = new Customer(" Walter ", " White ");

        OTP.addCustomer(customer1);
        OTP.addCustomer(customer2);

        SavingsAccount account1 = new SavingsAccount(1.26);
        CheckingAccount account2 = new CheckingAccount(5000);
        SavingsAccount account3 = new SavingsAccount(1.5);
        CheckingAccount account4 = new CheckingAccount(5000);

        customer1.addAccount(account1);
        customer1.addAccount(account2);
        customer2.addAccount(account3);
        customer2.addAccount(account4);

        account1.deposit(100);
        account2.deposit(200);
        account3.deposit(300);
        account4.deposit(400);

        System.out.println("Accounts before adding interest:");
        for (int i = 1; i <= OTP.NumCustomers(); i++) {
            System.out.println(OTP.getCustomer(i));
        }

        account1.addInterest();
        account3.addInterest();

        System.out.println("Accounts after adding interest:");
        for (int i = 1; i <= OTP.NumCustomers(); i++) {
            System.out.println(OTP.getCustomer(i));
        }

        account1.withDraw(500);
        account2.withDraw(500);
        account3.withDraw(500);
        account4.withDraw(500);

        System.out.println("Accounts after withdrawals:");

        for (int i = 1; i <= OTP.NumCustomers(); i++) {
            System.out.println(OTP.getCustomer(i));
        }
    }
}
