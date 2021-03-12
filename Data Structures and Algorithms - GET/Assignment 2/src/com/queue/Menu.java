package com.queue;

import java.util.Scanner;

/**
 * This class shows the menu for queue operations.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-06
 */
public class Menu {
	private static Scanner input = new Scanner(System.in);
	private CircularQueue<Integer> queue = new CircularQueue<Integer>(10); // keeping 10 as default size

	// Default Constructor
	public Menu() {
	}

	public void getMainMenu() {
		Integer choice;
		Integer element;

		while (true) {
			System.out.println("\nMENU");
			System.out.println("1. Add element");
			System.out.println("2. Remove element");
			System.out.println("3. Display Queue");
			System.out.println("4. Is Queue Empty?");
			System.out.println("5. Is Queue Full?");
			System.out.println("6. Exit");

			System.out.print("\nEnter your choice: ");
			choice = getUserInput();

			if (null != choice) {
				switch (choice) {
				case 1:
					System.out.print("\nEnter element to insert: ");
					element = getUserInput();
					boolean result = queue.enQueue(element);
					if (result) {
						System.out.println("\nElement inserted successfully.");
					} else {
						System.out.println("\nElement insertion failed!");
					}
					break;
				case 2:
					element = queue.deQueue();
					if (null != element) {
						System.out.println("\nElement Removed: " + element);
					} else {
						System.out.println("\nElement removal failed!");
					}
					break;
				case 3:
					queue.display();
					break;
				case 4:
					if (queue.isEmpty()) {
						System.out.println("\nQueue is Empty.");
					} else {
						System.out.println("\nQueue is NOT Empty.");
					}
					break;
				case 5:
					if (queue.isFull()) {
						System.out.println("\nQueue is Full.");
					} else {
						System.out.println("\nQueue is NOT Full.");
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
		}
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

	/**
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.getMainMenu();
	}
}
