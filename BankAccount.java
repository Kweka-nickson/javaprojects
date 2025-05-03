public class BankAccount {
    private double balance;
    private String accountHolder;
    
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited: $%.2f, New Balance: $%.2f%n", amount, balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Withdrawn: $%.2f, New Balance: $%.2f%n", amount, balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds!");
        }
    }
    
    public double getBalance() {
        return balance;
    }
    
    public static void main(String[] args) {
        BankAccount account = new BankAccount("John Doe", 1000.0);
        account.deposit(500.0);
        account.withdraw(200.0);
        account.withdraw(2000.0);
        System.out.printf("Final Balance: $%.2f%n", account.getBalance());
    }
}