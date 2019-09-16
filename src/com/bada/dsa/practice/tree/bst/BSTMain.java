package com.bada.dsa.practice.tree.bst;

public class BSTMain {

	public static void main(String[] args) {
		BSTUsingLL tree = new BSTUsingLL();
		tree.insert(50);
		tree.insert(40);
		tree.insert(35);
		tree.insert(60);
		tree.insert(55);
		tree.insert(65);
//		tree.levelOrderTravarse();
//		tree.delete(20);
		tree.levelOrderTravarse();
		tree.printTreeGraphically();
	}

}
