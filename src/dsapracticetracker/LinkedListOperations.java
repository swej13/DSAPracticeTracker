package dsapracticetracker;

import java.util.Scanner;

/*
 * Question:
 * Write a Java program to perform basic operations on a Linked List.
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

public class LinkedListOperations {

    // Node represents one element of the linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;

    // Insert at beginning
    static void insertBeginning(int value) {

        Node newNode = new Node(value);

        newNode.next = head;
        head = newNode;

        System.out.println(value + " inserted at beginning.");
    }

    // Insert at end
    static void insertEnd(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            System.out.println(value + " inserted at end.");
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        System.out.println(value + " inserted at end.");
    }

    // Delete from beginning
    static void deleteBeginning() {

        if (head == null) {
            System.out.println("Linked List is Empty!");
            return;
        }

        System.out.println(head.data + " deleted from beginning.");

        head = head.next;
    }

    // Delete from end
    static void deleteEnd() {

        if (head == null) {
            System.out.println("Linked List is Empty!");
            return;
        }

        // Only one node
        if (head.next == null) {
            System.out.println(head.data + " deleted from end.");
            head = null;
            return;
        }

        Node temp = head;

        // Move to second-last node
        while (temp.next.next != null) {
            temp = temp.next;
        }

        System.out.println(temp.next.data + " deleted from end.");

        temp.next = null;
    }

    // Search an element
    static void search(int value) {

        Node temp = head;
        int position = 0;

        while (temp != null) {

            if (temp.data == value) {
                System.out.println(
                    "Element found at position: " + position
                );
                return;
            }

            temp = temp.next;
            position++;
        }

        System.out.println("Element not found.");
    }

    // Display linked list
    static void display() {

        if (head == null) {
            System.out.println("Linked List is Empty!");
            return;
        }

        Node temp = head;

        System.out.println("Linked List:");

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println();
            System.out.println("==============================");
            System.out.println("    LINKED LIST OPERATIONS");
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