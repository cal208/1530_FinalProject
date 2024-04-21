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
                    System.out.println("ADD EXPENSE METHOD HERE");
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
}
