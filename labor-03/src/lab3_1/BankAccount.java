package lab3_1;

public class BankAccount {
    private  String accountNumber;
    private double balance;

    public BankAccount(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance(){
        return balance;
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
                ", balance=" + balance +
                '}';
    }
}
