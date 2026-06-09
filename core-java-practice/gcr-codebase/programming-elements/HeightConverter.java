

import java.util.Scanner;
public class HeightConverter {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter your height in cm: ");
            double heightCm = sc.nextDouble();

            double totalInches = heightCm / 2.54;   // cm → inches
            int feet = (int)(totalInches / 12);     // inches → feet
            double inches = totalInches % 12;       // remainder → inches

            System.out.println("Your Height in cm is " + heightCm + " cm");
            System.out.println("While in feet is " + feet + " ft and inches is " + String.format("%.2f", inches) + " in");
        }
    }
}
