package lab3_2;

import lab3_1.BankAccount;

public class Customer {
    private String firstName;
    private String lastName;
    //private BankAccount account;
    // constant
    public static final int MAX_ACCOUNTS = 10;
    // number of accounts
    private int numAccounts;
    // an array for the accounts
    private BankAccount accounts[] = new BankAccount[MAX_ACCOUNTS];

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getNumAccounts() {
        return numAccounts;
    }

    public void addAccount(BankAccount account) {
        if (numAccounts < MAX_ACCOUNTS) {
            accounts[numAccounts] = account;
        } else {
            System.out.println("User has reached the limit of the number of possible accounts.");
        }
        numAccounts++;

    }


    public BankAccount getAccount(String accountNumber) {
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
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
        int realNumAcc = numAccounts;
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                accounts[i] = accounts[numAccounts - 1];
                accounts[numAccounts - 1] = null;
                numAccounts--;
            }
        }
        if (realNumAcc == numAccounts) {
            System.out.println("The desired account is not existing!");
        }
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(firstName + ' ' + lastName + " accounts:\n");
        for (int i = 0; i < numAccounts; ++i) {
            result.append("\t" + accounts[i] + "\n");
        }
        return result.toString();

    }
}
