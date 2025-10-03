package joshuaepstein;

import joshuaepstein.budget.BudgetManager;

public class Main {

    public static void main(String[] args) {
        BudgetManager manager = new BudgetManager();
        ConsoleMenu menu = new ConsoleMenu(manager, new java.util.Scanner(System.in));
        menu.start();
    }

}
