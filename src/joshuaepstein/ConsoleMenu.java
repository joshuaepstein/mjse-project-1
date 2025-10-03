package joshuaepstein;

import joshuaepstein.budget.BudgetItem;
import joshuaepstein.budget.BudgetManager;

import java.util.Scanner;

public class ConsoleMenu {

    private final BudgetManager manager;
    private final Scanner scanner; // handles inputs

    public ConsoleMenu(BudgetManager manager, Scanner scanner) {
        this.manager = manager;
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("Welcome to budget planner!");
        boolean running = true;

        while (running) {
            showMenu();

            int choice = readInt("Select an option: ");

            switch (choice) {
                case 1 -> addItem();
                case 2 -> removeItem();
                case 3 -> showSummary();
                case 4 -> running = false;
                default -> System.out.println("Invalid option!");
            }
        }

        System.out.println("Bye!");
    }

    private void showMenu() {
        System.out.println("Menu");
        System.out.println("1. Add items");
        System.out.println("2. Remove items");
        System.out.println("3. View summary");
        System.out.println("4. Exit");
    }

    private void addItem() {
        System.out.println("\n--- Add Budget Item ---");
        String description = readLine("Description: ");
        double amount = readDouble("Amount: £");
        manager.addItem(description, amount);
        System.out.println("Added item!");
    }

    private void removeItem() {
        System.out.println("\n--- Remove Budget Item ---");
        if (manager.isEmpty()) {
            System.out.println("No items to remove.");
            return;
        }
        listItems();
        int index = readInt("Select an item to remove: ") - 1;
        BudgetItem item = manager.removeItem(index);
        if (item == null) {
            System.out.println("Invalid index.");
        } else {
            System.out.println("Removed item: " + item.description());
        }
    }

    private void showSummary() {
        System.out.println("\n--- Budget Summary ---");
        if (manager.isEmpty()) {
            System.out.println("No items have been added yet...");
            return;
        }
        listItems();
        System.out.println("Total Budget: £" + String.format("%.2f", manager.getTotal()));
    }

    private void listItems() {
        for (int i = 0; i < manager.getItems().size(); i++) {
            BudgetItem item = manager.getItems().get(i);
            System.out.println((i + 1) + ". " + item.description() + "(£" + item.amount() + ")");
        }
    }


    private int readInt(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private double readDouble(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private String readLine(String prompt) {
        System.out.println(prompt);
        String line = scanner.nextLine().trim();
        if (line.isEmpty()) {
            return "No description";
        }
        return line;
    }

}
