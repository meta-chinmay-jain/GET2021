package com.ques3;

import java.util.Stack;

/**
 * Class to represent an organic chemistry formula. Provides method to calculate
 * the mass of an organic compound.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-14
 */
public class Formula {

	// Default constructor
	public Formula() {
	}

	/**
	 * This method finds the mass of an organic compound using its formula.
	 * 
	 * @param compound The organic compound in String format.
	 * @return Integer Mass of given organic compound.
	 */
	public static int getMassOfCompound(String compound) {
		Stack<Integer> stack = new Stack<Integer>();
		char[] elements = compound.toCharArray();

		int index = 0;
		while (index < elements.length) {
			if (elements[index] == '(') {
				stack.push(0); // adding 0 as a marker
			}

			else if (elements[index] == ')') {
				// adding all elements mass inside of brackets
				int sum = 0;
				if (!stack.isEmpty()) {
					while (0 != stack.peek()) {
						sum += stack.pop();
						if (stack.isEmpty()) {
							return -1;
						}
					}
					stack.pop(); // removing 0 from stack
					stack.push(sum); // pushing total sum of elements inside bracket
				}
			}

			// checking if element is Carbon
			else if (elements[index] == 'C') {
				stack.push(12); // mass of Carbon
			}

			// checking if element if Hydrogen
			else if (elements[index] == 'H') {
				stack.push(1); // mass of Hydrogen
			}

			// checking if element if Oxygen
			else if (elements[index] == 'O') {
				stack.push(16); // mass of Oxygen
			}

			// if none of the above conditions meet, then it is a number
			else {
				if (stack.isEmpty() || 0 == stack.peek()) {
					return -1;
				}

				// getting the whole number (it could be a multi-digit number)
				int num = 0;
				while (index < elements.length && elements[index] >= 48 && elements[index] <= 57) {
					num = num * 10 + ((int) elements[index] - 48);
					index++;
				}
				index--; // preventing from incrementing twice

				if (0 == num) {
					return -1;
				}

				stack.push(num * stack.pop());
			}
			index++;
		}

		// adding all the values from stack
		int totalMass = 0;
		while (!stack.isEmpty()) {
			if (0 != stack.peek()) {
				totalMass += stack.pop();
			} else {
				return -1;
			}
		}

		return totalMass;
	}

	/**
	 * Driver code for organic compound mass calculation.
	 * 
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		String[] testCases = { "CHOC(CH3)3", "C(OH)2", "C12O2H8", "", "()", "(2CO)", "COS", "23", "((((C))2)H3(O))",
				"(CH3(HC)((C2H()2))3)2", "CH(O)(H)2", "CH(H(O)2)2H", "CH((H)O)2HC", "CCC)2", "((CCC", "C2(2H)", "-2",
				"CH0" };

		for (String testCase : testCases) {
			int result = Formula.getMassOfCompound(testCase);
			if (-1 != result) {
				System.out.println("\n> " + "\"" + testCase + "\" => " + result);
			} else {
				System.out.println("\n> " + "\"" + testCase + "\" => " + "Invalid input!");
			}
		}
	}
}
