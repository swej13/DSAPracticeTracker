package dsapracticetracker;

import java.util.Scanner;
import java.util.Stack;

/*
 * Question:
 * Write a Java program to check whether brackets are balanced
 * using a stack.
 *
 * Examples:
 * {[()]}  -> Balanced
 * {[(])}  -> Not Balanced
 */

public class BalancedBrackets {

    // Check whether two brackets match
    static boolean isMatching(char open, char close) {

        return (open == '(' && close == ')')
                || (open == '[' && close == ']')
                || (open == '{' && close == '}');
    }

    // Check balanced brackets
    static boolean check(String expression) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            // Opening bracket → push
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }

            // Closing bracket
            else if (ch == ')' || ch == ']' || ch == '}') {

                // No opening bracket available
                if (stack.isEmpty()) {
                    return false;
                }

                char open = stack.pop();

                // Brackets do not match
                if (!isMatching(open, ch)) {
                    return false;
                }
            }
        }

        // Stack must be empty at the end
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter expression: ");
        String expression = sc.nextLine();

        if (check(expression)) {
            System.out.println("Brackets are Balanced.");
        } else {
            System.out.println("Brackets are Not Balanced.");
        }

        sc.close();
    }
}