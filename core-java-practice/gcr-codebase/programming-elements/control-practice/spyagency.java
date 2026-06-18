import java.util.HashMap;
import java.util.Map;

public class spyagency {
    
    // ============ Message Encoding ============
    /**
     * Encode a message using Caesar cipher (shift by 3)
     */
    public static String encodeMessage(String message) {
        StringBuilder encoded = new StringBuilder();
        int shift = 3;
        
        for (char c : message.toCharArray()) {
            if (Character.isUpperCase(c)) {
                encoded.append((char) ((c - 'A' + shift) % 26 + 'A'));
            } else if (Character.isLowerCase(c)) {
                encoded.append((char) ((c - 'a' + shift) % 26 + 'a'));
            } else {
                encoded.append(c); // Keep non-alphabetic characters as is
            }
        }
        return encoded.toString();
    }
    
    // ============ Reverse Message ============
    /**
     * Reverse a secret message
     */
    public static String reverseMessage(String message) {
        return new StringBuilder(message).reverse().toString();
    }
    
    // ============ Palindrome Check ============
    /**
     * Check if a message is a palindrome (ignoring spaces and case)
     */
    public static boolean isPalindrome(String message) {
        // Remove spaces and convert to lowercase
        String cleaned = message.replaceAll(" ", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }
    
    // ============ Count Vowels and Consonants ============
    /**
     * Count vowels and consonants in a message
     */
    public static void countVowelsAndConsonants(String message) {
        int vowels = 0;
        int consonants = 0;
        
        String vowelSet = "aeiouAEIOU";
        
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                if (vowelSet.contains(String.valueOf(c))) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        
        System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
    }
    
    // ============ Anagram Verification ============
    /**
     * Check if two intercepted messages are anagrams of each other
     */
    public static boolean areAnagrams(String message1, String message2) {
        // Remove spaces and convert to lowercase for comparison
        String cleaned1 = message1.replaceAll(" ", "").toLowerCase();
        String cleaned2 = message2.replaceAll(" ", "").toLowerCase();
        
        // If lengths are different, they can't be anagrams
        if (cleaned1.length() != cleaned2.length()) {
            return false;
        }
        
        // Convert to char arrays and sort them
        char[] arr1 = cleaned1.toCharArray();
        char[] arr2 = cleaned2.toCharArray();
        
        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);
        
        // Compare sorted arrays
        return java.util.Arrays.equals(arr1, arr2);
    }
    
    // ============ First Non-Repeating Character ============
    /**
     * Find the first non-repeating character in a surveillance log
     */
    public static Character findFirstNonRepeatingCharacter(String surveillanceLog) {
        // Create a HashMap to store character frequencies
        Map<Character, Integer> charFrequency = new HashMap<>();
        
        // Count frequency of each character
        for (char c : surveillanceLog.toCharArray()) {
            if (Character.isLetter(c)) {
                char lowerChar = Character.toLowerCase(c);
                charFrequency.put(lowerChar, charFrequency.getOrDefault(lowerChar, 0) + 1);
            }
        }
        
        // Find the first character with frequency 1
        for (char c : surveillanceLog.toCharArray()) {
            if (Character.isLetter(c)) {
                char lowerChar = Character.toLowerCase(c);
                if (charFrequency.get(lowerChar) == 1) {
                    return c;
                }
            }
        }
        
        return null; // No non-repeating character found
    }
    
    // ============ Display Results ============
    /**
     * Helper method to display separator line
     */
    public static void printSeparator() {
        System.out.println("================================================");
    }
    
    // ============ Main Method ============
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║         SPY AGENCY MESSAGE PROCESSOR           ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        
        // Test 1: Message Encoding
        System.out.println("\n1. MESSAGE ENCODING (Caesar Cipher - Shift by 3)");
        printSeparator();
        String originalMessage = "hello world";
        String encodedMessage = encodeMessage(originalMessage);
        System.out.println("Original: " + originalMessage);
        System.out.println("Encoded:  " + encodedMessage);
        
        // Test 2: Reverse Message
        System.out.println("\n2. REVERSE SECRET MESSAGE");
        printSeparator();
        String secretMessage = "secret message";
        String reversedMessage = reverseMessage(secretMessage);
        System.out.println("Original: " + secretMessage);
        System.out.println("Reversed: " + reversedMessage);
        
        // Test 3: Palindrome Check
        System.out.println("\n3. PALINDROME CHECK");
        printSeparator();
        String[] testStrings = {"racecar", "madam", "hello", "A man a plan a canal Panama"};
        for (String test : testStrings) {
            boolean palindrome = isPalindrome(test);
            System.out.println("\"" + test + "\" -> Palindrome: " + palindrome);
        }
        
        // Test 4: Count Vowels and Consonants
        System.out.println("\n4. COUNT VOWELS AND CONSONANTS");
        printSeparator();
        String messageToAnalyze = "The quick brown fox jumps";
        System.out.println("Message: " + messageToAnalyze);
        countVowelsAndConsonants(messageToAnalyze);
        
        // Test 5: Anagram Verification
        System.out.println("\n5. ANAGRAM VERIFICATION (Two Intercepts)");
        printSeparator();
        String intercept1 = "listen";
        String intercept2 = "silent";
        String intercept3 = "hello";
        
        boolean isAnagram1 = areAnagrams(intercept1, intercept2);
        boolean isAnagram2 = areAnagrams(intercept1, intercept3);
        
        System.out.println("\"" + intercept1 + "\" and \"" + intercept2 + "\" -> Anagrams: " + isAnagram1);
        System.out.println("\"" + intercept1 + "\" and \"" + intercept3 + "\" -> Anagrams: " + isAnagram2);
        
        // Test 6: First Non-Repeating Character
        System.out.println("\n6. FIRST NON-REPEATING CHARACTER (Surveillance Log)");
        printSeparator();
        String surveillanceLog = "programming";
        Character firstNonRepeating = findFirstNonRepeatingCharacter(surveillanceLog);
        System.out.println("Surveillance Log: " + surveillanceLog);
        if (firstNonRepeating != null) {
            System.out.println("First Non-Repeating Character: " + firstNonRepeating);
        } else {
            System.out.println("No non-repeating character found.");
        }
        
        // Additional test cases
        String surveillanceLog2 = "aabbcc";
        Character firstNonRepeating2 = findFirstNonRepeatingCharacter(surveillanceLog2);
        System.out.println("\nSurveillance Log: " + surveillanceLog2);
        if (firstNonRepeating2 != null) {
            System.out.println("First Non-Repeating Character: " + firstNonRepeating2);
        } else {
            System.out.println("No non-repeating character found.");
        }
        
        System.out.println("\n" + "=".repeat(48));
        System.out.println("Mission Complete!");
    }
}
