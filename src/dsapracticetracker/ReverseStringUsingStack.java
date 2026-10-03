package dsapracticetracker;

import java.util.Scanner;
import java.util.Stack;

/*
 * Question:
 * Write a Java program to reverse a string using a stack.
 *
 * Example:
 * Input  : HELLO
 * Output : OLLEH
 */

public class ReverseStringUsingStack {

    static String reverse(String text) {

        Stack<Character> stack = new Stack<>();

        // Push every character into stack
        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }

        String result = "";

        // Pop characters to get reverse order
        while (!stack.isEmpty()) {
            result = result + stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        System.out.println("Reversed string: " + reverse(text));

        sc.close();
    }
}