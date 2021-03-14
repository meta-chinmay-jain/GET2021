package com.arithmetic;

/**
 * Performs various arithmetic operations on numbers in user-selected base.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-02-26
 */
public class HexCalc {
	private int n1;
	private int n2;
	private int result;
	private int base;

	/**
	 * Parameterized Constructor for making the class generic for any base.
	 * 
	 * @param base Base representation of number.
	 */
	public HexCalc(int base) {
		this.base = base;
	}

	/**
	 * This method computes and returns the sum of two numbers.
	 * 
	 * @param num1 Input number 1.
	 * @param num2 Input number 2.
	 * @return String String representing the result in selected Base.
	 */
	public String add(String num1, String num2) {
		convertInputsToInteger(num1, num2);
		result = n1 + n2;
		return decimalNumberToString(result, base).toUpperCase();
	}

	/**
	 * This method computes and returns the difference of two numbers.
	 * 
	 * @param num1 Input number 1.
	 * @param num2 Input number 2.
	 * @return String String representing the result in selected Base.
	 */
	public String subtract(String num1, String num2) {
		convertInputsToInteger(num1, num2);
		if (n2 > n1) {
			return null;
		}
		result = n1 - n2;
		return decimalNumberToString(result, base).toUpperCase();
	}

	/**
	 * This method computes and returns the multiplication of two numbers.
	 * 
	 * @param num1 Input number 1.
	 * @param num2 Input number 2.
	 * @return String String representing the result in selected Base.
	 */
	public String multiply(String num1, String num2) {
		convertInputsToInteger(num1, num2);
		if (isMultiplicationOverflow(n1, n2)) {
			return null;
		}
		result = n1 * n2;
		return decimalNumberToString(result, base).toUpperCase();
	}

	/**
	 * This method computes and returns the division of two numbers.
	 * 
	 * @param num1 Input number 1.
	 * @param num2 Input number 2.
	 * @return String String representing the result in selected Base.
	 */
	public String divide(String num1, String num2) {
		convertInputsToInteger(num1, num2);
		result = n1 / n2;
		return decimalNumberToString(result, base).toUpperCase();
	}

	/**
	 * This method checks if num1 is equal to num2.
	 * 
	 * @param num1 Input number 1.
	 * @param num2 Input number 2.
	 * @return boolean True or False.
	 */
	public boolean equalTo(String num1, String num2) {
		if (num1.compareTo(num2) == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method checks if num1 is greater than num2.
	 * 
	 * @param num1 Input number 1.
	 * @param num2 Input number 2.
	 * @return boolean True or False.
	 */
	public boolean greaterThan(String num1, String num2) {
		if (num1.compareTo(num2) > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method checks if num1 is less than num2.
	 * 
	 * @param num1 Input number 1.
	 * @param num2 Input number 2.
	 * @return boolean True or False.
	 */
	public boolean lessThan(String num1, String num2) {
		if (num1.compareTo(num2) < 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Converts the Hexadecimal Input to Decimal Format.
	 * 
	 * @param num Input number.
	 * @return Integer Decimal conversion of input number.
	 */
	public Integer toDecimal(String num) {
		return stringToDecimalNumber(num, 16);
	}

	/**
	 * Converts the Decimal number to Hexadecimal Format.
	 * 
	 * @param num Input number.
	 * @return String Hexadecimal conversion of input number.
	 */
	public String toHexaDecimal(Integer num) {
		return decimalNumberToString(num, 16).toUpperCase();
	}

	/**
	 * Converts the String input to Decimal Number format.
	 * 
	 * @param num  Input number string.
	 * @param base Base of input string.
	 * @return Integer Decimal conversion of number string.
	 */
	public static int stringToDecimalNumber(String num, int base) {
		int length = num.length();
		int power = 1;

		int result = 0;

		for (int count = length - 1; count >= 0; count--) {
			result += toDecimalVal(num.charAt(count)) * power;
			power *= base;
		}

		return result;
	}

	/**
	 * Converts a single character to decimal format.
	 * 
	 * @param c Character from number string.
	 * @return Integer Decimal value of character.
	 */
	public static int toDecimalVal(char c) {
		if (c >= '0' && c <= '9') {
			return (int) c - '0';
		} else {
			return (int) c - 'A' + 10;
		}
	}

	/**
	 * Converts the Decimal number input to String format.
	 * 
	 * @param num  Input decimal number.
	 * @param base Base of output number string.
	 * @return String String format of input number in given base.
	 */
	public static String decimalNumberToString(int num, int base) {
		if (num == 0) {
			return "0";
		}

		String result = "";

		while (num > 0) {
			result += toCharVal(num % base);
			num /= base;
		}

		StringBuilder sB = new StringBuilder();
		sB.append(result);

		return new String(sB.reverse());
	}

	/**
	 * Converts a decimal number to it's character representation.
	 * 
	 * @param n Decimal number.
	 * @return char Character representation of given decimal number.
	 */
	public static char toCharVal(int n) {
		if (n >= 0 && n <= 9) {
			return (char) (n + 48);
		} else {
			return (char) (n - 10 + 65);
		}
	}

	/**
	 * Checks if the result of multiplication will overflow integer range.
	 * 
	 * @param a Input number 1.
	 * @param b Input number 2.
	 * @return boolean True if it will overflow, False otherwise.
	 */
	private static boolean isMultiplicationOverflow(int a, int b) {
		// Check if either of them is zero
		if (a == 0 || b == 0)
			return false;

		int result = a * b;
		if (a == result / b)
			return false;
		else
			return true;
	}

	/**
	 * This method converts input to integers to perform operations on them.
	 * 
	 * @param num1 Input number 1.
	 * @param num2 Input number 2.
	 */
	private void convertInputsToInteger(String num1, String num2) {
		n1 = stringToDecimalNumber(num1, base);
		n2 = stringToDecimalNumber(num2, base);
	}
}