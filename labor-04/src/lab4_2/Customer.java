package lab4_2;


import java.util.ArrayList;

public class Customer {
    private String firstName;
    private String lastName;

    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public void addAccount(BankAccount account) {
        this.accounts.add(account);
    }


    public BankAccount getAccount(String accountNumber){
        for (BankAccount a : accounts){
            if(a.getAccountNumber().equals(accountNumber)){
                return a;
            }
        }
        return null;
    }
    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void closeAccount(String accountNumber) {
        this.accounts = null;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
