package com.bada.dsa.practice.tree.binary;

public class BinaryTreeMain {

	public static void main(String[] args) {

//		binaryTreeUsingArrayMain();
		binaryTreeUsingLinkedList();
	}

	private static void binaryTreeUsingLinkedList() {
		BinaryTreeByLinkedList list= new BinaryTreeByLinkedList();
		list.insert(10);
		list.insert(20);
		list.insert(30);
	}

	private static void binaryTreeUsingArrayMain() {
		BinaryTreeByArray tree = new BinaryTreeByArray(10);
		for (int i = 1; i <= 10; i++) {
			tree.insert(i * 10);
		}
		System.out.println("\nlevel order traversing..");
		tree.levelOrder();
		System.out.println("\n\npre order traversing..");
		tree.preOrder(1);
		System.out.println("\n\npost order traversing..");
		tree.postOrder(1);
		System.out.println("\n\nin order traversing..");
		tree.inOrder(1);

		tree.search(500);
		tree.search(50);

		tree.delete(10);

		System.out.println("\nlevel order traversing..");
		tree.levelOrder();
		System.out.println("\n\npre order traversing..");
		tree.preOrder(1);
		System.out.println("\n\npost order traversing..");
		tree.postOrder(1);
		System.out.println("\n\nin order traversing..");
		tree.inOrder(1);

		tree.deleteTree();
	}
}
