package dsapracticetracker;

import java.util.Scanner;

/*
 * Question:
 * Write a Java program to implement a Queue using Linked List.
 *
 * Operations:
 * 1. Enqueue
 * 2. Dequeue
 * 3. Peek
 * 4. Display
 * 5. Is Empty
 * 6. Exit
 */

public class QueueUsingLinkedList {

    // Node represents one element of the queue
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node front = null;
    static Node rear = null;

    // Add element at rear
    static void enqueue(int value) {

        Node newNode = new Node(value);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println(value + " inserted into Queue.");
    }

    // Remove element from front
    static void dequeue() {

        if (front == null) {
            System.out.println("Queue Underflow!");
            return;
        }

        System.out.println(front.data + " removed from Queue.");

        front = front.next;

        if (front == null) {
            rear = null;
        }
    }

    // Show front element
    static void peek() {

        if (front == null) {
            System.out.println("Queue is Empty!");
        } else {
            System.out.println("Front element: " + front.data);
        }
    }

    // Display queue
    static void display() {

        if (front == null) {
            System.out.println("Queue is Empty!");
            return;
        }

        Node temp = front;

        System.out.println("Queue elements:");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    // Check empty
    static void isEmpty() {

        if (front == null) {
            System.out.println("Queue is Empty.");
        } else {
            System.out.println("Queue is not Empty.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println();
            System.out.println("==============================");
            System.out.println("   QUEUE USING LINKED LIST");
            System.out.println("==============================");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
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
                enqueue(value);
                break;

            case 2:
                dequeue();
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