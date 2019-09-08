package com.bada.dsa.practice.interview;

import java.util.Random;

public class InterviewPuzzles {
	public static void main(String[] args) {
//		SortRandomGenerateNumbers();
//		printRightViewOfABinaryTree();
//		printLeftViewOfABinaryTree();
//		printRightViewOfABinaryTreeUsingQueue();
	}

	private static void printRightViewOfABinaryTreeUsingQueue() {
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryNode(10);
		tree.root.left = new BinaryNode(2);
		tree.root.right = new BinaryNode(3);
		tree.root.left.left = new BinaryNode(7);
		tree.root.left.right = new BinaryNode(8);
		tree.root.right.right = new BinaryNode(15);
		tree.root.right.left = new BinaryNode(12);
		tree.root.right.right.left = new BinaryNode(14);
		tree.printRightViewWithQueue();
	}

	/**
	 * Print Left View of a Binary Tree
	 */
	private static void printLeftViewOfABinaryTree() {
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryNode(1);
		tree.root.left = new BinaryNode(2);
		tree.root.right = new BinaryNode(3);
		tree.root.left.left = new BinaryNode(4);
		tree.root.left.right = new BinaryNode(5);
//		tree.root.left.right.left=new BinaryNode(50);
		tree.root.right.left = new BinaryNode(6);
		tree.root.right.right = new BinaryNode(7);
		tree.root.right.right.right = new BinaryNode(8);

		tree.treeView(0);
	}

	/**
	 * Print Right View of a Binary Tree
	 */
	private static void printRightViewOfABinaryTree() {
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryNode(1);
		tree.root.left = new BinaryNode(2);
		tree.root.right = new BinaryNode(3);
		tree.root.left.left = new BinaryNode(4);
		tree.root.left.right = new BinaryNode(5);
//		tree.root.left.right.left=new BinaryNode(50);
		tree.root.right.left = new BinaryNode(6);
		tree.root.right.right = new BinaryNode(7);
		tree.root.right.right.right = new BinaryNode(8);

		tree.treeView(1);
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
