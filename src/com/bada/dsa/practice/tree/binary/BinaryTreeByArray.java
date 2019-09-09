package com.bada.dsa.practice.tree.binary;

public class BinaryTreeByArray {
	int[] arr;
	int lastUsedIndex;

	public BinaryTreeByArray(int size) {
		arr = new int[size + 1];
		this.lastUsedIndex = 0;
		System.out.println("Blank Tree of size " + size + " has been created !\n");
	}

	boolean isTreeFull() {
		if (lastUsedIndex == arr.length-1) {
			System.out.println("Tree is full");
			return true;
		}
		return false;
	}

	boolean isTreeEmpty() {
		if (lastUsedIndex == 0) {
			System.out.println("Tree is empty");
			return true;
		}
		return false;
	}

	void insert(int value) {
		if (isTreeFull()) {
			return;
		}
		this.arr[lastUsedIndex + 1] = value;
		lastUsedIndex++;
		System.out.println("Value " + value + " is inserted in the tree");
	}

	void levelOrder() {
		if (!isTreeEmpty()) {
			for (int i = 1; i <= lastUsedIndex; i++) {
				System.out.print(arr[i] + " ");
			}
		}
	}

	void preOrder(int index) {
		if (!isTreeEmpty()) {
			if (index > lastUsedIndex || index < 0)
				return;
			System.out.print(arr[index] + " ");
			preOrder(index * 2);
			preOrder(index * 2 + 1);
		}
	}

	void postOrder(int index) {
		if (!isTreeEmpty()) {
			if (index > lastUsedIndex || index < 0)
				return;
			postOrder(index * 2);
			postOrder(index * 2 + 1);
			System.out.print(arr[index] + " ");
		}
	}

	void inOrder(int index) {
		if (!isTreeEmpty()) {
			if (index > lastUsedIndex || index < 0)
				return;
			inOrder(index * 2);
			System.out.print(arr[index] + " ");
			inOrder(index * 2 + 1);
		}
	}

	int search(int value) {
		if (isTreeEmpty()) {
			return -1;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				System.out.println("\nvalue " + value + " found! in location " + i);
				return i;
			}
		}
		System.out.println("\nvalue " + value + " not found!");
		return -1;
	}

	void delete(int value) {
		int searchIndex = search(value);
		if (searchIndex >= 0) {
			arr[searchIndex] = arr[lastUsedIndex];
			lastUsedIndex--;
			System.out.println("\nvalue " + value + " deleted!");
		}
	}

	void deleteTree() {
		try {
			arr = null;
			System.out.println("\nTree has been deleted successfully !");
		} catch (Exception e) {
			System.out.println("There was an error deleting the tree.");
		}
	}
}
