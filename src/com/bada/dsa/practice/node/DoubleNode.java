package com.bada.dsa.practice.node;

public class DoubleNode {
	private int data;
	DoubleNode next, prev;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public DoubleNode getNext() {
		return next;
	}

	public void setNext(DoubleNode next) {
		this.next = next;
	}

	public DoubleNode getPrev() {
		return prev;
	}

	public void setPrev(DoubleNode prev) {
		this.prev = prev;
	}

	@Override
	public String toString() {
		return data + "";
	}

}
