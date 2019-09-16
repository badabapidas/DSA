package com.bada.dsa.practice.sorting;

public class Sorting {
	void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	void sort(int arr[]) {

	}

	void sort(int[] arr, int left, int right) {

	}
}

/**
 * In Bubble sort we start outer loop to the no of elements and inner loo to
 * swap the elements if greater or smaller
 * 
 * @author bada
 *
 */
class BubbleSort extends Sorting {
	void sort(int arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}

/**
 * In selection sort we first find the minimum/maximum no from the given nos and
 * then star updating the arrays from first/last
 * 
 * @author bada
 *
 */
class SelectionSort extends Sorting {
	void sort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			// to find out the minimum index
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			// i is not minimum swap
			if (i != minIndex) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
	}
}

/**
 * In Insertion method we keep the first elm fixed and start from second element
 * and keep comparing with the left elements; keep swapping if the elm is
 * greater. at last copy the tmp element
 * 
 * @author bada
 *
 */
class InsertionSort extends Sorting {
	void sort(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int tmp = arr[i];
			int j = i;
			// loop through all the left element and keep swapping if greater
			while (j > 0 && arr[j - 1] > tmp) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = tmp;
		}
	}
}

/**
 * In Merge sort we follow divide and conquer; keep on dividing the nos in to
 * two parts till possible; then merge those; and during merging check and swap
 * the value if needed
 * 
 * @author bada
 *
 */
class MergeSort extends Sorting {
	void sort(int[] arr, int left, int right) {
		if (right > left) {
			int m = (left + right) / 2; // Find the middle point
			sort(arr, left, m); // Sort first halves
			sort(arr, m + 1, right); // Sort second halves
			merge(arr, left, m, right); // Merge the sorted halves
		}
	}

	private void merge(int[] A, int left, int middle, int right) {

		// Find sizes of two sub arrays to be merged
		int n1 = middle - left + 1;
		int n2 = right - middle;

		// Create temp arrays
		int[] L = new int[n1];
		int[] R = new int[n2];

		// Copy data to temp arrays
		for (int i = 0; i < n1; ++i)
			L[i] = A[left + i];
		for (int j = 0; j < n2; ++j)
			R[j] = A[middle + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged sub array
		int k = left;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				A[k] = L[i];
				i++;
			} else {
				A[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			A[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			A[k] = R[j];
			j++;
			k++;
		}
	}
}
