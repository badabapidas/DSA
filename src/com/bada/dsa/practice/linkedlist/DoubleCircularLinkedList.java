package com.bada.dsa.practice.linkedlist;

import com.bada.dsa.practice.node.DoubleNode;

public class DoubleCircularLinkedList {
	DoubleNode head, tail;
	int size;

	DoubleNode createDoubleLinkedList(int value) {
		head = new DoubleNode();

		DoubleNode node = new DoubleNode();
		node.setData(value);
		node.setNext(null);
		node.setPrev(null);
		head = node;
		tail = node;
		size = 1;
		return head;
	}

	void deleteNode(int location) {
		if (!isLinkListCreated()) {
			return;
		}
		System.out.println("Deleting node at location: " + location);
		if (location == 0) { // delete from the first
			if (size == 1) {
				head.setPrev(null);
				head.setNext(null);
				head = tail = null;
			} else {
				head = head.getNext();
				head.setPrev(head.getPrev());
				tail.setNext(head);
			}
			size--;
		} else if (location >= size) { // last node
			if (size == 1) {
				head.setPrev(null);
				head.setNext(null);
				head = tail = null;
			} else {
				tail = tail.getPrev();
				tail.setNext(head);
				head.setPrev(tail);
			}
			size--;
		} else {
			DoubleNode tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(tempNode.getNext().getNext());
			tempNode.getNext().setPrev(tempNode);
			size--;
		}
	}

	void printHeadUsingTail() {
		if (isLinkListCreated()) {
			System.out.println("\n\nPrinting Tail...");
			System.out.println(tail.getData());

			System.out.println("\nPrinting Head using Head reference...");
			System.out.println(head.getData());

			System.out.println("\nPrinting Head using Tail reference...");
			System.out.println(tail.getNext().getData());

		} else {
			System.out.println("Linked List does not exists");
		}
	}
	
	void printTailUsingHead() {
		if (isLinkListCreated()) {
			System.out.println("\n\nPrinting head...");
			System.out.println(head.getData());

			System.out.println("\nPrinting tail using tail reference...");
			System.out.println(tail.getData());

			System.out.println("\nPrinting tail using head reference...");
			System.out.println(head.getPrev().getData());

		} else {
			System.out.println("Linked List does not exists");
		}
	}

	void deleteLinkedList() {
		if (!isLinkListCreated())
			return;
		DoubleNode temp = head;
		for (int i = 0; i < size; i++) {
			temp.setPrev(null);
			temp = temp.getNext();
		}
		if (tail != null) {
			tail.setNext(null);
		}
		head = tail = null;
		System.out.println("Linked list deleted");
	}

	boolean searchNode(int value) {
		if (!isLinkListCreated()) {
			return false;
		}
		DoubleNode tempNode = head;
		for (int i = 0; i < size; i++) {
			if (tempNode.getData() == value) {
				System.out.println("value " + value + " found!");
				return true;
			}
			tempNode = tempNode.getNext();
		}
		System.out.println("value " + value + " not found!");
		return false;

	}

	void insert(int value, int location) {
		DoubleNode node = new DoubleNode();
		node.setData(value);

		if (!isLinkListCreated()) {
			return;
		}
		// first position
		if (location == 0) {
			node.setNext(head);
			node.setPrev(tail);
			head.setPrev(node);
			tail.setNext(node);
			head = node;
		} else if (location >= size) { // last position
			tail.setNext(node);
			node.setPrev(tail);
			node.setNext(head);
			head.setPrev(node);
			tail = node;

		} else { // any position

			DoubleNode temp = head;
			int index = 0;
			while (index < location - 1) {
				temp = temp.getNext();
				index++;
			}
			temp.setNext(node);
			node.setNext(temp.getNext());
			node.setPrev(temp);
			temp.getNext().setPrev(node);
		}
		size++;

	}

	void traverse() {
		if (!isLinkListCreated()) {
			return;
		}
		System.out.print("Double Linked list: ");
		DoubleNode tempNode = head;
		for (int i = 0; i < size; i++) {
			if (tempNode != null)
				System.out.print(tempNode.getData());
			if (i != size - 1) {
				System.out.print(" -> ");
			}
			tempNode = tempNode.getNext();
		}
		System.out.println();
	}

	void traverseReverse() {
		if (isLinkListCreated()) {
			System.out.print("Reverse Double Linked list: ");
			DoubleNode tempNode = tail;
			for (int i = 0; i < size; i++) {
				System.out.print(tempNode.getData());
				if (i != size - 1) {
					System.out.print(" <- ");
				}
				tempNode = tempNode.getPrev();
			}
		} else {
			System.out.println("Linked List does not exists");
		}
		System.out.println("\n");
	}

	private boolean isLinkListCreated() {
		return (head != null) ? true : false;
	}
}
