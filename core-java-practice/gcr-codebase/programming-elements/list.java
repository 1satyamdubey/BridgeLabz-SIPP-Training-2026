import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class list {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Orange");

        Set<String> fruitSet = new LinkedHashSet<>(fruits);

        System.out.println("Original List: " + fruits);
        System.out.println("Converted Set: " + fruitSet);
    }
}
