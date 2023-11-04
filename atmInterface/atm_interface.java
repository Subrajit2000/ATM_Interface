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
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

// 1. Class to represent the ATM machine.
class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    // 3. Implement methods for each option.
    public void deposit(double amount) {
        bankAccount.deposit(amount);
        System.out.println("Deposited: $" + amount);
    }

    public void withdraw(double amount) {
        if (bankAccount.withdraw(amount)) {
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Balance: $" + bankAccount.getBalance());
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance of $1000
        ATM atm = new ATM(userAccount);

        Scanner scanner = new Scanner(System.in);
        boolean continueUsing = true;

        // 2. Design the user interface for the ATM.
        while (continueUsing) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            double amount;

            switch (choice) {
                case 1: // Withdraw
                    System.out.println("Enter amount to withdraw:");
                    amount = scanner.nextDouble();
                    // 6. Validate user input
                    if (amount <= 0) {
                        System.out.println("Enter a valid amount.");
                    } else {
                        atm.withdraw(amount);
                    }
                    break;
                case 2: // Deposit
                    System.out.println("Enter amount to deposit:");
                    amount = scanner.nextDouble();
                    // 6. Validate user input
                    if (amount <= 0) {
                        System.out.println("Enter a valid amount.");
                    } else {
                        atm.deposit(amount);
                    }
                    break;
                case 3: // Check Balance
                    atm.checkBalance();
                    break;
                case 4: // Exit
                    continueUsing = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            // 7. Display appropriate messages
            System.out.println("Transaction complete.");
        }
    }
}