import java.util.Random;

public class BankAccount {
    private String accountNumber;
    private double currentBalance;
    private double savingsBalance;
    private double totalMoney;
    public static int instanceCounter;

    public BankAccount() {
        this.accountNumber = generateAccountNumber();
        instanceCounter++;
    }

    private String generateAccountNumber() {
        Random r = new Random();
        String accNumber = "";
        for (int i=0; i<10; i++) {
            int randomNumber = r.nextInt(10);
            accNumber += randomNumber;
        }
        return accNumber;
    }

    public double getCurrentBalance() {
        return this.currentBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getTotalBalance() {
        updateTotalMoney();
        return this.totalMoney;
    }

    private void updateTotalMoney() {
        this.totalMoney = this.currentBalance + this.savingsBalance;
    }

    public void depositCurrent(double amount) {
        this.currentBalance += amount;
        updateTotalMoney();
    }

    public void depositSavings(double amount) {
        this.savingsBalance += amount;
        updateTotalMoney();
    }

    public void withdraw(double amount) {
        if (amount > this.currentBalance) {
            return;
        }
        this.currentBalance -= amount;
        updateTotalMoney();
    }

    public static int accountsCreated() {
        return instanceCounter;
    }
}