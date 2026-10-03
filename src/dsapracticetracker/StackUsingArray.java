package dsapracticetracker;

import java.util.Scanner;

/*
 * Question:
 * Write a Java program to implement a Stack using an array.
 *
 * Operations:
 * 1. Push
 * 2. Pop
 * 3. Peek
 * 4. Display
 * 5. Is Empty
 * 6. Is Full
 */

public class StackUsingArray {

    static int[] stack;
    static int top = -1;

    // Push: Add element to the top of stack
    static void push(int value) {

        // Overflow: stack is full
        if (top == stack.length - 1) {
            System.out.println("Stack Overflow!");
            return;
        }

        top++;
        stack[top] = value;

        System.out.println(value + " pushed into Stack.");
    }

    // Pop: Remove top element
    static void pop() {

        // Underflow: stack is empty
        if (top == -1) {
            System.out.println("Stack Underflow!");
            return;
        }

        System.out.println(stack[top] + " popped from Stack.");

        top--;
    }

    // Peek: Show top element without removing it
    static void peek() {

        if (top == -1) {
            System.out.println("Stack is Empty!");
        } else {
            System.out.println("Top element: " + stack[top]);
        }
    }

    // Display all elements
    static void display() {

        if (top == -1) {
            System.out.println("Stack is Empty!");
            return;
        }

        System.out.println("Stack elements:");

        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }

        System.out.println();
    }

    // Check whether stack is empty
    static void isEmpty() {

        if (top == -1) {
            System.out.println("Stack is Empty.");
        } else {
            System.out.println("Stack is not Empty.");
        }
    }

    // Check whether stack is full
    static void isFull() {

        if (top == stack.length - 1) {
            System.out.println("Stack is Full.");
        } else {
            System.out.println("Stack is not Full.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Stack size: ");
        int size = sc.nextInt();

        stack = new int[size];

        int choice;

        do {

            System.out.println();
            System.out.println("==============================");
            System.out.println("       STACK USING ARRAY");
            System.out.println("==============================");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Is Empty");
            System.out.println("6. Is Full");
            System.out.println("7. Exit");
            System.out.println("==============================");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:
                System.out.print("Enter value: ");
                int value = sc.nextInt();

                push(value);
                break;

            case 2:
                pop();
                break;

            case 3:
                peek();
                break;

            case 4:
                display();
                break;

            case 5:
                isEmpty();
                break;

            case 6:
                isFull();
                break;

            case 7:
                System.out.println("Program ended.");
                break;

            default:
                System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}