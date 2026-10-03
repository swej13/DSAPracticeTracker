package dsapracticetracker;

import java.util.Scanner;

/*
 * Question:
 * Write a Java program to implement a Circular Queue using an array.
 *
 * Operations:
 * 1. Enqueue
 * 2. Dequeue
 * 3. Peek
 * 4. Display
 * 5. Is Empty
 * 6. Is Full
 */

public class CircularQueue {

    static int[] queue;
    static int front = -1;
    static int rear = -1;

    // Add element to Circular Queue
    static void enqueue(int value) {

        // Queue is full
        if ((rear + 1) % queue.length == front) {
            System.out.println("Queue Overflow!");
            return;
        }

        // First element
        if (front == -1) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % queue.length;
        }

        queue[rear] = value;

        System.out.println(value + " inserted into Queue.");
    }

    // Remove element from Circular Queue
    static void dequeue() {

        // Queue is empty
        if (front == -1) {
            System.out.println("Queue Underflow!");
            return;
        }

        System.out.println(queue[front] + " removed from Queue.");

        // Only one element was present
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % queue.length;
        }
    }

    // Show first element
    static void peek() {

        if (front == -1) {
            System.out.println("Queue is Empty!");
        } else {
            System.out.println("Front element: " + queue[front]);
        }
    }

    // Display Circular Queue
    static void display() {

        if (front == -1) {
            System.out.println("Queue is Empty!");
            return;
        }

        System.out.println("Queue elements:");

        int i = front;

        while (true) {

            System.out.print(queue[i] + " ");

            if (i == rear) {
                break;
            }

            i = (i + 1) % queue.length;
        }

        System.out.println();
    }

    // Check whether Queue is Empty
    static void isEmpty() {

        if (front == -1) {
            System.out.println("Queue is Empty.");
        } else {
            System.out.println("Queue is not Empty.");
        }
    }

    // Check whether Queue is Full
    static void isFull() {

        if ((rear + 1) % queue.length == front) {
            System.out.println("Queue is Full.");
        } else {
            System.out.println("Queue is not Full.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Queue size: ");
        int size = sc.nextInt();

        queue = new int[size];

        int choice;

        do {

            System.out.println();
            System.out.println("================================");
            System.out.println("       CIRCULAR QUEUE");
            System.out.println("================================");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Is Empty");
            System.out.println("6. Is Full");
            System.out.println("7. Exit");
            System.out.println("================================");

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