package dsapracticetracker;

import java.util.Scanner;

/*
 * Question:
 * Write a Java program to implement a Stack using Linked List.
 *
 * Operations:
 * 1. Push
 * 2. Pop
 * 3. Peek
 * 4. Display
 * 5. Is Empty
 * 6. Exit
 */

public class StackUsingLinkedList {

    // Node represents one element of the stack
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node top = null;

    // Push: add element at the top
    static void push(int value) {

        Node newNode = new Node(value);

        newNode.next = top;
        top = newNode;

        System.out.println(value + " pushed into Stack.");
    }

    // Pop: remove top element
    static void pop() {

        if (top == null) {
            System.out.println("Stack Underflow!");
            return;
        }

        System.out.println(top.data + " popped from Stack.");

        top = top.next;
    }

    // Peek: show top element
    static void peek() {

        if (top == null) {
            System.out.println("Stack is Empty!");
        } else {
            System.out.println("Top element: " + top.data);
        }
    }

    // Display stack
    static void display() {

        if (top == null) {
            System.out.println("Stack is Empty!");
            return;
        }

        Node temp = top;

        System.out.println("Stack elements:");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    // Check empty
    static void isEmpty() {

        if (top == null) {
            System.out.println("Stack is Empty.");
        } else {
            System.out.println("Stack is not Empty.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println();
            System.out.println("==============================");
            System.out.println("   STACK USING LINKED LIST");
            System.out.println("==============================");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Is Empty");
            System.out.println("6. Exit");
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
                System.out.println("Program ended.");
                break;

            default:
                System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}