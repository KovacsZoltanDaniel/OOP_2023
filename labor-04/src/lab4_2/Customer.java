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

    public Customer() {

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
        for (BankAccount a : accounts) {
            if(a.getAccountNumber().equals(accountNumber)){
                accounts.remove(a);
            }
        }
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(firstName).append(" ").append(lastName).append("accounts:\n");
        for (BankAccount account : accounts) {
            result.append("\t").append(account).append("\n");
        }
        return result.toString();
    }
}
