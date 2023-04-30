package lab6_1;


import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Customer {
    private String firstName;
    private String lastName;
    private ArrayList<BankAccount> accounts = new ArrayList<>();
    private static AtomicInteger counter = new AtomicInteger(1);
    private final int ID;
    private static int numCustomers = 0;

    public Customer(String firstName, String lastName) {
        ++numCustomers;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = counter.getAndIncrement();
    }

    public int getID() {
        return ID;
    }

    public int getNumAccounts() {
        return accounts.size();
    }

    public ArrayList<String> getAccountNumbers() {
        ArrayList<String> accountNumbers = new ArrayList<>();
        for (int i = 0; i < getNumAccounts(); i++) {
            accountNumbers.add(accounts.get(i).getAccountNumber());
        }
        return accountNumbers;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public BankAccount getAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
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

    public void closeAccount(String accountNumber) {
        int numAccountsOriginal = accounts.size();
        for (BankAccount account: accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                accounts.remove(account);
                break;
            }
        }
        if (numAccountsOriginal == accounts.size()) {
            System.out.println("Account is not existing!");
        }
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(firstName + ' ' + lastName + "(id: " + ID + ")" + " accounts:\n");
        for (BankAccount account : accounts) {
            result.append("\t" + account + "\n");
        }
        return result.toString();
    }
}
