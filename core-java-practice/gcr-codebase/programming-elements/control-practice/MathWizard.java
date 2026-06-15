
public class MathWizard {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) if (n % i == 0) return false;
        return true;
    }

    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative number");
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }

    public static long fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative index");
        if (n <= 1) return n;
        long prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs(a * b) / gcd(a, b);
    }

    public static double power(double base, int exp) {
        if (exp == 0) return 1.0;
        if (exp < 0) return 1.0 / power(base, -exp);
        double result = 1;
        for (int i = 0; i < exp; i++) result *= base;
        return result;
    }

    public static void main(String[] args) {
        System.out.println("isPrime(7): " + isPrime(7) + ", isPrime(10): " + isPrime(10));
        System.out.println("factorial(5): " + factorial(5) + ", factorial(0): " + factorial(0));
        System.out.println("fibonacci(10): " + fibonacci(10) + ", fibonacci(5): " + fibonacci(5));
        System.out.println("gcd(12,8): " + gcd(12, 8) + ", gcd(48,18): " + gcd(48, 18));
        System.out.println("lcm(12,8): " + lcm(12, 8) + ", lcm(4,6): " + lcm(4, 6));
        System.out.println("power(2,5): " + power(2, 5) + ", power(5,3): " + power(5, 3) + ", power(2,-2): " + power(2, -2));
    }
}
