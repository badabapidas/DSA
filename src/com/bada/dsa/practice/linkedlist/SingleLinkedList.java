package com.bada.dsa.practice.linkedlist;

import com.bada.dsa.practice.node.SingleNode;

public class SingleLinkedList {

	private SingleNode head;
	private SingleNode tail;
	private int size;

	void deletionOfNode(int location) {
		if (!isLinkListCreated()) {
			return;
		}
		// if we want to delete the first node
		if (location == 0) {
			head = head.getNext();
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
			temp.setNext(null);
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
		} else if (location >= size) { // last
			node.setNext(null);
			tail.setNext(node);
			tail = node;
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

	private boolean isLinkListCreated() {
		return (head != null) ? true : false;
	}

	void deleteLinkedList() {
		head = null;
		tail = null;
		size = 0;
		System.out.println("Linked List Deleted");
	}
}
