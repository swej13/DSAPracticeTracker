package dsapracticetracker;

import java.util.Scanner;

/*
 * Question:
 * Write a Java program to implement a Doubly Linked List.
 *
 * Operations:
 * 1. Insert at Beginning
 * 2. Insert at End
 * 3. Delete from Beginning
 * 4. Delete from End
 * 5. Display Forward
 * 6. Display Backward
 * 7. Search
 * 8. Exit
 */

public class DoublyLinkedList {

    // Node contains data, previous link and next link
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
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
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        System.out.println(value + " inserted at beginning.");
    }

    // Insert at end
    static void insertEnd(int value) {

        Node newNode = new Node(value);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
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
            head.prev = null;
        }
    }

    // Delete from end
    static void deleteEnd() {

        if (tail == null) {
            System.out.println("List is Empty!");
            return;
        }

        System.out.println(tail.data + " deleted from end.");

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Display from head to tail
    static void displayForward() {

        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = head;

        System.out.println("Forward:");

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    // Display from tail to head
    static void displayBackward() {

        if (tail == null) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = tail;

        System.out.println("Backward:");

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }

        System.out.println("NULL");
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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println();
            System.out.println("==============================");
            System.out.println("    DOUBLY LINKED LIST");
            System.out.println("==============================");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete from Beginning");
            System.out.println("4. Delete from End");
            System.out.println("5. Display Forward");
            System.out.println("6. Display Backward");
            System.out.println("7. Search");
            System.out.println("8. Exit");
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
                displayForward();
                break;

            case 6:
                displayBackward();
                break;

            case 7:
                System.out.print("Enter value to search: ");
                int searchValue = sc.nextInt();
                search(searchValue);
                break;

            case 8:
                System.out.println("Program ended.");
                break;

            default:
                System.out.println("Invalid choice!");
            }

        } while (choice != 8);

        sc.close();
    }
}