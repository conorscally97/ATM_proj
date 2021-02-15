public class Account {
    public int accountNumber;
    public int pin;
    public boolean overdrawn = false;
    private int balance;
    private int overdraft;

    public Account(int accountNumber, int pin, int balance, int overdraft) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        this.overdraft = overdraft;
    }

    public int accountBalance() {
        return balance;
    }

    public void deposit(int deposit_amount) {
        balance += deposit_amount;
        System.out.printf("Balance is now: %d\n", balance);
    }

    public void withdraw(int withdraw_amount) {
        if ((balance - withdraw_amount) > (-overdraft)) {
            balance -= withdraw_amount;
            System.out.printf("Balance is now: %d\n", balance);
        } else {
            overdrawn = true;
            System.out.println("Sorry, insufficient funds");
        }

    }
}
