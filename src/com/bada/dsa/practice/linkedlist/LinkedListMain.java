package com.bada.dsa.practice.linkedlist;

public class LinkedListMain {

	public static void main(String[] args) {

//		singleLinkedListMain();
		doubleLinkedListMain();
	}

	private static void doubleLinkedListMain() {
//		DoubleLinkedList list = new DoubleLinkedList();
		DoubleCircularLinkedList list = new DoubleCircularLinkedList();
		list.createDoubleLinkedList(10);
		list.insert(20, 1);
		list.insert(30, 2);
		list.insert(40, 3);
		list.insert(50, 4);
		list.insert(60, 5);
		list.traverse();
		list.traverseReverse();
		list.searchNode(40);
		list.searchNode(400);

		list.traverse();
		list.printHeadUsingTail();
		
		list.printTailUsingHead();

		list.deleteNode(1);
		list.traverse();
		list.searchNode(20);

		list.deleteNode(6);
		list.traverse();
		list.traverseReverse();

		list.deleteLinkedList();

	}

	private static void singleLinkedListMain() {
		SingleLinkedList list = new SingleLinkedList();
//		SingleCircularLinkedList list = new SingleCircularLinkedList();

		list.createLinkList(10);
		list.insert(20, 1);
		list.insert(30, 2);
		list.insert(40, 3);
		list.traverse();

		list.insert(5, 0);
		list.insert(50, 10);
		list.traverse();

		list.insert(45, 3);
		list.traverse();

		list.searchNode(100);
		list.searchNode(30);

		list.deletionOfNode(3);
		list.traverse();
		list.deletionOfNode(0);
		list.traverse();
		list.deletionOfNode(30);
		list.traverse();

		list.deleteLinkedList();
	}

}
