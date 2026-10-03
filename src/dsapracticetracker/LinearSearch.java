package dsapracticetracker;

import java.util.Scanner;

/*
 * Question:
 * Write a Java program to search an element in an array
 * using Linear Search.
 *
 * Example:
 * Array  : 10 20 30 40 50
 * Search : 30
 * Output : Element found at index 2
 */

public class LinearSearch {

    // Linear Search method
    static int search(int[] arr, int key) {

        // Check each element one by one
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == key) {
                return i;
            }
        }

        // Element not found
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        // Input array elements
        System.out.println("Enter array elements:");

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int result = search(arr, key);

        if (result == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println(
                    "Element found at index: " + result);
        }

        sc.close();
    }
}