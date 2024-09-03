import java.util.HashMap; 
import java.util.Scanner;
//Bank Account ATM Management System class
class Account {
    private String customerName;
    private int customerID;
    private double balance;

    public Account(String customerName, int customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) { //Withdraw function
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void transfer(Account toAccount, double amount) {
        if (balance >= amount) {
            withdraw(amount);
            toAccount.deposit(amount);
        } else {
            System.out.println("Insufficient funds for the transfer.");
        }
    }
}
//Checking account
class CheckingAccount extends Account {
    public CheckingAccount(String customerName, int customerID) {
        super(customerName, customerID);
    }

    public void writeCheck(double amount) {
        withdraw(amount);
        System.out.println("Check written for: $" + amount);
    }
}
//Saving account
class SavingsAccount extends Account {
    public SavingsAccount(String customerName, int customerID) {
        super(customerName, customerID);
    }

    public void compoundInterest() {
        double interest = getBalance() * 0.05; // Adjust the interest rate as needed
        deposit(interest);
        System.out.println("Interest added: $" + interest);
    }
}
//Loan account
class LoanAccount extends Account {
    public LoanAccount(String customerName, int customerID) {
        super(customerName, customerID);
    }

    public void checkLoanBalance() {
        System.out.println("Loan Balance: $" + getBalance());
    }
}

class Bank {
    private HashMap<Integer, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void addAccount(int customerID, Account account) {
        accounts.put(customerID, account);
    }

    public Account getAccount(int customerID) {
        return accounts.get(customerID);
    }
}
//Main function
public class BankingApp {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Smooth Banking App!");

        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Perform Transaction");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (option == 1) {
                System.out.print("Enter customer name: ");
                String customerName = scanner.nextLine();
                System.out.print("Enter customer ID: ");
                int customerID = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                System.out.println("1. Checking Account");
                System.out.println("2. Savings Account");
                System.out.println("3. Loan Account");
                System.out.print("Select an account type: ");
                int accountType = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                Account account;

                if (accountType == 1) {
                    account = new CheckingAccount(customerName, customerID);
                } else if (accountType == 2) {
                    account = new SavingsAccount(customerName, customerID);
                } else if (accountType == 3) {
                    account = new LoanAccount(customerName, customerID);
                } else {
                    System.out.println("Invalid account type.");
                    continue;
                }

                bank.addAccount(customerID, account);
                System.out.println("Account created successfully.");
            } else if (option == 2) {
                System.out.print("Enter customer ID: ");
                int customerID = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                Account account = bank.getAccount(customerID);

                if (account == null) {
                    System.out.println("Account not found.");
                    continue;
                }

                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Transfer");
                System.out.println("4. Check Balance");
                
                if (account instanceof CheckingAccount) {
                    System.out.println("5. Write a Check");
                } else if (account instanceof SavingsAccount) {
                    System.out.println("5. Compound Interest");
                } else if (account instanceof LoanAccount) {
                    System.out.println("5. Check Loan Balance");
                }
                
                System.out.print("Select a transaction: ");
                int transactionType = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (transactionType == 1) {
                    System.out.print("Enter deposit amount: ");
                    double amount = scanner.nextDouble();
                    account.deposit(amount);
                    System.out.println("Deposit successful.");
                } else if (transactionType == 2) {
                    System.out.print("Enter withdrawal amount: ");
                    double amount = scanner.nextDouble();
                    account.withdraw(amount);
                } else if (transactionType == 3) {
                    System.out.print("Enter target customer ID: ");
                    int targetID = scanner.nextInt();
                    Account toAccount = bank.getAccount(targetID);
                    if (toAccount == null) {
                        System.out.println("Target account not found.");
                        continue;
                    }
//Print values
                    System.out.print("Enter transfer amount: ");
                    double amount = scanner.nextDouble();
                    account.transfer(toAccount, amount);
                    System.out.println("Transfer successful.");
                } else if (transactionType == 4) {
                    double balance = account.getBalance();
                    System.out.println("Account Balance: $" + balance);
                } else if (transactionType == 5) {
                    if (account instanceof CheckingAccount) {
                        CheckingAccount checkingAccount = (CheckingAccount) account;
                        System.out.print("Enter check amount: ");
                        double amount = scanner.nextDouble();
                        checkingAccount.writeCheck(amount);
                    } else if (account instanceof SavingsAccount) {
                        SavingsAccount savingsAccount = (SavingsAccount) account;
                        savingsAccount.compoundInterest();
                    } else if (account instanceof LoanAccount) {
                        LoanAccount loanAccount = (LoanAccount) account;
                        loanAccount.checkLoanBalance();
                    }
                } else {
                    System.out.println("Invalid transaction type.");
                }
            } else if (option == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }
}
