public class SumofNaturalNumbers {
    static int sumOfNatural(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumOfNatural(n - 1);
    }
    
    public static void main(String[] args) {
        int n = 5;
        int result = sumOfNatural(n);
        System.out.println("Sum of first " + n + " natural numbers: " + result);
    }
}
