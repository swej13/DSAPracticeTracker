package dsapracticetracker;

import java.util.Scanner;
import java.util.Stack;

/*
 * Question:
 * Write a Java program to evaluate a postfix expression using a stack.
 *
 * Example:
 * Postfix : 23*54*+
 * Output  : 26
 *
 * Explanation:
 * 2 3 * = 6
 * 5 4 * = 20
 * 6 + 20 = 26
 */

public class PostfixEvaluation {

    // Evaluate postfix expression
    static int evaluate(String expression) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            // If character is a number, push it
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            }

            // If character is an operator
            else {

                int b = stack.pop();
                int a = stack.pop();

                int result = 0;

                switch (ch) {

                case '+':
                    result = a + b;
                    break;

                case '-':
                    result = a - b;
                    break;

                case '*':
                    result = a * b;
                    break;

                case '/':
                    result = a / b;
                    break;
                }

                // Push result back into stack
                stack.push(result);
            }
        }

        // Final answer
        return stack.pop();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter postfix expression: ");
        String expression = sc.nextLine();

        int result = evaluate(expression);

        System.out.println("Result: " + result);

        sc.close();
    }
}