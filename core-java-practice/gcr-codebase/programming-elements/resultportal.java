import java.io.*;

public class resultportal {
	public static void main(String[] args) {
		String in = args.length > 0 ? args[0] : "student_marks.txt", out = args.length > 1 ? args[1] : "report_card.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(in)); BufferedWriter bw = new BufferedWriter(new FileWriter(out, true))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] p = line.split(",");
				if (p.length < 2) continue;
				int sum = 0;
				for (int i = 1; i < p.length; i++) sum += Integer.parseInt(p[i].trim());
				bw.write("Name: " + p[0].trim() + System.lineSeparator());
				bw.write("Average: " + String.format("%.2f", (double) sum / (p.length - 1)) + System.lineSeparator());
				bw.write("Status: Forwarded Report Card" + System.lineSeparator() + System.lineSeparator());
			}
			System.out.println("Report cards written to " + out);
		} catch (FileNotFoundException e) {
			System.out.println("Input file not found: " + in);
		} catch (IOException | NumberFormatException e) {
			System.out.println("Error while processing files: " + e.getMessage());
		}
	}
}
