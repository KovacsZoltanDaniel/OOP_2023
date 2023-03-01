package lab3_1;

public class Main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("OTP0001");
        System.out.println(acc1);
        Customer customer1 = new Customer("John", "BLACK");
        System.out.println(customer1);
        customer1.setAccount(acc1);
        customer1.getAccount().deposit(1000);
        System.out.println(customer1);
        Customer customer2 = new Customer("Mary", "White");
        BankAccount acc2 =  new BankAccount("OTP0002");
        customer2.setAccount(acc2);
        System.out.println(customer2);
        customer2.getAccount().deposit(500);
        System.out.println(customer2);
        customer2.closeAccount();
        System.out.println(customer2);
        customer2.setAccount(customer1.getAccount());
        System.out.println(customer1);
        System.out.println(customer2);
    }
}
