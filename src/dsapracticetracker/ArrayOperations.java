package dsapracticetracker;

import java.util.Scanner;

/*
 * Question:
 * Write a menu-driven Java program to perform operations on an array.
 *
 * Operations:
 * 1. Display
 * 2. Insert
 * 3. Delete
 * 4. Search
 * 5. Update
 * 6. Exit
 */

public class ArrayOperations {

    static int[] arr;
    static int size = 0;

    // Display array elements
    static void display() {

        if (size == 0) {
            System.out.println("Array is Empty!");
            return;
        }

        System.out.println("Array elements:");

        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    // Insert element at a given position
    static void insert(int position, int value) {

        if (size == arr.length) {
            System.out.println("Array is Full!");
            return;
        }

        if (position < 0 || position > size) {
            System.out.println("Invalid position!");
            return;
        }

        // Shift elements to the right
        for (int i = size; i > position; i--) {
            arr[i] = arr[i - 1];
        }

        arr[position] = value;
        size++;

        System.out.println("Element inserted successfully.");
    }

    // Delete element from a given position
    static void delete(int position) {

        if (size == 0) {
            System.out.println("Array is Empty!");
            return;
        }

        if (position < 0 || position >= size) {
            System.out.println("Invalid position!");
            return;
        }

        // Shift elements to the left
        for (int i = position; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }

        size--;

        System.out.println("Element deleted successfully.");
    }

    // Search an element
    static void search(int value) {

        for (int i = 0; i < size; i++) {

            if (arr[i] == value) {
                System.out.println("Element found at index: " + i);
                return;
            }
        }

        System.out.println("Element not found.");
    }

    // Update element at a given position
    static void update(int position, int value) {

        if (position < 0 || position >= size) {
            System.out.println("Invalid position!");
            return;
        }

        arr[position] = value;

        System.out.println("Element updated successfully.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array capacity: ");
        int capacity = sc.nextInt();

        arr = new int[capacity];

        int choice;

        do {

            System.out.println();
            System.out.println("==============================");
            System.out.println("       ARRAY OPERATIONS");
            System.out.println("==============================");
            System.out.println("1. Display");
            System.out.println("2. Insert");
            System.out.println("3. Delete");
            System.out.println("4. Search");
            System.out.println("5. Update");
            System.out.println("6. Exit");
            System.out.println("==============================");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:
                display();
                break;

            case 2:
                System.out.print("Enter position (0-based): ");
                int insertPosition = sc.nextInt();

                System.out.print("Enter value: ");
                int insertValue = sc.nextInt();

                insert(insertPosition, insertValue);
                break;

            case 3:
                System.out.print("Enter position (0-based): ");
                int deletePosition = sc.nextInt();

                delete(deletePosition);
                break;

            case 4:
                System.out.print("Enter value to search: ");
                int searchValue = sc.nextInt();

                search(searchValue);
                break;

            case 5:
                System.out.print("Enter position (0-based): ");
                int updatePosition = sc.nextInt();

                System.out.print("Enter new value: ");
                int updateValue = sc.nextInt();

                update(updatePosition, updateValue);
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