package lab6_1;

public class BankAccount {
    public static final String PREFIX = "OTP";
    public static final int ACCOUNT_NUMBER_LENGTH = 10;
    private static int numAccounts = 0;
    private final String accountNumber;
    private double balance;

    public BankAccount(){
        ++numAccounts;
        this.accountNumber = createAccountNumber();
    }

    private static  String createAccountNumber(){
        int len = ACCOUNT_NUMBER_LENGTH - PREFIX.length();
        return String.format("%s%0" + len + "d", PREFIX, numAccounts);
    }
    public double getBalance(){
        return balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount){
        if(amount < 0){
            return;
        }
        this.balance += amount;
    }
    public boolean withDraw(double amount){
        if(amount < 0 ){
            return false;
        }
        if(amount > this.balance){
            return false;
        }
        this.balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                " balance=" + balance +
                '}'+"\n";
    }
}
