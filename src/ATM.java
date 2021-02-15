import java.util.Scanner;

public class ATM {
    private int thisAccountNumber;
    private Scanner input = new Scanner(System.in);
    private int pin;
    public boolean authenticated;

    private static final int BALANCE = 1;
    private static final int DEPOSIT = 2;
    private static final int WITHDRAWAL = 3;
    private static final int MAX_WITHDRAWAL = 4;
    private static final int EXIT = 5;
    Cash cashTracker = new Cash(1500);
    Account account1 = new Account(123456789, 12345, 800, 200);
    Account account2 = new Account(987654321, 54321, 1230, 150);
    Account currentAccount;


    public ATM()
    {
        authenticated = false;
        thisAccountNumber = 0;
    }

    public void run() {
        System.out.println("Welcome to Fake Bank,\nPlease insert your card (acc no.): ");
        thisAccountNumber = input.nextInt();
        System.out.println("\nPlease insert your PIN number: ");
        pin = input.nextInt();
        verifyUser(thisAccountNumber, pin);
        while (true)
        {
            if (authenticated == true) {
                useATM();
            }
        }
    }

    private void useATM() {
        String menu = "Please select an option\n" +
                "1 - View balance\n" +
                "2 - Make a deposit\n" +
                "3 - Make a withdrawal\n" +
                "4 - Display max withdrawal\n" +
                "5 - Exit\n";
        System.out.println(menu);

        int choice = input.nextInt();
        switch(choice)
        {
            case BALANCE:
                System.out.printf("Current balance: €%d\n\n", currentAccount.accountBalance());
                break;
            case DEPOSIT:
                System.out.println("Please enter Deposit amount: ");

                while (true) {
                    int depAmount = input.nextInt();
                    if (depAmount % 5 != 0) {
                        System.out.println("Please enter the amount in multiples of 5");
                    } else {
                        currentAccount.deposit(depAmount);
                        break;
                    }
                }

            case WITHDRAWAL:
                System.out.println("Please enter Withdrawal amount: ");
                while (true) {
                    int withAmount = input.nextInt();
                    if (withAmount % 5 != 0) {
                        System.out.println("Please enter the amount in multiples of 5");
                    } else {
                        currentAccount.withdraw(withAmount);
                        cashTracker.withdrawCash(withAmount);
                        break;
                    }
                }
                break;
            case MAX_WITHDRAWAL:
                System.out.printf("Max withdrawal is: €%d\n" , cashTracker.total_count);
                break;
            case EXIT:
                System.out.println("Goodbye");
                authenticated = false;
                thisAccountNumber = 0;
                System.out.println("\nThank you for using Fake Bank, Have a nice day");
                System.exit(0);
        }
    }

    public void verifyUser(int accountNumber, int pin)
    {
        if ((accountNumber == account1.accountNumber) && (pin == account1.pin)) {
            authenticated = true;
            currentAccount = account1;
        }
        else if ((accountNumber == account2.accountNumber) && (pin == account2.pin)) {
            authenticated = true;
            currentAccount = account2;
        }
        else {
            System.out.println("Incorrect Account number or PIN\nPlease try again");
            System.out.println("Account number:");
            thisAccountNumber = input.nextInt();
            System.out.println("PIN:");
            pin = input.nextInt();

            verifyUser(thisAccountNumber, pin);
            if (authenticated == false){
                System.out.println("exceeded attempts, please remove card");
                System.exit(0);
            }
        }
    }
}
