package com.ques2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Class to count unique characters of a string and to implement memoization for
 * same inputs.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-14
 */
public class MyString {
	private static final HashMap<String, Integer> uniqueCharsCount = new HashMap<String, Integer>();
	private static Scanner input = new Scanner(System.in);

	// Default Constructor
	public MyString() {
	}

	/**
	 * Counts the no. of unique characters in the given string and caches the result
	 * for future reference.
	 * 
	 * @param str Input string.
	 * @return Integer Count of unique characters.
	 */
	private static int countUniqueCharacters(String str) {
		// if count of given string already present, returning that
		if (uniqueCharsCount.containsKey(str)) {
			return uniqueCharsCount.get(str);
		}

		// storing character and it's frequency in a string
		HashSet<Character> uniqueCharInString = new HashSet<Character>();
		for (char ch : str.toCharArray()) {
			uniqueCharInString.add(ch);
		}

		int count = uniqueCharInString.size();
		uniqueCharsCount.put(str, count); // caching result

		return count;
	}

	/**
	 * Driver code.
	 * 
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		Integer choice;

		while (true) {
			System.out.println("\nMENU\n");
			System.out.println("1. Find unique characters in a String");
			System.out.println("2. Exit");

			System.out.print("\nEnter choice: ");
			choice = getUserChoice();

			if (null != choice) {
				switch (choice) {
				case 1:
					System.out.print("\nEnter string: ");
					String str = input.nextLine();

					if (!str.isBlank()) {
						int count = MyString.countUniqueCharacters(str);
						System.out.println("\nNo. of unique characters: " + count);
					} else {
						System.out.println("\nInput string is blank!");
					}
					break;
				case 2:
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