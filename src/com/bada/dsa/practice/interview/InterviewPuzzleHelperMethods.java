package com.bada.dsa.practice.interview;

import java.util.LinkedList;
import java.util.Queue;

public class InterviewPuzzleHelperMethods {

}

/**
 * Helper Classes
 * 
 * @author bada
 *
 */

class BinaryNode {
	int data;
	BinaryNode left, right;

	public BinaryNode(int value) {
		this.data = value;
		left = right = null;
	}
}

/**
 * The problem can also be solved using simple recursive traversal. We can keep
 * track of level of a node by passing a parameter to all recursive calls. The
 * idea is to keep track of maximum level also. And traverse the tree in a
 * manner that right/left subtree is visited before left/right subtree depending
 * on what view you want. Whenever we see a node whose level is more than
 * maximum level so far, we print the node because this is the last node in its
 * level (Note that we traverse the right subtree before left subtree for right
 * view and vice versa for left view).
 * 
 * @author bada
 *
 */
class BinaryTree {

	BinaryNode root;
	int maxLevel;
	static final int left_view = 0;
	static final int right_view = 1;

	void treeView(BinaryNode node, int level, int view) {
		if (node == null) {
			return;
		}

		if (maxLevel < level) {
			System.out.print(node.data + " ");
			maxLevel = level;
		}

		if (view == left_view) {
			treeView(node.left, level + 1, view);
			treeView(node.right, level + 1, view);
		} else if (view == right_view) {
			treeView(node.right, level + 1, view);
			treeView(node.left, level + 1, view);
		}

	}

	void treeView(int view) {
		String viewName = "right";
		if (view == 0) {
			viewName = "left";
		}

		System.out.print("Tree " + viewName + " View: ");
		treeView(root, view);
		System.out.println();
	}

	void treeView(BinaryNode node, int view) {
		treeView(node, 1, view);
	}

	/**
	 * If we observe carefully, we will see that our main task is to print the right
	 * most node of every level. So, we will do a level order traversal on the tree
	 * and print the rightmost node at every level.
	 * 
	 * @param root
	 */
	void printRightViewWithQueue() {
		if (root == null)
			return;

		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			// number of nodes at current level
			int n = queue.size();

			// Traverse all nodes of current level
			for (int i = 1; i <= n; i++) {
				BinaryNode temp = queue.poll();

				// Print the right most element at
				// the level
				if (i == n)
					System.out.print(temp.data + " ");

				// Add left node to queue
				if (temp.left != null)
					queue.add(temp.left);

				// Add right node to queue
				if (temp.right != null)
					queue.add(temp.right);
			}
		}
	}
}