import java.util.*;

public class MoneyMinder {  
    public static void main(String[] args){
        openMenu();
        String menuString = "\n------------------------ \n     MONEY MINDER \n------------------------ \n1. Add Expense \n2. Add income \n3. Exit \nPlease choose an option: ";
        Scanner scanner = new Scanner(System.in); 
        int choice; 
        List<Map<String, Object>> incomes = new ArrayList<>();
        
        while(true) {
            System.out.print(menuString);
            choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    addExpense(scanner);
                    break;
                case 2:
                    addIncome(incomes, scanner);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("NOT A VALID CHOICE");
            }
        }
    }

        //user must login or create user
    public static void openMenu(){
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> userAccounts = new HashMap<>();
        String option = "3";
        do{
            System.out.println("Pick an option: \n1. Create a User");
            option = sc.nextLine();
            if(option.equals("1")){
                //CREATE USER
                ArrayList<String> tempUser = createUser();
                userAccounts.put(tempUser.get(0), tempUser.get(1));
            }
            // else if(option.equals("2")){
            //     //login will go here
            // }
            else{
                System.out.println("Not an option. Please choose again.");
            }
    }while(!option.equals("1") /*&& !option.equals("2")*/);

    }

    public static ArrayList<String> createUser(){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> user = new ArrayList<>();
        
        System.out.print("Create a username: ");
        String username = sc.nextLine();

        System.out.print("Create a password: ");
        String password = sc.nextLine();

        user.add(username);
        user.add(password);

        return user;
    }
    
    public static void addIncome(List<Map<String, Object>> incomes, Scanner scanner) {
        while (true) {
            System.out.print("Enter/View income amount (enter 0 to view and exit): ");
            double amount = scanner.nextDouble();
            if (amount == 0) {
                break;
            }
            scanner.nextLine(); 
            System.out.print("Enter income source: ");
            String source = scanner.nextLine();

            Map<String, Object> income = new HashMap<>();
            income.put("amount", amount);
            income.put("source", source);
            incomes.add(income);
        }

        System.out.println("User's incomes:");
        for (Map<String, Object> income : incomes) {
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
