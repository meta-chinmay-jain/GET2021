package com.list;

/**
 * This class defines methods to create, display and rotate a Linked List.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-04
 */
public class LinkedList {
	private Node head = null;
	private int length = 0;

	/**
	 * This class is used to define the structure of a single Node of Linked List.
	 */
	public class Node {
		private Node next;
		private int data;

		public Node(int data) {
			this.data = data;
			this.setNext(null);
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

	/**
	 * This method adds a new node to Linked List.
	 * 
	 * @param data Value to be added to Linked List.
	 */
	public void addNewNode(int data) {
		Node newNode = new Node(data);

		if (getHead() == null) {
			head = newNode;
		} else {
			Node temp = getHead();

			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(newNode);
		}
		length++;
	}

	/**
	 * This method displays the whole Linked List.
	 */
	public void printLinkedList() {
		if (getHead() != null) {
			Node temp = getHead();

			while (temp.getNext() != null) {
				System.out.print(temp.data + " -> ");
				temp = temp.getNext();
			}
			System.out.println(temp.data);
		} else {
			System.out.println("\nList is empty!");
		}
	}

	/**
	 * This method rotates the sub-list to clockwise direction.<br>
	 * Algorithm:<br>
	 * - move ptr1 to just before leftPos<br>
	 * - move ptr2 to (sub-list length - no of shifts)<br>
	 * - move ptr3 to end of sub-list<br>
	 * - change pointers to get the final output.
	 * 
	 * @param leftPos    Start Position of Sub-List from List.
	 * @param rightPos   End Position of Sub-List from List.
	 * @param noOfShifts Number of shifts to be performed.
	 * @return boolean True if rotation successful, false otherwise.
	 */
	public boolean rotateSubList(int leftPos, int rightPos, int noOfShifts) {
		if (leftPos < 1 || leftPos > rightPos || rightPos > length || rightPos < leftPos) {
			return false;
		}

		int subListLength = rightPos - leftPos + 1;
		noOfShifts = noOfShifts % subListLength;
		if (noOfShifts == 0) {
			return true;
		}

		Node temp = getHead(), ptr1 = null, ptr2, ptr3;

		int pos = 1;
		while (pos < leftPos) {
			ptr1 = temp;
			temp = temp.getNext();
			pos++;
		}

		pos = 1;
		while (pos < subListLength - noOfShifts) {
			temp = temp.getNext();
			pos++;
		}
		ptr2 = temp;

		pos = 1;
		while (pos <= noOfShifts) {
			temp = temp.getNext();
			pos++;
		}
		ptr3 = temp;

		// ptr1 == null when leftPos == 1
		if (ptr1 != null) {
			temp = ptr1.getNext();
			ptr1.setNext(ptr2.getNext());
		} else {
			temp = getHead();
			head = ptr2.getNext();
		}
		ptr2.setNext(ptr3.getNext());
		ptr3.setNext(temp);

		return true;
	}

	/**
	 * This method detects if there is a loop in the Linked List.
	 * 
	 * @return boolean True if loop detected, false otherwise.
	 */
	public boolean detectLoop() {
		Node slow_ptr = getHead();
		Node fast_ptr = getHead();

		while (slow_ptr != null && fast_ptr != null && fast_ptr.getNext() != null) {
			slow_ptr = slow_ptr.getNext();
			fast_ptr = fast_ptr.getNext().getNext();
			if (slow_ptr == fast_ptr) {
				return true;
			}
		}
		return false;
	}

	public Node getHead() {
		return head;
	}
}
