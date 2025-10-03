package joshuaepstein.budget;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BudgetManager {

    private final List<BudgetItem> items = new ArrayList<>();

    public boolean addItem(String description, double amount) {
        return items.add(new BudgetItem(description, amount));
    }

    public @Nullable BudgetItem removeItem(int index) {
        if (index < 0 || index >= items.size()) {
            return null;
        }
        return items.remove(index);
    }

    public double getTotal() {
        return items.stream().mapToDouble(BudgetItem::amount).sum();
    }

    public List<BudgetItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }
}
