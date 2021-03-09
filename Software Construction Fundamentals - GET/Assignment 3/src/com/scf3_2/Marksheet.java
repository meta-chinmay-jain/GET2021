package com.scf3_2;

import java.util.Scanner;

/**
 * This class provides methods to perform various operations on grades of
 * students.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-08
 */
public class Marksheet {

	// Default constructor
	public Marksheet() {
	}

	/**
	 * This method finds the average of grades of all students.
	 * 
	 * @param grades Integer array of grades of all students, requires grade in
	 *               range [0-100].
	 * @return float Average of grades.
	 * @throws ArithmeticException when either no. of students <= 0 or grade out of
	 *                             range [0-100].
	 */
	public float averageOfAllGrades(int[] grades) throws ArithmeticException {
		if (grades.length <= 0) {
			throw new ArithmeticException("Number of students is less than or equal to zero");
		}

		float avg;
		int sum = 0;
		for (int grade : grades) {
			if (grade < 0 || grade > 100) {
				throw new ArithmeticException("Student grade out of valid range [0-100]");
			}

			sum += grade;
		}

		avg = ((float) sum) / grades.length;
		return Float.valueOf(String.format("%.2f", avg));
	}

	/**
	 * This method finds the maximum grade out of all grades.
	 * 
	 * @param grades Integer array of grades of all students, requires grade in
	 *               range [0-100].
	 * @return integer Maximum grade out of all grades.
	 * @throws ArithmeticException when either no. of students <= 0 or grade out of
	 *                             range [0-100].
	 */
	public int maxOfAllGrades(int[] grades) throws ArithmeticException {
		if (grades.length <= 0) {
			throw new ArithmeticException("Number of students is less than or equal to zero");
		}

		int max = 0;
		for (int grade : grades) {
			if (grade < 0 || grade > 100) {
				throw new ArithmeticException("Student grade out of valid range [0-100]");
			}

			if (grade > max) {
				max = grade;
			}
		}

		return max;
	}

	/**
	 * This method finds the minimum grade out of all grades.
	 * 
	 * @param grades Integer array of grades of all students, requires grade in
	 *               range [0-100].
	 * @return integer Minimum grade out of all grades.
	 * @throws ArithmeticException when either no. of students <= 0 or grade out of
	 *                             range [0-100].
	 */
	public int minOfAllGrades(int[] grades) throws ArithmeticException {
		if (grades.length <= 0) {
			throw new ArithmeticException("Number of students is less than or equal to zero");
		}

		int min = 101;
		for (int grade : grades) {
			if (grade < 0 || grade > 100) {
				throw new ArithmeticException("Student grade out of valid range [0-100]");
			}

			if (grade < min) {
				min = grade;
			}
		}

		return min;
	}

	/**
	 * This method finds the percentage of students who passed.
	 * 
	 * @param grades Integer array of grades of all students, requires grade in
	 *               range [0-100].
	 * @return float Percentage of total students who passed.
	 * @throws ArithmeticException when either no. of students <= 0 or grade out of
	 *                             range [0-100].
	 */
	public float percentageOfStudentsPassed(int[] grades) throws ArithmeticException {
		if (grades.length <= 0) {
			throw new ArithmeticException("Number of students is less than or equal to zero");
		}

		float perctPass;
		int count = 0;
		for (int grade : grades) {
			if (grade < 0 || grade > 100) {
				throw new ArithmeticException("Student grade out of valid range [0-100]");
			}

			if (grade >= 40) {
				count++;
			}
		}

		perctPass = ((float) count) * 100 / grades.length;
		return Float.valueOf(String.format("%.2f", perctPass));
	}

	/**
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;

		System.out.print("\nEnter no. of students: ");
		n = input.nextInt();

		int[] grades = new int[n];
		System.out.println("\nEnter grades:");
		for (int i = 0; i < n; i++) {
			grades[i] = input.nextInt();
		}

		Marksheet msheet = new Marksheet();
		int choice;

		try {
			do {
				System.out.println("\nMENU");
				System.out.println("\n1. Average of Grades");
				System.out.println("2. Maximum Grade");
				System.out.println("3. Minimum Grade");
				System.out.println("4. Percentage of Students Passed");
				System.out.println("5. Exit");

				System.out.print("\nEnter your choice: ");
				choice = input.nextInt();

				switch (choice) {
				case 1:
					System.out.println("\nAVERAGE: " + msheet.averageOfAllGrades(grades));
					break;
				case 2:
					System.out.println("\nMAXIMUM GRADE: " + msheet.maxOfAllGrades(grades));
					break;
				case 3:
					System.out.println("\nMINIMUM GRADE: " + msheet.minOfAllGrades(grades));
					break;
				case 4:
					System.out.println("\nPERCENTAGE OF STUDENTS PASSED: " + msheet.percentageOfStudentsPassed(grades));
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
		} catch (ArithmeticException ae) {
			System.out.println("\n" + ae.toString());
		}
	}
}
