import java.util.*;

public class WarehouseStore{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

        // Input array size
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        int[] stock = new int[n];

        // Input stock quantities
        System.out.println("Enter stock quantities:");
        for (int i = 0; i < n; i++) {
            stock[i] = sc.nextInt();
        }

        // Max, Min, Total
        int max = stock[0], min = stock[0], total = 0;
        for (int val : stock) {
            if (val > max) max = val;
            if (val < min) min = val;
            total += val;
        }

        System.out.println("Max stock: " + max);
        System.out.println("Min stock: " + min);
        System.out.println("Total stock: " + total);

        // Detect duplicates
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for (int val : stock) {
            if (!seen.add(val)) {
                duplicates.add(val);
            }
        }
        if (duplicates.isEmpty()) {
            System.out.println("No duplicates found.");
        } else {
            System.out.println("Duplicate items: " + duplicates);
        }

        // Rotate array by k
        System.out.print("Enter k (positions to rotate): ");
        int k = sc.nextInt();
        k = k % n; // normalize
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = stock[i];
        }
        System.out.println("Rotated stock array: " + Arrays.toString(rotated));

        // Input 2D shelf grid
        System.out.print("Enter rows of shelf grid: ");
        int rows = sc.nextInt();
        System.out.print("Enter cols of shelf grid: ");
        int cols = sc.nextInt();
        int[][] shelf = new int[rows][cols];

        System.out.println("Enter shelf grid values:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                shelf[i][j] = sc.nextInt();
            }
        }

        // Transpose grid
        int[][] transpose = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = shelf[i][j];
            }
        }

        System.out.println("Transposed shelf grid:");
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }
        }
    }
}
