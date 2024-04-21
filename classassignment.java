import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class User {
    private List<Map<String, Object>> incomes;

    public User() {
        this.incomes = new ArrayList<>();
    }

    public void addIncome(double amount, String source) {
        Map<String, Object> income = new HashMap<>();
        income.put("amount", amount);
        income.put("source", source);
        incomes.add(income);
    }

    public List<Map<String, Object>> getIncomes() {
        return incomes;
    }
}

public class classassignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User();

        // Loop to input incomes until user enters 0 to stop
        while (true) {
            System.out.print("Enter income amount (enter 0 to stop): ");
            double amount = scanner.nextDouble();
            if (amount == 0) {
                break;
            }
            scanner.nextLine(); // Consume newline character
            System.out.print("Enter income source: ");
            String source = scanner.nextLine();

            // Adding income
            user.addIncome(amount, source);
        }

        // Displaying user's incomes
        System.out.println("User's incomes:");
        for (Map<String, Object> income : user.getIncomes()) {
            System.out.println("Amount: $" + income.get("amount") + ", Source: " + income.get("source"));
        }

        // Close the scanner
        scanner.close();
    }
}
