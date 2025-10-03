package joshuaepstein.budget;

public record BudgetItem(String description, double amount) {

    public String toString() {
        return String.format("%s: $%.2f", description, amount);
    }

}
