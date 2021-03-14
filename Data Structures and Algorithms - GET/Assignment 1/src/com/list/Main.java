package com.list;

import java.util.Scanner;

/**
 * Contains Driver Code for Linked List implementation.<br>
 * - Rotating List<br>
 * - Detecting Loop
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-04
 */
public class Main {
	static Scanner input = new Scanner(System.in);

	/**
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		LinkedList.Node lastNode = null; // for creating a loop in list
		boolean loopPresent = false;
		Integer choice;

		// Creating a linked list manually
		for (int count = 1; count < 10; count++) {
			list.addNewNode(count);
		}

		System.out.print("Given Linked List: ");
		list.printLinkedList();

		do {
			System.out.println("\nMENU");
			System.out.println("1. Rotate Sub-List");
			System.out.println("2. Print Linked List");
			System.out.println("3. Detect Loop in List");
			System.out.println("4. Add Loop");
			System.out.println("5. Remove Loop");
			System.out.println("6. Exit");

			System.out.print("\nEnter choice: ");
			choice = getUserInput();

			if (choice != null) {
				switch (choice) {
				case 1:
					if (!loopPresent) {
						boolean result = false;

						System.out.print("\nLeft Position = ");
						Integer leftPos = getUserInput();
						System.out.print("Right Position = ");
						Integer rightPos = getUserInput();
						System.out.print("Number of Shifts = ");
						Integer noOfShifts = getUserInput();

						if (leftPos != null && rightPos != null && noOfShifts != null) {
							result = list.rotateSubList(leftPos, rightPos, noOfShifts);
						}

						if (result) {
							System.out.println("\nRotation Successful.");
							list.printLinkedList();
						} else {
							System.out.println("\nRotation Failed! Check your inputs and try again.");
						}
					} else {
						System.out.println("\nFirst remove loop then try again!");
					}
					break;
				case 2:
					if (!loopPresent) {
						list.printLinkedList();
					} else {
						System.out.println("\nFirst remove loop then try again!");
					}
					break;
				case 3:
					loopPresent = list.detectLoop();
					if (loopPresent) {
						System.out.println("\nLoop detected.");
					} else {
						System.out.println("\nLoop NOT detected.");
					}
					break;
				case 4:
					if (!loopPresent) {
						lastNode = list.getHead();
						while (lastNode.getNext() != null) {
							lastNode = lastNode.getNext();
						}
						lastNode.setNext(list.getHead().getNext());
						loopPresent = true;
						System.out.println("\nLoop added.");
					} else {
						System.out.println("\nLoop already present!");
					}
					break;
				case 5:
					if (loopPresent) {
						lastNode.setNext(null);
						loopPresent = false;
						System.out.println("\nLoop removed.");
					} else {
						System.out.println("\nLoop not present!");
					}
					break;
				case 6:
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
		} while (choice != 6);
	}

	/**
	 * This method gets input from user.
	 * 
	 * @return Integer Input entered by user.
	 */
	private static Integer getUserInput() {
		Integer choice = null;
		try {
			choice = Integer.parseInt(input.nextLine());
		} catch (Exception e) {
			System.out.println("\nInvalid input!");
		}
		return choice;
	}
}
