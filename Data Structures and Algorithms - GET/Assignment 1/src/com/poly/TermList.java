package com.poly;

/**
 * This class represents Linked List for all terms of polynomial.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-04
 */
public class TermList {
	TermNode head = null;
	int length = 0;

	/**
	 * This method adds a new node to Linked List.
	 * 
	 * @param data Value to be added to Linked List.
	 * @return Node The reference of newly added Node.
	 */
	public TermNode addNewNode(int coefficient) {
		TermNode newNode = new TermNode(coefficient);

		if (head == null) {
			head = newNode;
		} else {
			TermNode temp = head;

			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		length++;
		return newNode;
	}

	/**
	 * This method displays the whole Polynomial represented using Linked List.
	 */
	public void printTermList() {
		if (head != null) {
			TermNode temp = head;

			while (temp != null) {
				if (temp.coefficient > 0 && temp != head) {
					System.out.print(" +" + temp.coefficient);
				} else {
					System.out.print(" " + temp.coefficient);
				}
				temp.varList.printVarList();
				temp = temp.next;
			}
		} else {
			System.out.println("\nNo polynomial present!");
		}
	}
}
