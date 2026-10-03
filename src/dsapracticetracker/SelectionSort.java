package dsapracticetracker;

import java.util.Scanner;

/*
 * Question:
 * Write a Java program to sort an array using Selection Sort.
 *
 * Example:
 * Input  : 50 20 40 10 30
 * Output : 10 20 30 40 50
 */

public class SelectionSort {

    // Selection Sort method
    static void sort(int[] arr) {

        // Find the smallest element in each pass
        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;

            // Search for the smallest element
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap smallest element with current element
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter array elements:");

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        sort(arr);

        System.out.println("Sorted array:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        sc.close();
    }
}