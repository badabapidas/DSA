package com.bada.dsa.tree.bst;

public class BinarySearchTreeByLinkedListMain {

	public static void main(String[] args) {
		
		//Constructor
		BinarySearchTreeByLinkedList tree = new BinarySearchTreeByLinkedList();
		
		//Inserting values in BST
		System.out.println("Inserting 10 nodes in Tree");
		tree.insert(10);
		tree.insert(20);
		tree.insert(30);
		tree.insert(25);
		
		
		
		tree.printTreeGraphically();
		
		//Searching non-existing value in Tree
		System.out.println("\n\nSearching for value on BST...");
		tree.searchForValue(80);
		
		//Searching existing value in Tree
		System.out.println("\nSearching for value on BST...");
		tree.searchForValue(60);

		
		//Deleting Node from Tree
		tree.deleteNodeOfBST(80); //Node does not exists
		tree.printTreeGraphically();
		
		/*tree.deleteNodeOfBST(57); //Node is having 0 Child
		tree.printTreeGraphically();
		
		tree.deleteNodeOfBST(60); //Node is having 1 Child
		tree.printTreeGraphically();
		
		tree.deleteNodeOfBST(50); //Node is having 2 Child
		tree.printTreeGraphically();

		//Deleting entire Tree
		tree.deleteTree();
		
		//Traversing Tree
		tree.levelOrderTraversal();
*/
	}//end of method

}//end of class