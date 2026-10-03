package dsapracticetracker;

import java.util.Scanner;
import java.util.Stack;

/*
 * Question:
 * Write a Java program to convert an infix expression
 * into postfix expression using a stack.
 *
 * Example:
 * Infix  : A+B*C
 * Postfix: ABC*+
 */

public class InfixToPostfix {

    // Check priority of operators
    static int precedence(char ch) {

        if (ch == '+' || ch == '-') {
            return 1;
        }

        if (ch == '*' || ch == '/') {
            return 2;
        }

        if (ch == '^') {
            return 3;
        }

        return 0;
    }

    // Convert infix to postfix
    static String convert(String expression) {

        Stack<Character> stack = new Stack<>();
        String result = "";

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            // Operand → directly add to result
            if (Character.isLetterOrDigit(ch)) {
                result = result + ch;
            }

            // Opening bracket → push
            else if (ch == '(') {
                stack.push(ch);
            }

            // Closing bracket → pop until '('
            else if (ch == ')') {

                while (!stack.isEmpty() && stack.peek() != '(') {
                    result = result + stack.pop();
                }

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            // Operator
            else {

                while (!stack.isEmpty()
                        && stack.peek() != '('
                        && precedence(stack.peek()) >= precedence(ch)) {

                    result = result + stack.pop();
                }

                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            result = result + stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter infix expression: ");
        String expression = sc.nextLine();

        String postfix = convert(expression);

        System.out.println("Postfix expression: " + postfix);

        sc.close();
    }
}