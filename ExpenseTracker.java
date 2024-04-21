import java.util.*;

public class ExpenseTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
