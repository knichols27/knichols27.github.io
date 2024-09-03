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
