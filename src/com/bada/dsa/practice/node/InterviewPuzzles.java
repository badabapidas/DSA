package com.bada.dsa.practice.node;

import java.util.Random;

public class InterviewPuzzles {
	public static void main(String[] args) {
		SortRandomGenerateNumbers();
	}

	/**
	 * Sort a random generate no of (-1, 0, 1) of length 10
	 */
	private static void SortRandomGenerateNumbers() {
		Random randome = new Random();
		int[] sortedArray = new int[10];
		int n_pointer = 0, p_pointer = 0, arr_lenght = 10;

		for (int i = 0; i < arr_lenght; i++) {
			int value = randome.nextInt(1 + 2) - 1;
			System.out.println("value generated:" + value);
			if (value < 0) {
				sortedArray[n_pointer++] = value;

			} else if (value > 0) {
				sortedArray[arr_lenght - ++p_pointer] = value;
			}
		}
		System.out.print("Output: ");
		for (int i = 0; i < sortedArray.length; i++) {
			int element = sortedArray[i];
			System.out.print(element);
			if (i != sortedArray.length - 1) {
				System.out.print(" -> ");
			}
		}

	}
}
