package com.bada.dsa.practice.linkedlist;

public class LinkedListMain {

	public static void main(String[] args) {

		SingleLisnkeListMain();
	}

	private static void SingleLisnkeListMain() {
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
