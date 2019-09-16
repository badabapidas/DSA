package com.bada.dsa.practice.sorting;

public class SortingMain {
	public static void main(String[] args) {
//		Sorting sort = new BubbleSort();
//		Sorting sort = new SelectionSort();
//		Sorting sort = new InsertionSort();
		Sorting sort = new MergeSort();
		int arr[] = { 10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8 };
		long start = System.nanoTime();
//		sort(sort, arr);
		sort(sort, arr, 0, arr.length - 1);
		long end = System.nanoTime();
		System.out.println("\n\nTime to execute this algo: " + (end - start) + " nano secs");

	}

	public static void sort(Sorting sort, int arr[]) {
		System.out.print("Array to be sorted: ");
		sort.printArray(arr);
		sort.sort(arr);
		System.out.print("Sort: ");
		sort.printArray(arr);
	}

	public static void sort(Sorting sort, int arr[], int left, int right) {
		System.out.print("Array to be sorted: ");
		sort.printArray(arr);
		sort.sort(arr, left, right);
		System.out.print("Sort: ");
		sort.printArray(arr);
	}

}
