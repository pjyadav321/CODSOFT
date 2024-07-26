package codsoft.pjy.assignment;

import java.util.Scanner;
/*
* A class that represent the ATM machine.
* Design the user interface for the ATM, including options such as withdrawing, depositing, and
 checking the balance.
* Implement methods for each option, such as withdraw(amount), deposit(amount), and
 checkBalance()
* */
class ATMInterface
{
    public static void main(String[] args)
    {
        BankAccount account = new BankAccount(42000.0); // Initial balance
        ATMInterface atm = new ATMInterface(account);
        atm.showMenu();
    }

    // Encapsulation  hiding internal detail
    private BankAccount account;
    private Scanner scanner;

    public ATMInterface(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    handleWithdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Have a Good Day!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);
    }

    private void handleDeposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void handleWithdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

}