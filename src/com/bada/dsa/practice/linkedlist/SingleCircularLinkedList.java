package com.bada.dsa.practice.linkedlist;

import com.bada.dsa.practice.node.SingleNode;

public class SingleCircularLinkedList {

	private SingleNode head;
	private SingleNode tail;
	private int size;

	SingleNode createLinkList(int value) {
		head = new SingleNode();
		SingleNode node = new SingleNode();
		node.setValue(value);
		node.setNext(null);
		head = node;
		tail = node;
		size = 1;
		return head;
	}

	void printHeadUsingTail() {
		if (isLinkListCreated()) {
			System.out.println("Printing Tail...");
			System.out.println(tail.getValue());

			System.out.println("Printing Head using Head reference...");
			System.out.println(head.getValue());

			System.out.println("Printing Head using Tail reference...");
			System.out.println(tail.getNext().getValue());

		} else {
			System.out.println("Linked List does not exists");
		}
	}

	void traverse() {
		if (!isLinkListCreated()) {
			return;
		}
		System.out.print("Linked list: ");
		SingleNode tempNode = head;
		for (int i = 0; i < size; i++) {
			System.out.print(tempNode.getValue());
			if (i != size - 1) {
				System.out.print(" -> ");
			}
			tempNode = tempNode.getNext();
		}
		System.out.println();
	}

	void insert(int value, int location) {
		SingleNode node = new SingleNode();
		node.setValue(value);

		if (!isLinkListCreated()) {
			return;
		}
		// we are trying to enter at first position
		if (location == 0) {
			node.setNext(head);
			head = node;
			tail.setNext(node);
		} else if (location >= size) { // last
			tail.setNext(node);
			tail = node; // to keep track of last node
			tail.setNext(head); // update tail to circularly point head
		} else {
			// while inserting in a specific location

			SingleNode tempNode = head;
			int index = 0;
			while (index < location - 1) {
				tempNode = tempNode.getNext();
				index++;
			}
			SingleNode nextNode = tempNode.getNext();
			tempNode.setNext(node);
			node.setNext(nextNode);
		}
		size++;
	}

	private boolean isLinkListCreated() {
		return (head != null) ? true : false;
	}

	void deleteLinkedList() {
		if (tail != null) {
			tail.setNext(null);
		}
		head = tail = null;
		System.out.println("Linked List deleted successfully !");
	}

	boolean searchNode(int value) {
		if (!isLinkListCreated()) {
			return false;
		}
		SingleNode tempNode = head;
		for (int i = 0; i < size; i++) {
			if (tempNode.getValue() == value) {
				System.out.println("value " + value + " found!");
				return true;
			}
			tempNode = tempNode.getNext();
		}
		System.out.println("value " + value + " not found!");
		return false;

	}

	void deletionOfNode(int location) {
		if (!isLinkListCreated()) {
			return;
		}
		// if we want to delete the first node
		if (location == 0) {
			head = head.getNext();
			tail.setNext(head);
			size--;
			if (size == 0) {
				tail = null;
			}
		} else if (location > size) { // delete the last node
			SingleNode temp = head;
			for (int i = 0; i < size - 1; i++) {
				temp = temp.getNext();
			}
			// if there is only one element
			if (temp == head) {
				head = tail = null;
				size--;
				return;
			}
			temp.setNext(head);
			tail = temp;
			size--;
		} else {
			// if any inside node is to be deleted
			SingleNode temp = head;
			for (int i = 0; i < location - 1; i++) {
				temp = temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
			size--;
		}
	}
}
