/**
 * Java program to represent Multivariate Polynomials using nested Linked Lists.
 */
package com.poly;

import java.util.Scanner;

/**
 * This class contains the driver code for Multivariate Polynomial
 * implementation and stores a Polynomial representation into nested lists.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-04
 */
public class Polynomial {
	private static Scanner input = new Scanner(System.in);
	private TermList terms = new TermList();

	/**
	 * This method creates a Polynomial using nested linked lists.
	 * 
	 * @return boolean True if polynomial created successfully, False otherwise
	 */
	private boolean create() {
		Integer noOfTerms;
		Integer coefficient;

		System.out.print("\nEnter number of terms in polynomial: ");
		noOfTerms = getUserInput();
		if (noOfTerms == null) {
			return false;
		}

		int count1 = 1;
		while (count1 <= noOfTerms) {
			Integer noOfVars;

			System.out.print("\nTerm " + count1 + " Details:");

			System.out.print("\nEnter coefficient: ");
			coefficient = getUserInput();
			if (null == coefficient || coefficient == 0) {
				return false;
			}
			TermNode term = terms.addNewNode(coefficient);

			System.out.print("Enter number of variables: ");
			noOfVars = getUserInput();
			if (noOfVars == null) {
				return false;
			}

			int count2 = 1;
			while (count2 <= noOfVars) {
				System.out.print("\nEnter Variable " + count2 + " Name: ");
				char varName = input.nextLine().charAt(0);

				System.out.print("Enter Variable " + count2 + " Power: ");
				Integer power = getUserInput();
				if (power == null) {
					return false;
				}
				term.varList.addNewNode(varName, power);
				count2++;
			}
			count1++;
		}
		return true;
	}

	/**
	 * This method finds the degree of a polynomial.
	 * 
	 * @return Integer representing the degree of polynomial.
	 */
	private int findDegree() {
		int max = 0;
		TermNode tempTerm = terms.head;
		while (tempTerm != null) {
			VarNode tempVar = tempTerm.varList.head;
			int sum = 0;
			while (tempVar != null) {
				sum += tempVar.power;
				tempVar = tempVar.next;
			}
			if (sum > max) {
				max = sum;
			}
			tempTerm = tempTerm.next;
		}
		return max;
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
		Polynomial poly = new Polynomial();
		Integer choice;
		int degree;
		boolean havePoly = false; // to check if polynomial exists

		do {
			System.out.println("\nMENU");
			System.out.println("1. Create polynomial");
			System.out.println("2. Degree of polynomial");
			System.out.println("3. Display polynomial");
			System.out.println("4. Exit");

			System.out.print("\nEnter choice: ");
			choice = getUserInput();

			if (choice != null) {
				switch (choice) {
				case 1:
					havePoly = poly.create();
					if (havePoly) {
						System.out.println("\nPolynomial Created Successfully.");
					} else {
						System.out.println("\nPolynomial Creation Failed. Please enter valid inputs!");
					}
					break;
				case 2:
					if (havePoly) {
						degree = poly.findDegree();
						System.out.println("\nDegree of Polynomial: " + degree);
					} else {
						System.out.println("\nPolynomial not found!");
					}
					break;
				case 3:
					if (havePoly) {
						System.out.print("\nMultivariate Polynomial: ");
						poly.terms.printTermList();
						System.out.println();
					} else {
						System.out.println("\nPolynomial not found!");
					}
					break;
				case 4:
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
		} while (choice != 4);
	}
}
