package org.example;

public class MergeSort {

    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, temp, left, mid); // Sort left half
            mergeSort(arr, temp, mid + 1, right); // Sort right half
            merge(arr, temp, left, mid, right); // Merge both halves
        }
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // Copy both halves into the temporary array
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left; // Initial index of left subarray
        int j = mid + 1; // Initial index of right subarray
        int k = left; // Initial index of merged subarray

        // Merge the temporary arrays back into the original array
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        // Copy the remaining elements of left subarray (if any)
        while (i <= mid) {
            arr[k++] = temp[i++];
        }

        // Copy the remaining elements of right subarray (if any)
        while (j <= right) {
            arr[k++] = temp[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        mergeSort(arr);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
