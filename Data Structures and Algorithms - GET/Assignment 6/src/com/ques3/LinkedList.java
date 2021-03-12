package com.ques3;

/**
 * This class defines methods to create, display and sort a Linked List. Sorting
 * is done by swapping values, not pointers.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-11
 */
public class LinkedList {
	private Node head = null;

	/**
	 * This class is used to define the structure of a single Node of Linked List.
	 */
	protected static class Node {
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

		if (getHead() == null) {
			setHead(newNode);
		} else {
			Node temp = getHead();

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
		if (getHead() != null) {
			Node temp = getHead();

			while (temp != null) {
				System.out.println("(" + temp.empId + ", " + temp.salary + ", " + temp.age + ")");
				temp = temp.next;
			}
		} else {
			System.out.println("\nList is empty!");
		}
	}

	/**
	 * Quick sort implementation for singly linked list.
	 * 
	 * @param start Starting node of list/sub-list.
	 * @param end   Ending node of list/sub-list.
	 */
	public void quickSort(Node start, Node end) {
		if (start == null || start == end || start == end.next)
			return;

		// split list and partition recurse
		Node pivot_prev = partition(start, end);
		quickSort(start, pivot_prev);

		// if pivot is picked and moved to the start,
		// that means start and pivot is same
		// so pick from next of pivot
		if (pivot_prev != null && pivot_prev == start)
			quickSort(pivot_prev.next, end);

		// if pivot is in between of the list,
		// start from next of pivot,
		// since we have pivot_prev, so we move two nodes
		else if (pivot_prev != null && pivot_prev.next != null)
			quickSort(pivot_prev.next.next, end);
	}

	/**
	 * Partitioning.
	 * <p>
	 * Details - Choose the last node as pivot. Traverse and move the nodes with
	 * smaller value than pivot to the right of pivot.
	 * </p>
	 * 
	 * @param start Starting node of list/sub-list.
	 * @param end   Ending node of list/sub-list.
	 * @return Node The node just before pivot node.
	 */
	private Node partition(Node start, Node end) {
		if (start == end || start == null || end == null)
			return start;

		Node pivot_prev = start;
		Node current = start;
		Node pivot = end;

		// iterate till one before the end,
		// no need to iterate till the end
		// because end is pivot
		while (start != end) {
			if (start.salary > pivot.salary || (start.salary == pivot.salary && start.age < pivot.age)) {
				// keep tracks of last modified item
				pivot_prev = current;

				String empId = current.empId;
				double salary = current.salary;
				int age = current.age;

				current.empId = start.empId;
				current.salary = start.salary;
				current.age = start.age;

				start.empId = empId;
				start.salary = salary;
				start.age = age;

				current = current.next;
			}
			start = start.next;
		}

		// swap the position of current i.e.
		// next suitable index and pivot
		String empId = current.empId;
		double salary = current.salary;
		int age = current.age;

		current.empId = pivot.empId;
		current.salary = pivot.salary;
		current.age = pivot.age;

		end.empId = empId;
		end.salary = salary;
		end.age = age;

		// return one previous to current
		// because current is now pointing to pivot
		return pivot_prev;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
}