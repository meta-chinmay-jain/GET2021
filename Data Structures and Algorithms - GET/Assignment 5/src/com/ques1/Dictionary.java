package com.ques1;

import java.util.List;
import java.util.Scanner;

/**
 * Implements a Dictionary where user can add new words, delete words and get
 * meanings of existing words.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-10
 */
public class Dictionary {
	private static Scanner input = new Scanner(System.in);
	private static BST bst;

	// Default Constructor
	public Dictionary() {
	}

	/**
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		final String jsonString = "{" + "\"loot\": \"goods usually of considerable value taken in war\","
				+ "\"sap\": \"the fluid part of a plant\"," + "\"chivalry\": \"mounted men-at-arms\","
				+ "\"askew\": \"out of line; at an angle\"," + "\"patio\": \"courtyard\"" + "}";
		bst = new BST(jsonString);

		Integer choice;
		while (true) {
			System.out.println("\nMENU");
			System.out.println("1. Add");
			System.out.println("2. Search");
			System.out.println("3. Delete");
			System.out.println("4. Sorted List of Keys");
			System.out.println("5. Sorted List of Keys (>=K1 and <=K2)");
			System.out.println("6. Exit");

			System.out.print("\nEnter choice: ");
			choice = getUserChoice();

			if (null != choice) {
				switch (choice) {
				case 1:
					addKeyValuePair();
					break;
				case 2:
					searchKeyValuePair();
					break;
				case 3:
					deleteKeyValuePair();
					break;
				case 4:
					printSortedWordsList();
					break;
				case 5:
					printRangedSortedWordsList();
					break;
				case 6:
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

	// Takes inputs from user and calls add() method to add them to dictionary.
	private static void addKeyValuePair() {
		System.out.print("\nEnter Word: ");
		String key = input.nextLine().trim();

		System.out.print("Enter Meaning: ");
		String value = input.nextLine().trim();

		if (!key.isBlank() && !value.isBlank()) {
			boolean isAdded = bst.add(key, value);
			if (isAdded) {
				System.out.println("\nWord added successfully.");
			} else {
				System.out.println("\nWord already exists!");
			}
		} else {
			System.out.println("\nInvalid inputs!");
		}
	}

	// Takes input from user and calls getValue() to find the value of given key.
	private static void searchKeyValuePair() {
		System.out.print("\nEnter Word: ");
		String key = input.nextLine().trim();

		String value = bst.getValue(key);
		if (null != value) {
			System.out.println("Meaning: " + value);
		} else {
			System.out.println("\nWord not found in Dictionary!");
		}
	}

	// Takes input from user and calls delete() to delete the provided key from
	// dictionary.
	private static void deleteKeyValuePair() {
		System.out.print("\nEnter Key: ");
		String key = input.nextLine().trim();

		if (!key.isBlank()) {
			boolean isDeleted = bst.delete(key);
			if (isDeleted) {
				System.out.println("\nWord deleted successfully.");
			} else {
				System.out.println("\nWord not found!");
			}
		} else {
			System.out.println("\nInvalid input!");
		}
	}

	// Prints sorted list of dictionary entries.
	private static void printSortedWordsList() {
		List<BST.Node> list = bst.sorted();
		if (list.size() > 0) {
			System.out.println("\nSorted List of Pairs:\n");
			for (BST.Node pair : list) {
				System.out.println("> " + pair.key + ": " + pair.value);
			}
		} else {
			System.out.println("\nDictionary is empty!");
		}
	}

	// Prints sorted list of dictionary entries between a range.
	private static void printRangedSortedWordsList() {
		System.out.print("\nEnter Start Word: ");
		String k1 = input.nextLine().trim();

		System.out.print("Enter End Word: ");
		String k2 = input.nextLine().trim();

		if (k1.compareToIgnoreCase(k2) > 0) {
			System.out.println("\nInvalid inputs!");
		} else {
			List<BST.Node> list = bst.sorted(k1, k2);
			if (list.size() > 0) {
				System.out.println("\nSorted List of Pairs in given range:\n");
				for (BST.Node pair : list) {
					System.out.println("> " + pair.key + ": " + pair.value);
				}
			} else {
				System.out.println("\nNo words found in given range!");
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