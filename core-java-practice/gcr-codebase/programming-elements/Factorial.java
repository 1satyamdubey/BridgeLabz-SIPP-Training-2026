public class Factorial {
    static long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }
    
    public static void main(String[] args) {
        int n = 5;
        long result = calculateFactorial(n);
        System.out.println("Factorial of " + n + " is: " + result);
    }
}
