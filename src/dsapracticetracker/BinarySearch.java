package dsapracticetracker;

import java.util.Scanner;

/*
 * Question:
 * Write a Java program to search an element in a sorted array
 * using Binary Search.
 *
 * Example:
 * Array  : 10 20 30 40 50
 * Search : 40
 * Output : Element found at index 3
 */

public class BinarySearch {

    // Binary Search method
    static int search(int[] arr, int key) {

        int low = 0;
        int high = arr.length - 1;

        // Continue until search range becomes empty
        while (low <= high) {

            // Find middle element
            int mid = low + (high - low) / 2;

            // Element found
            if (arr[mid] == key) {
                return mid;
            }

            // Search in right half
            if (arr[mid] < key) {
                low = mid + 1;
            }

            // Search in left half
            else {
                high = mid - 1;
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

        System.out.println("Enter sorted array elements:");

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