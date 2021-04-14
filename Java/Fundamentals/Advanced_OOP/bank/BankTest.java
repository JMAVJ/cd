public class BankTest {
    public static void main(String[] args) {
        BankAccount b = new BankAccount();
        BankAccount b2 = new BankAccount();
        b2.depositCurrent(10.50);
        System.out.println(b.getCurrentBalance());
        System.out.println(b.getTotalBalance());
        b.depositCurrent(50.00);
        b.depositSavings(100);
        System.out.println(b.getCurrentBalance());
        System.out.println(b.getTotalBalance());
        b.withdraw(20);
        System.out.println(b.getTotalBalance());
        b.withdraw(500);
        System.out.println(b.getTotalBalance());
        System.out.println(BankAccount.accountsCreated());
    }
}
