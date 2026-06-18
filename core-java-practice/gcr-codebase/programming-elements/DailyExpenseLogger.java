import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class DailyExpenseLogger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter expense details in the format: Category - Amount");
        System.out.println("Press Enter on an empty line to finish.");

        try (FileWriter writer = new FileWriter("expenses.txt", true)) {
            while (true) {
                String expense = reader.readLine();
                if (expense == null || expense.trim().isEmpty()) {
                    break;
                }

                writer.write(expense);
                writer.write(System.lineSeparator());
            }
        }
    }
}