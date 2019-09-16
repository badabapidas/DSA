package com.bada.dsa.sorting;

public class MergeSort {

	public static void mergeSort(int[] Array, int left, int right) {
		if (right > left) {
			int m = (left + right) / 2;
			System.out.println("left: " + left + ",m=" + m + ", right=" + right);
			mergeSort(Array, left, m);
			mergeSort(Array, m + 1, right);
			merge(Array, left, m, right);
		}
	}// end of method

	static void merge(int[] A, int left, int middle, int right) {
		int[] leftTmpArray = new int[middle - left + 2]; // Create tmp arrays
		int[] rightTmpArray = new int[right - middle + 1];

		for (int i = 0; i <= middle - left; i++) { // Copy values from Array 'A' to these tmp arrays
			leftTmpArray[i] = A[left + i];
			System.out.println("left entered at position " + i + " -" + leftTmpArray[i]);
		}
		for (int i = 0; i < right - middle; i++) {
			rightTmpArray[i] = A[middle + 1 + i];
			System.out.println("right entered at position " + i + " -" + rightTmpArray[i]);
		}

		leftTmpArray[middle - left + 1] = Integer.MAX_VALUE; // Merge values and insert into Array 'A'
		rightTmpArray[right - middle] = Integer.MAX_VALUE;
		int i = 0, j = 0;
		System.out.println("Swaping...");
		for (int k = left; k <= right; k++) {
			System.out.println("left elm:" + leftTmpArray[i]);
			System.out.println("right elm:" + rightTmpArray[j]);
			if (leftTmpArray[i] < rightTmpArray[j]) {
				A[k] = leftTmpArray[i];
				i++;
			} else {
				A[k] = rightTmpArray[j];
				j++;
			}
		}
	}// end of method

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
	}// end of method

}// end of class
