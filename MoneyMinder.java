import java.util.*;

public class MoneyMinder {  
    public static void main(String[] args){
        openMenu();
        String menuString = "\n------------------------ \n     MONEY MINDER \n------------------------ \n1. Add or View Expense \n2. Add or View income \n3. Exit \nPlease choose an option: ";
        Scanner scanner = new Scanner(System.in); 
        int choice; 
        List<Map<String, Object>> incomes = new ArrayList<>();
        List<Map<String, String>> expensesList = new ArrayList<>();

        // Predefined list of expense categories
        ArrayList<String> categories = new ArrayList<String>();
        categories.add("Food");
        categories.add("Transportation");
        categories.add("Housing");
        categories.add("Entertainment");
        categories.add("Utilities");
        categories.add("Healthcare");
        
        while(true) {
            System.out.print(menuString);
            choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    addExpense(expensesList, categories, scanner);
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

        //Automatically input admin account
        userAccounts.put("admin", "admin");

        String option = "4";
        do{
            System.out.println("\n------------------------ \n     MONEY MINDER \n------------------------ \n1. Create Account \n2. Login \n3. Exit \nPlease choose an option: ");
            option = sc.nextLine();
            if(option.equals("1")){
                //CREATE USER
                ArrayList<String> tempUser = createUser();
                userAccounts.put(tempUser.get(0), tempUser.get(1));
            }
            else if(option.equals("2")){
                boolean loggedIn = login(userAccounts);
                if(loggedIn){
                    System.out.println("\nSuccessfully logged in!");
                }
                else{
                    System.out.println("\nLogin does not exist. Returning to opening menu...");
                    option = "4";
                }
            }
            else if(option.equals("3")){
                System.out.println("Goodbye!");
                System.exit(0);
            }
            else{
                System.out.println("Not an option. Please choose again.");
            }
    }while(!option.equals("1") && !option.equals("2") && !option.equals("3"));

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

    public static boolean login(HashMap<String, String> users){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> tempUser = new ArrayList<>();
        
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        tempUser.add(username);
        tempUser.add(password);
        
        //username exists in system
        if(users.containsKey(username)){
            //password match
            if(users.get(username).equals(password)){
                return true;
            }
            else{   //password doesn't match
                return false;
            }
        }
        else{   //username doesnt exist in system
            return false;
        }

    }
    
    public static void addIncome(List<Map<String, Object>> incomes, Scanner scanner) {
        while (true) {
            System.out.print("Enter income amount (type '0' to view all added expenses and return to main menu): ");
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
    
    public static void addExpense(List<Map<String, String>> expensesList, ArrayList<String> categories, Scanner scanner) 
    {
        // Ask the user to input expense details
        while (true) {

            // Print the list of categories before starting the loop
            int i;
            for (i = 0; i < categories.size(); i++) {
                System.out.println((i + 1) + ". " + categories.get(i));
            } 
            System.out.println((i + 1) + ". CUSTOM CATEGORY");
            System.out.print("Enter the number of the category (type '0' to view all added expenses and return to main menu): ");   
            int choice = scanner.nextInt();  
            
            if (choice == 0) {
                // Print out all the expenses
                System.out.println("\nAll Expenses:");
                for (Map<String, String> expense : expensesList) {
                    System.out.println("Expense Name: " + expense.get("Expense Name"));
                    System.out.println("Category: " + expense.get("Category"));
                    System.out.println("Value: " + expense.get("Value"));
                    System.out.println("Date: " + expense.get("Date"));
                    System.out.println();
                }
                break;
            }

            // Validate user input
            if (choice >= 1 && choice <= (i+1)) {
                //Add custom category to existing list of categories
                String expenseCategory;
                String expenseName;
                if(choice == (i+1)) {
                    System.out.print("Enter category name: ");
                    scanner.nextLine();
                    expenseCategory = scanner.nextLine();
                    categories.add(expenseCategory);
                    // Ask for expense name
                    System.out.print("Enter expense name: "); 
                    expenseName = scanner.nextLine();
                }else {
                    expenseCategory = categories.get(choice - 1);
                    // Ask for expense name
                    System.out.print("Enter expense name: "); 
                    scanner.nextLine();
                    expenseName = scanner.nextLine();
                }

                // Ask for expense value
                System.out.print("Enter expense value (only the number): ");
                String expenseValue = "$" + scanner.nextLine();

                // Ask for date
                System.out.print("Enter date (e.g., YYYY-MM-DD): ");
                String date = scanner.nextLine();

                // Create a dictionary to store expense details
                Map<String, String> expenseDetails = new HashMap<>();
                expenseDetails.put("Expense Name", expenseName);
                expenseDetails.put("Category", expenseCategory);
                expenseDetails.put("Value", expenseValue);
                expenseDetails.put("Date", date);

                // Add the expense details dictionary to the expenses list
                expensesList.add(expenseDetails);

                System.out.println("Expense added successfully.");

            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and " + categories.size());
            }
        }
    } 
}
