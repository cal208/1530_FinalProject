import java.util.*;

public class MoneyMinder {
    public static void main(String[] args){
        String menuString = "------------------------ \n     MONEY MINDER \n------------------------ \n1. Add Expense \n2. Add income \n3. Exit \nPlease choose an option: ";
        Scanner scanner = new Scanner(System.in);
        int choice;
        while(true) {
            System.out.print(menuString);
            choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("ADD EXPENSE METHOD HERE");
                    break;
                case 2:
                    System.out.println("ADD INCOME METHOD HERE");
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("NOT A VALID CHOICE");
            }
        }
    }
}