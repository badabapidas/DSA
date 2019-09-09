package com.bada.dsa.practice.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

import com.bada.dsa.practice.node.BinaryNode;

public class BinaryTreeByLinkedList {
	BinaryNode root;

	public BinaryTreeByLinkedList() {
		this.root = null;
	}

	void insert(int value) {
		BinaryNode node = new BinaryNode();
		node.setValue(value);

		// if the root is null enter the node in the root
		if (root == null) {
			root = node;
			System.out.println("Successfully inserted new node at Root !");
			return;
		}

		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			BinaryNode currentNode = queue.remove();
			if (currentNode.getLeft() == null) {
				currentNode.setLeft(node);
				System.out.println("Successfully inserted " + node.getValue() + " left of parent node "
						+ currentNode.getValue() + "!");
				break;
			} else if (currentNode.getRight() == null) {
				currentNode.setRight(node);
				System.out.println("Successfully inserted " + node.getValue() + " right of parent node "
						+ currentNode.getValue() + "!");
				break;
			} else {
				queue.add(currentNode.getLeft());
				queue.add(currentNode.getRight());
			}
		}
	}
}
