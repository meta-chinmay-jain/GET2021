package com.ques2;

/**
 * This class defines methods to create, display and sort a Linked List.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-09
 */
public class LinkedList {
	private Node head = null;

	/**
	 * This class is used to define the structure of a single Node of Linked List.
	 */
	public static class Node {
		String empId;
		double salary;
		int age;
		Node next;

		public Node(String empId, double salary, int age) {
			this.empId = empId;
			this.salary = salary;
			this.age = age;
			this.next = null;
		}
	}

	/**
	 * This method adds a new node to Linked List.
	 * 
	 * @param salary Salary of Employee.
	 * @param empId  Unique ID of Employee.
	 * @param age    Age of Employee.
	 */
	public void addNewNode(String empId, double salary, int age) {
		Node newNode = new Node(empId, salary, age);

		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;

			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	/**
	 * This method displays the whole Linked List.
	 */
	public void printLinkedList() {
		if (head != null) {
			Node temp = head;

			while (temp != null) {
				System.out.println("(" + temp.empId + ", " + temp.salary + ", " + temp.age + ")");
				temp = temp.next;
			}
		} else {
			System.out.println("\nList is empty!");
		}
	}

	/**
	 * This method used merge sort algorithm to sort the linked list in descending
	 * order.
	 * 
	 * @param h Head node.
	 * @return Node Reference to the head of sorted list.
	 */
	public Node mergeSort(Node h) {
		if (null == h || null == h.next) {
			return h;
		}

		Node middle = getMiddleNode(h);
		Node nextOfMiddle = middle.next;
		middle.next = null;

		Node left = mergeSort(h);
		Node right = mergeSort(nextOfMiddle);

		Node sortedList = sortedMerge(left, right);

		return sortedList;
	}

	/**
	 * This method merges the left and right parts of a linked list while sorting
	 * them.
	 * 
	 * @param left  Head of left part of linked list.
	 * @param right Head of right part of linked list.
	 * @return Node Sorted merge of two parts.
	 */
	private static Node sortedMerge(Node left, Node right) {
		Node result = null;

		if (null == left) {
			return right;
		}
		if (null == right) {
			return left;
		}

		if (left.salary > right.salary) {
			result = left;
			result.next = sortedMerge(left.next, right);
		} else if (left.salary < right.salary) {
			result = right;
			result.next = sortedMerge(left, right.next);
		} else {
			if (left.age < right.age) {
				result = left;
				result.next = sortedMerge(left.next, right);
			} else {
				result = right;
				result.next = sortedMerge(left, right.next);
			}
		}

		return result;
	}

	/**
	 * This is a utility method to get the middle of the linked list.
	 * 
	 * @param h Head of linked list.
	 * @return Node Middle node of the linked list.
	 */
	private static Node getMiddleNode(Node h) {
		if (null == h) {
			return h;
		}

		Node slow = h, fast = h;

		while (null != fast.next && null != fast.next.next) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
}