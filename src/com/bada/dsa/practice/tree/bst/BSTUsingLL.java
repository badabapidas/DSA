package com.bada.dsa.practice.tree.bst;

import java.util.LinkedList;
import java.util.Queue;

import com.bada.dsa.practice.node.BinaryNode;

public class BSTUsingLL {
	BinaryNode root;

	public BinaryNode getRoot() {
		return root;
	}

	public BSTUsingLL() {
		root = null;
	}

	void insert(int value) {
		root = insert(root, value);
	}

	BinaryNode insert(BinaryNode currentNode, int value) {
		if (currentNode == null) {
			return createNode(value);
		} else if (value <= currentNode.getValue()) {
			currentNode.setLeft(insert(currentNode.getLeft(), value));
			return currentNode;
		} else {
			currentNode.setRight(insert(currentNode.getRight(), value));
			return currentNode;
		}
	}

	BinaryNode createNode(int value) {
		BinaryNode node = new BinaryNode();
		node.setValue(value);
		return node;
	}

	void levelOrderTravarse() {
		System.out.println("Level Order Traversal:");
		if (root == null) {
			System.out.println("No tree exist");
			return;
		}
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode currentNode = queue.remove();
			System.out.print(currentNode.getValue()+" ");

			if (currentNode.getLeft() != null) {
				queue.add(currentNode.getLeft());
			}
			if (currentNode.getRight() != null) {
				queue.add(currentNode.getRight());
			}
		}
	}

	void delete(int value) {
		delete(root, value);
	}

	public static BinaryNode minimumElement(BinaryNode root) {
		if (root.getLeft() == null)
			return root;
		else {
			return minimumElement(root.getLeft());
		}
	}

	private BinaryNode delete(BinaryNode root, int value) {
		if (root == null) {
			System.out.println("Tree is empty already");
			return null;
		}
		// if the node to be deleted is less then root
		if (value < root.getValue()) {
			root.setLeft(delete(root.getLeft(), value));
		} else if (value > root.getValue()) {
			// if the node to be deleted is more then root
			root.setRight(delete(root.getRight(), value));
		} else {
			// if the node to be deleted is the current node
			root = actualDeletion(root);
		}
		return root;
	}

	private BinaryNode actualDeletion(BinaryNode root) {
		// case 1: if nodeToBeDeleted have both children
		if (root.getLeft() != null && root.getRight() != null) {
			// store the current element
			BinaryNode temp = root;
			// Finding minimum element from right subtree
			BinaryNode minNodeForRight = minimumElement(temp.getRight());
			// Replacing current node with minimum node from right subtree
			root.setValue(minNodeForRight.getValue());
			// Deleting minimum node from right now
			root.setRight(delete(root.getRight(), minNodeForRight.getValue()));

		} else if (root.getLeft() != null) {// case 2:if nodeToBeDeleted has only left child
			root = root.getLeft();
		} else if (root.getRight() != null) {// case 3:if nodeToBeDeleted has only right child
			root = root.getRight();
		} else // case 4: if nodeToBeDeleted do not have child (Leaf node)
			root = null;
		return root;
	}

	void searchForValue(int value) {
		searchForValue(root, value);
	}

	// Search a node in BST
	BinaryNode searchForValue(BinaryNode node, int value) {
		if (node == null) {
			System.out.println("Value: " + value + " not found in BST.");
			return null;
		} else if (node.getValue() == value) {
			System.out.println("Value: " + value + " found in BST.");
			return node;
		} else if (value < node.getValue()) {
			return searchForValue(node.getLeft(), value);
		} else {
			return searchForValue(node.getRight(), value);
		}
	}

	public void deleteTree() {
		System.out.println("Deleting entire Tree...");
		root = null;
		System.out.println("Tree deleted successfully !");
	}

	void printTreeGraphically() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		Queue<Integer> level = new LinkedList<Integer>();

		int CurrentLevel = 1;
		boolean previousLevelWasAllNull = false;
		queue.add(root);
		level.add(1);

		System.out.println("\nPrinting Level order traversal of Tree...");
		if (root == null) {
			System.out.println("Tree does not exists !");
			return;
		}

		while (!queue.isEmpty()) {
			if (CurrentLevel == level.peek()) { // if we are in the same level
				if (queue.peek() == null) {
					queue.add(null);
					level.add(CurrentLevel + 1);
				} else {
					queue.add(queue.peek().getLeft());
					level.add(CurrentLevel + 1);
					queue.add(queue.peek().getRight());
					level.add(CurrentLevel + 1);
					previousLevelWasAllNull = false;
				}
				System.out.print(queue.remove() + "  ");
				level.remove();
			} else { // level has changed
				System.out.println("\n");
				CurrentLevel++;
				if (previousLevelWasAllNull == true) {
					break;
				}
				previousLevelWasAllNull = true;
			}
		} // end of loop
	}
}
