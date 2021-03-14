package com.poly;

/**
 * This class represents Linked List for all variables of a term of polynomial.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-04
 */
public class VarList {
	VarNode head = null;
	int length = 0;

	/**
	 * This method adds a variable to the term as a new node of linked list.
	 * 
	 * @param varName Name of variable.
	 * @param power   Power of variable.
	 */
	public void addNewNode(char varName, int power) {
		VarNode newNode = new VarNode(varName, power);

		if (head == null) {
			head = newNode;
		} else {
			VarNode temp = head;

			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		length++;
	}

	/**
	 * This method displays the variables of a term represented by Linked List.
	 */
	public void printVarList() {
		if (head != null) {
			VarNode temp = head;

			while (temp != null) {
				System.out.print("(" + temp.varName + "^" + temp.power + ")");
				temp = temp.next;
			}
		}
	}
}
