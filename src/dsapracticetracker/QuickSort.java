package dsapracticetracker;

import java.util.Scanner;

/*
 * Question:
 * Write a Java program to sort an array using Quick Sort.
 *
 * Example:
 * Input  : 50 20 40 10 30
 * Output : 10 20 30 40 50
 */

public class QuickSort {

    // Partition the array
    static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        // Put smaller elements before pivot
        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Put pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Quick Sort method
    static void sort(int[] arr, int low, int high) {

        if (low < high) {

            int pivotIndex = partition(arr, low, high);

            // Sort left part
            sort(arr, low, pivotIndex - 1);

            // Sort right part
            sort(arr, pivotIndex + 1, high);
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

        sort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        sc.close();
    }
}