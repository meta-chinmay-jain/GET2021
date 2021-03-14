package com.ques2;

import java.util.Scanner;

/**
 * Implements a Linked List of Employees (NOT Sorted).
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-09
 */
public class Employee {
	private static Scanner input = new Scanner(System.in);

	// Default constructor
	public Employee() {
	}

	/**
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Integer choice;

		// Creating a linked list manually
		list.addNewNode("EMP001", 20000, 21);
		list.addNewNode("EMP002", 20000, 25);
		list.addNewNode("EMP003", 35000, 28);
		list.addNewNode("EMP004", 50000, 25);
		list.addNewNode("EMP005", 40000, 35);

		System.out.println("\nEmployee List: ");
		list.printLinkedList();

		while (true) {
			System.out.println("\nMENU");
			System.out.println("1. Sort Linked List");
			System.out.println("2. Print Linked List");
			System.out.println("3. Exit");

			System.out.print("\nEnter choice: ");
			choice = getUserChoice();

			if (null != choice) {
				switch (choice) {
				case 1:
					list.setHead(list.mergeSort(list.getHead()));
					System.out.println("\nSorting completed.");
					break;
				case 2:
					System.out.println("\nEmployee List: ");
					list.printLinkedList();
					break;
				case 3:
					input.close();
					System.exit(0);
					break;
				default:
					if (choice != 0) {
						System.out.println("\nInvalid Choice!");
					}
					break;
				}
			} else {
				choice = 0; // Changing from null to integer to go to next iteration
			}
		}
	}

	/**
	 * This method gets input from user.
	 * 
	 * @return Integer Choice entered by user.
	 */
	private static Integer getUserChoice() {
		Integer choice = null;
		try {
			choice = Integer.parseInt(input.nextLine());
		} catch (Exception e) {
			System.out.println("\nInvalid input!");
		}
		return choice;
	}
}