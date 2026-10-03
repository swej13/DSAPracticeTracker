package dsapracticetracker;

import java.util.Scanner;

/*
 * Question:
 * Write a Java program to sort an array using Bubble Sort.
 *
 * Example:
 * Input  : 50 20 40 10 30
 * Output : 10 20 30 40 50
 */

public class BubbleSort {

    // Bubble Sort method
    static void sort(int[] arr) {

        // Compare adjacent elements
        for (int i = 0; i < arr.length - 1; i++) {

            // Each pass places the largest element
            // at the correct position
            for (int j = 0; j < arr.length - 1 - i; j++) {

                // Swap if elements are in wrong order
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
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