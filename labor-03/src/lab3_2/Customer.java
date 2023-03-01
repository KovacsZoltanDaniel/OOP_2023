package lab3_2;

import lab3_1.BankAccount;

public class Customer {
    // constant
    public static final int MAX_ACCOUNTS = 10;
    // number of accounts
    private int numAccounts;
    // an array for the accounts
    private BankAccount accounts[] = new BankAccount[ MAX_ACCOUNTS ];
    private String firstName;
    private String lastName;
    private BankAccount account;
    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addAccount(BankAccount account) {
        this.account = account;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public BankAccount getAccount() {

        return account;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public  void closeAccount(){
        this.account = null;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", account=" + account +
                '}';
    }
}
