package com.bada.dsa.practice.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

import com.bada.dsa.practice.node.BinaryNode;

public class BinaryTreeByLinkedList {
	BinaryNode root;

	public BinaryTreeByLinkedList() {
		this.root = null;
	}

	void delete(int value) {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			// if node is found then copy deepest node here and delete deepest node.
			if (presentNode.getValue() == value) {
				presentNode.setValue(getDeepestNode().getValue());
				DeleteDeepestNode();
				System.out.println("Deleted the node !!");
				return;
			} else {
				if (presentNode.getLeft() != null)
					queue.add(presentNode.getLeft());
				if (presentNode.getRight() != null)
					queue.add(presentNode.getRight());
			}
		} // end of while loop
		System.out.println("Did not find the node!!");
	}

	public void DeleteDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode previousNode, presentNode = null;
		while (!queue.isEmpty()) {
			previousNode = presentNode;
			presentNode = queue.remove();

//			System.out.println("presentNode: " + presentNode.getValue());
			if (previousNode != null) {
//				System.out.println("previousNode: " + previousNode.getValue());
			}
			if (presentNode.getLeft() == null) {
//				System.out.println("present node left is null");
				previousNode.setRight(null);
				return;
			} else if ((presentNode.getRight() == null)) {
//				System.out.println("present node right is null");
				presentNode.setLeft(null);
				return;
			}
			queue.add(presentNode.getLeft());
			queue.add(presentNode.getRight());
		} // end of while loop
	}

	public BinaryNode getDeepestNode() {
		// make an empty queue. Queue is Interface and LinkedList is class
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode presentNode = null;
		while (!queue.isEmpty()) {
			presentNode = queue.remove();
			if (presentNode.getLeft() != null)
				queue.add(presentNode.getLeft());
			if (presentNode.getRight() != null)
				queue.add(presentNode.getRight());
		}
		System.out.println("Depest: " + presentNode.getValue());
		return presentNode;
	}

	void search(int value) {
		if (root == null) {
			return;
		}

		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			BinaryNode currentNode = queue.remove();
			if (currentNode.getValue() == value) {
				System.out.println(value + " found ");
				return;
			}
			if (currentNode.getLeft() != null) {
				queue.add(currentNode.getLeft());
			}
			if (currentNode.getRight() != null) {
				queue.add(currentNode.getRight());
			}
		}
		System.out.println(value + " not found ");

	}

	void insert(int value) {
		BinaryNode node = new BinaryNode();
		node.setValue(value);

		// if the root is null enter the node in the root
		if (root == null) {
			root = node;
			System.out.println(node.getValue());
			return;
		}

		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			BinaryNode currentNode = queue.remove();
			if (currentNode.getLeft() == null) {
				currentNode.setLeft(node);
				System.out.println(node.getValue() + " <- " + currentNode.getValue());
//				System.out.println("Successfully inserted " + node.getValue() + " left of parent node "
//						+ currentNode.getValue() + "!");
				break;
			} else if (currentNode.getRight() == null) {
				currentNode.setRight(node);
				System.out.println(currentNode.getValue() + " -> " + node.getValue());
//				System.out.println("Successfully inserted " + node.getValue() + " right of parent node "
//						+ currentNode.getValue() + "!");
				break;
			} else {
				queue.add(currentNode.getLeft());
				queue.add(currentNode.getRight());
			}
		}
	}

	void preOrder(BinaryNode node) {
		if (node == null)
			return;
		System.out.print(node.getValue() + " ");
		preOrder(node.getLeft());
		preOrder(node.getRight());
	}// end of method

	// post-order traversal of binary tree
	void postOrder(BinaryNode node) {
		if (node == null)
			return;
		postOrder(node.getLeft());
		postOrder(node.getRight());
		System.out.print(node.getValue() + " ");
	}// end of method

	// in-order traversal of binary tree
	void inOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.getLeft());
		System.out.print(node.getValue() + " ");
		inOrder(node.getRight());
	}// end of method

	void levelOrder() {
		// make a queue for level order. Queue is Interface and LinkedList is class
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			System.out.print(presentNode.getValue() + " ");
			if (presentNode.getLeft() != null) {
				queue.add(presentNode.getLeft());
			}
			if (presentNode.getRight() != null)
				queue.add(presentNode.getRight());
		}
	}// end of method

	// Delete Tree
	void deleteTree() {
		root = null;
		System.out.println("Binary Tree has been deleted successfully");
	}
}
