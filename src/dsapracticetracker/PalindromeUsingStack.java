package dsapracticetracker;

import java.util.Scanner;
import java.util.Stack;

/*
 * Question:
 * Write a Java program to check whether a string is a palindrome
 * using a stack.
 *
 * Example:
 * Input  : MADAM
 * Output : Palindrome
 */

public class PalindromeUsingStack {

    static boolean checkPalindrome(String text) {

        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }

        // Compare original string with popped characters
        for (int i = 0; i < text.length(); i++) {

            if (text.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        if (checkPalindrome(text)) {
            System.out.println("Palindrome.");
        } else {
            System.out.println("Not a Palindrome.");
        }

        sc.close();
    }
}