package codsoft.pjy.assignment;

/*
* A class that represent the user's bank account, which stores the account balance.
* Connect the ATM class with the user's bank account class to access and modify the account
 balance.
* Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).
*Display appropriate messages to the user based on their chosen options and the success or failure
 of their transactions.
*/

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: Rs." + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: Rs." + amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient funds");
            return false;
        } else {
            System.out.println("Invalid withdrawal amount");
            return false;
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: Rs." + balance);
    }
}

