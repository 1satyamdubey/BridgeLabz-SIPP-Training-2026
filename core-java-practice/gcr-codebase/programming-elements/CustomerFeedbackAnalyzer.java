import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class CustomerFeedbackAnalyzer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("\\bgood\\b", Pattern.CASE_INSENSITIVE);

        int goodFeedbackCount = 0;
        for (int i = 0; i < 5; i++) {
            String feedback = reader.readLine();
            if (feedback != null && pattern.matcher(feedback).find()) {
                goodFeedbackCount++;
            }
        }

        System.out.println("Good Feedback Count = " + goodFeedbackCount);
    }
}