package lab8_1;


import java.util.ArrayList;

public class Customer {
    private static int numCustomers = 1;
    private final int id ;
    private String firstName;
    private String lastName;
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = numCustomers++;
    }

    public int getId() {
        return id;
    }
    public int getNumAccounts(){
        return accounts.size();
    }
    public ArrayList<String> getAccountNumbers() {
        ArrayList<String> result = new ArrayList<>();
        for (BankAccount account : accounts) {
            result.add(account.getAccountNumber());
        }
        return result;
    }
    public void addAccount(BankAccount bankAccount){
        accounts.add(bankAccount);
    }
    public BankAccount getAccount(String accountNumber){
        for (BankAccount a : accounts){
            if(a.getAccountNumber().equals(accountNumber)){
                return a;
            }
        }
        return null;
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
        for (int i = 0; i < accounts.size(); i++) {
            if(accounts.get(i).getAccountNumber().equals(accountNumber)){
                accounts.remove(accounts.get(i));
            }
        }
    }
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(firstName).append(" ").append(lastName).append(id).append(" accounts:\n");
        for (BankAccount account : accounts) {
            result.append("\t").append(account).append("\n");
        }
        return result.toString();
    }
}
