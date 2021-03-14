package com.arithmetic;

import java.util.Scanner;

/**
 * Creates a command-line User Interface for performing Arithmetic Operations.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-02-26
 */
public class Menu {
	private static Scanner input = new Scanner(System.in);
	private static String num1;
	private static String num2;
	private static String result;
	private static Integer base = 16; // Initializing to Hexadecimal Base
	private static HexCalc hexCalc = new HexCalc(base);

	public static void main(String[] args) {
		getMainMenu();
		input.close();
	}

	// Default Constructor
	public Menu() {
	}

	private static void getMainMenu() {
		Integer choice;

		while (true) {
			System.out.println("\nBASE = " + base);

			getMenuItems();

			System.out.print("\nEnter your choice: ");
			choice = getUserChoice();

			switch (choice) {
			case 1:
				getOperands();
				getAddition();
				break;
			case 2:
				getOperands();
				getSubtraction();
				break;
			case 3:
				getOperands();
				getMultiplication();
				break;
			case 4:
				getOperands();
				getDivision();
				break;
			case 5:
				getOperands();
				checkEqualTo();
				break;
			case 6:
				getOperands();
				checkGreaterThan();
				break;
			case 7:
				getOperands();
				checkLessThan();
				break;
			case 8:
				convertHexToDecimal();
				break;
			case 9:
				convertDecimalToHex();
				break;
			case 10:
				changeBase();
				break;
			case 11:
				System.exit(0);
				break;
			default:
				break;
			}
		}
	}

	/**
	 * Displays the list of options on the command line.
	 */
	private static void getMenuItems() {
		System.out.println("\nMENU\n");
		System.out.println(" 1. Add");
		System.out.println(" 2. Subtract");
		System.out.println(" 3. Multiply");
		System.out.println(" 4. Divide");
		System.out.println(" 5. Equal To (==)");
		System.out.println(" 6. Greater Than (>)");
		System.out.println(" 7. Less Than (<)");
		System.out.println(" 8. Hexadecimal to Decimal");
		System.out.println(" 9. Decimal To Hexadecimal");
		System.out.println("10. Change Base");
		System.out.println("11. Exit");
	}

	/**
	 * Gets addition of two numbers,
	 */
	private static void getAddition() {
		if (checkFormat(num1) && checkFormat(num2)) {
			result = hexCalc.add(num1, num2);
			System.out.println("\nAddition: " + result);
		} else {
			System.out.println("\nInvalid input(s)!");
		}
	}

	/**
	 * Gets subtraction of two numbers.
	 */
	private static void getSubtraction() {
		if (checkFormat(num1) && checkFormat(num2)) {
			result = hexCalc.subtract(num1, num2);
			if (null != result) {
				System.out.println("\nSubraction: " + result);
			} else {
				System.out.println("\nNegative result can't be displayed!");
			}
		} else {
			System.out.println("\nInvalid input(s)!");
		}
	}

	/**
	 * Gets multiplication of two numbers.
	 */
	private static void getMultiplication() {
		if (checkFormat(num1) && checkFormat(num2)) {
			result = hexCalc.multiply(num1, num2);
			if (null != result) {
				System.out.println("\nMultiplication: " + result);
			} else {
				System.out.println("\nResult out of range!");
			}
		} else {
			System.out.println("\nInvalid input(s)!");
		}
	}

	/**
	 * Gets division of two numbers.
	 */
	private static void getDivision() {
		if (checkFormat(num1) && checkFormat(num2) && !num2.equals("0")) {
			result = hexCalc.divide(num1, num2);
			System.out.println("\nDivision: " + result);
		} else {
			System.out.println("\nInvalid input(s)!");
		}
	}

	/**
	 * Checks if two numbers are equal.
	 */
	private static void checkEqualTo() {
		if (checkFormat(num1) && checkFormat(num2)) {
			boolean result = hexCalc.equalTo(num1, num2);

			if (result) {
				System.out.println("\n" + num1 + " is equal to " + num2);
			} else {
				System.out.println("\n" + num1 + " is NOT equal to " + num2);
			}
		} else {
			System.out.println("\nInvalid input(s)!");
		}
	}

	/**
	 * Checks if num1 is greater than num2.
	 */
	private static void checkGreaterThan() {
		if (checkFormat(num1) && checkFormat(num2)) {
			boolean result = hexCalc.greaterThan(num1, num2);

			if (result) {
				System.out.println("\n" + num1 + " is greater than " + num2);
			} else {
				System.out.println("\n" + num1 + " is NOT greater than " + num2);
			}
		} else {
			System.out.println("\nInvalid input(s)!");
		}
	}

	/**
	 * Checks if num1 is greater than num2.
	 */
	private static void checkLessThan() {
		if (checkFormat(num1) && checkFormat(num2)) {
			boolean result = hexCalc.lessThan(num1, num2);

			if (result) {
				System.out.println("\n" + num1 + " is less than " + num2);
			} else {
				System.out.println("\n" + num1 + " is NOT less than " + num2);
			}
		} else {
			System.out.println("\nInvalid input(s)!");
		}
	}

	/**
	 * To convert a number from Hexadecimal to Decimal.
	 */
	private static void convertHexToDecimal() {
		System.out.print("\nEnter Hexadecimal Number: ");
		num1 = input.nextLine().toUpperCase();

		if (checkHex(num1)) {
			Integer result = hexCalc.toDecimal(num1);
			System.out.println("Decimal Conversion: " + result);
		} else {
			System.out.println("\nInvalid input!");
		}
	}

	/**
	 * Converts a number from Decimal to Hexadecimal.
	 */
	private static void convertDecimalToHex() {
		System.out.print("\nEnter Decimal Number: ");
		num1 = input.nextLine();

		try {
			Integer num = Integer.parseInt(num1);
			result = hexCalc.toHexaDecimal(num);
			System.out.println("Hexadecimal Conversion: " + result);
		} catch (Exception e) {
			System.out.println("\nInvalid input!");
		}
	}

	/**
	 * Changes the base for representation of numbers.
	 */
	private static void changeBase() {
		System.out.print("\nEnter BASE (between 2 and 36): ");
		int new_base;

		try {
			new_base = Integer.parseInt(input.nextLine());
			if (new_base >= 2 && new_base <= 36) { // range of bases is between 2 and 36
				base = new_base;
				hexCalc = new HexCalc(base);
			} else {
				System.out.println("\nInvalid Base value!");
			}
		} catch (Exception e) {
			System.out.println("\nInvalid input!");
		}
	}

	/**
	 * Gets the number inputs from user.
	 */
	private static void getOperands() {
		System.out.print("\nEnter First Number: ");
		num1 = input.nextLine().trim().toUpperCase();

		System.out.print("Enter Second Number: ");
		num2 = input.nextLine().trim().toUpperCase();
	}

	/**
	 * Checks whether the given input belongs to a particular base.
	 * 
	 * @param num This is the input number in String format.
	 * @return boolean True or False depending on the input string.
	 */
	private static boolean checkFormat(String num) {
		if (num.isEmpty()) {
			return false;
		}

		int length = num.length();
		char numStart, numEnd, alphaStart, alphaEnd;

		// checking if base representation only has numerals
		if (base <= 10) {
			numStart = '0';// numeric range will always start from 0
			numEnd = (char) (numStart + base - 1); // getting correct ASCII value

			for (int i = 0; i < length; i++) {
				char ch = num.charAt(i);

				if (ch < numStart || ch > numEnd) {
					return false;
				}
			}
		} else {
			numStart = '0'; // base > 10 will have complete numeric range (0-9)
			numEnd = '9';
			alphaStart = 'A'; // starting Alphabet of alphabetical range
			alphaEnd = (char) (alphaStart + base - 11); // getting correct ASCII value

			for (int i = 0; i < length; i++) {
				char ch = num.charAt(i);

				if ((ch < numStart || ch > numEnd) && (ch < alphaStart || ch > alphaEnd)) {
					return false;
				}
			}
		}
		return true;
	}

	// for checking HexaDecimal format (for hexToDec)
	private static boolean checkHex(String num) {
		int length = num.length();
		for (int i = 0; i < length; i++) {
			char ch = num.charAt(i);

			if ((ch < '0' || ch > '9') && (ch < 'A' || ch > 'F')) {
				return false;
			}
		}
		return true;
	}

	/**
	 * This method gets the user choice.
	 * 
	 * @return Integer Integer choice entered by User.
	 */
	private static int getUserChoice() {
		int ch = 0;

		try {
			ch = Integer.parseInt(input.nextLine());
		} catch (Exception e) {
			System.out.println("\nInvalid input!");
		}

		return ch;
	}
}