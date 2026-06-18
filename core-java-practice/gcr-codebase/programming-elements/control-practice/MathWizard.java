class MathWizard {
    static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) if (n % i == 0) return false;
        return true;
    }
    static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }
    static long fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        if (n <= 1) return n;
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) { long temp = b; b = a + b; a = temp; }
        return b;
    }
    
    static int gcd(int a, int b) {
        while (b != 0) { int temp = b; b = a % b; a = temp; }
        return Math.abs(a);
    }
    
    static long lcm(int a, int b) {
        return Math.abs((long) a * b) / gcd(a, b);
    }
    
    static double power(double base, int exp) {
        double result = 1;
        if (exp < 0) { base = 1 / base; exp = -exp; }
        for (int i = 0; i < exp; i++) result *= base;
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("isPrime(17): " + isPrime(17));
        System.out.println("factorial(5): " + factorial(5));
        System.out.println("fibonacci(10): " + fibonacci(10));
        System.out.println("gcd(48,18): " + gcd(48, 18));
        System.out.println("lcm(12,18): " + lcm(12, 18));
        System.out.println("power(2,8): " + power(2, 8));
    }
}