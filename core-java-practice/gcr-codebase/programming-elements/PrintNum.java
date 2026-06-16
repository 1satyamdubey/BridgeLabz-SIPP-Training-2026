public class printnum {
    
    // Recursive function to print numbers from N to 1
    static void printNumbers(int n) {
        // Base case: if n is 0 or less, stop recursion
        if (n == 0) {
            return;
        }
        
        // Print current number
        System.out.print(n + " ");
        
        // Recursive call with n-1
        printNumbers(n - 1);
    }
    
    public static void main(String[] args) {
        int n = 5;
        
        // Function call to print numbers from N to 1
        printNumbers(n);
        
        // Output: 5 4 3 2 1
    }
}
