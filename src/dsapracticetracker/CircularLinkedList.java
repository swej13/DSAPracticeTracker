package dsapracticetracker;

import java.util.Scanner;

/*
 * Question:
 * Write a Java program to implement a Circular Linked List.
 *
 * Operations:
 * 1. Insert at Beginning
 * 2. Insert at End
 * 3. Delete from Beginning
 * 4. Delete from End
 * 5. Search
 * 6. Display
 * 7. Exit
 */

public class CircularLinkedList {

    // Node represents one element
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;
    static Node tail = null;

    // Insert at beginning
    static void insertBeginning(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }

        System.out.println(value + " inserted at beginning.");
    }

    // Insert at end
    static void insertEnd(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }

        System.out.println(value + " inserted at end.");
    }

    // Delete from beginning
    static void deleteBeginning() {

        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }

        System.out.println(head.data + " deleted from beginning.");

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
    }

    // Delete from end
    static void deleteEnd() {

        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }

        if (head == tail) {
            System.out.println(head.data + " deleted from end.");
            head = tail = null;
            return;
        }

        Node temp = head;

        // Find the node before tail
        while (temp.next != tail) {
            temp = temp.next;
        }

        System.out.println(tail.data + " deleted from end.");

        tail = temp;
        tail.next = head;
    }

    // Search an element
    static void search(int value) {

        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = head;
        int position = 0;

        do {

            if (temp.data == value) {
                System.out.println(
                    "Element found at position: " + position
                );
                return;
            }

            temp = temp.next;
            position++;

        } while (temp != head);

        System.out.println("Element not found.");
    }

    // Display circular linked list
    static void display() {

        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = head;

        System.out.println("Circular Linked List:");

        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println();
            System.out.println("==============================");
            System.out.println("    CIRCULAR LINKED LIST");
            System.out.println("==============================");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete from Beginning");
            System.out.println("4. Delete from End");
            System.out.println("5. Search");
            System.out.println("6. Display");
            System.out.println("7. Exit");
            System.out.println("==============================");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:
                System.out.print("Enter value: ");
                int beginningValue = sc.nextInt();
                insertBeginning(beginningValue);
                break;

            case 2:
                System.out.print("Enter value: ");
                int endValue = sc.nextInt();
                insertEnd(endValue);
                break;

            case 3:
                deleteBeginning();
                break;

            case 4:
                deleteEnd();
                break;

            case 5:
                System.out.print("Enter value to search: ");
                int searchValue = sc.nextInt();
                search(searchValue);
                break;

            case 6:
                display();
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