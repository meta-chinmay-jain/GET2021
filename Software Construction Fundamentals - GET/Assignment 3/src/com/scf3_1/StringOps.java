package com.scf3_1;

import java.util.Scanner;

/**
 * This class provides methods to perform various operations on Strings.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-07
 */
public class StringOps {

	// Default constructor
	public StringOps() {
	}

	/**
	 * This method provides case-sensitive string comparison.
	 * 
	 * @param str1 First input string, requires to be not null.
	 * @param str2 Second input string, requires to be not null.
	 * @return Integer 1 if str1 == str2, 0 otherwise
	 */
	public int compareStrings(String str1, String str2) {
		if (null == str1 || null == str2 || str1.length() != str2.length()) {
			return 0;
		}

		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				return 0;
			}
		}

		return 1;
	}

	/**
	 * This method returns the reverse of a given string.
	 * 
	 * @param str Input string, requires to be not null.
	 * @return String Reverse of input string.
	 */
	public String reverseString(String str) {
		if (str == null) {
			return "String is null!";
		}

		String rev = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			rev += str.charAt(i);
		}

		return rev;
	}

	/**
	 * This method changes the case of each character of the given string.
	 * 
	 * @param str Input string, requires to be not null.
	 * @return String Converts lower-case letters to upper-case letters and
	 *         vice-versa.
	 */
	public String changeCase(String str) {
		if (str == null) {
			return "String is null!";
		}

		String result = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			// if upper-case changing to lower-case
			if (ch >= 65 && ch <= 90) {
				result += (char) (ch - 65 + 97);
			}

			// if lower-case changing to upper-case
			else if (ch >= 97 && ch <= 122) {
				result += (char) (ch - 97 + 65);
			}

			// if doesn't belong to alphabet range, add it as it is
			else {
				result += ch;
			}
		}

		return result;
	}

	/**
	 * This method finds the longest word from the given string.
	 * 
	 * @param str Input string, requires to be not null.
	 * @return String Longest word from end of given string.
	 */
	public String findLongestWord(String str) {
		if (str == null) {
			return "String is null!";
		}

		String temp = "", result = "";
		int count = 0, maxLength = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122) {
				temp += ch;
				count++;
			} else {
				if (count >= maxLength) {
					maxLength = count;
					result = temp;
				}
				temp = "";
				count = 0;
			}
		}

		if (count >= maxLength) {
			return temp;
		}
		return result;
	}

	/**
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		int choice;
		String str1, str2;
		Scanner input = new Scanner(System.in);
		StringOps stringOp = new StringOps();

		do {
			System.out.println("\nMENU");
			System.out.println("\n1. Compare two Strings");
			System.out.println("2. Reverse string");
			System.out.println("3. Change case");
			System.out.println("4. Find Largest Word");
			System.out.println("5. Exit");

			System.out.print("\nEnter your choice: ");
			choice = input.nextInt();

			switch (choice) {
			case 1:
				System.out.print("\nEnter first string: ");
				str1 = input.nextLine() + input.nextLine();

				System.out.print("Enter second string: ");
				str2 = input.nextLine();

				System.out.println("\nEqual: " + stringOp.compareStrings(str1, str2));

				break;
			case 2:
				System.out.print("\nEnter string: ");
				str1 = input.nextLine() + input.nextLine();

				System.out.println("\nReverse: " + stringOp.reverseString(str1));

				break;
			case 3:
				System.out.print("\nEnter string: ");
				str1 = input.nextLine() + input.nextLine();

				System.out.println("\nChanged case: " + stringOp.changeCase(str1));

				break;
			case 4:
				System.out.print("\nEnter string: ");
				str1 = input.nextLine() + input.nextLine();

				System.out.println("\nLargest Word: " + stringOp.findLongestWord(str1));

				break;
			case 5:
				input.close();
				System.exit(0);
				break;
			default:
				System.out.println("\nInvalid choice!");
				break;
			}
		} while (true);
	}
}
