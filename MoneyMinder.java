import java.util.*;

public class MoneyMinder {
    public static void main(String[] args){
        String menuString = "------------------------ \n     MONEY MINDER \n------------------------ \n1. Add Expense \n2. Add income \n3. Exit \nPlease choose an option: ";
        Scanner scanner = new Scanner(System.in);
        int choice;
        User user = new User();
        while(true) {
            System.out.print(menuString);
            choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    addExpense(scanner);
                    break;
                case 2:
                    addIncome(user, scanner);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("NOT A VALID CHOICE");
            }
        }
    }
    public static void addIncome(User user, Scanner scanner) {
        while (true) {
            System.out.print("Enter income amount (enter 0 to stop): ");
            double amount = scanner.nextDouble();
            if (amount == 0) {
                break;
            }
            scanner.nextLine(); 
            System.out.print("Enter income source: ");
            String source = scanner.nextLine();

            user.addIncome(amount, source);
        }

        System.out.println("User's incomes:");
        for (Map<String, Object> income : user.getIncomes()) {
            System.out.println("Amount: $" + income.get("amount") + ", Source: " + income.get("source"));
        }
    } 

    public static void addExpense(Scanner scanner) {

        // Predefined list of expense categories
        String[] categories = {"Food", "Transportation", "Housing", "Entertainment", "Utilities", "Healthcare"};

        // List to store expenses as dictionaries
        List<Map<String, String>> expensesList = new ArrayList<>();

        // Ask the user to input expense details
        while (true) {
            // Ask for expense category
            System.out.println("Choose expense category:");
            for (int i = 0; i < categories.length; i++) {
                System.out.println((i + 1) + ". " + categories[i]);
            }
            System.out.print("Enter the number of the category: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // Validate user input
            if (choice >= 1 && choice <= categories.length) {
                String expenseCategory = categories[choice - 1];

                // Ask for expense name
                System.out.print("Enter expense name: ");
                String expenseName = scanner.nextLine();

                // Ask for expense value
                System.out.print("Enter expense value(only the number): ");
                String expenseValue = ("$" + scanner.nextLine()); 

                // Ask for date
                System.out.print("Enter date (e.g., YYYY-MM-DD): "); 
                String date = scanner.nextLine();

                // Create a dictionary to store expense details
                Map<String, String> expenseDetails = new HashMap<>();
                expenseDetails.put("expense name", expenseName);
                expenseDetails.put("expense category", expenseCategory);
                expenseDetails.put("expense value", expenseValue);
                expenseDetails.put("date", date);

                // Add the expense details dictionary to the expenses list
                expensesList.add(expenseDetails);

                System.out.println("Expense added successfully."); 

                // Print out all the expenses
                System.out.println("\nAll Expenses:");
                for (Map<String, String> expense : expensesList) {
                    System.out.println(expense);
                } 
            } 
            else 
            {
                System.out.println("Invalid choice. Please enter a number between 1 and " + categories.length); 
                scanner.close();
            }
        }
    }
}
