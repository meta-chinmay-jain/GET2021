package com.ques1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Driver code for Collections use with Employee class.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-14
 */
public class Main {
	private static Scanner input = new Scanner(System.in);
	private static final List<Employee> employees = new ArrayList<Employee>();

	// Default constructor
	public Main() {
	}

	/**
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		Integer choice;

		while (true) {
			System.out.println("\nMENU\n");
			System.out.println("1. Add Employee");
			System.out.println("2. Natural Sort");
			System.out.println("3. Sort by Name");
			System.out.println("4. Display Employees");
			System.out.println("5. Exit");

			System.out.print("\nEnter choice: ");
			choice = getUserChoice();

			if (null != choice) {
				switch (choice) {
				case 1:
					addEmployee();
					break;
				case 2:
					if (!employees.isEmpty()) {
						Collections.sort(employees);
						System.out.println("\nSorting successful.");
					} else {
						System.out.println("\nList is empty!");
					}
					break;
				case 3:
					if (!employees.isEmpty()) {
						Collections.sort(employees, new NameComparator());
						System.out.println("\nSorting successful.");
					} else {
						System.out.println("\nList is empty!");
					}
					break;
				case 4:
					if (!employees.isEmpty()) {
						System.out.println("\nEmployees: ");
						System.out.println(employees);
					} else {
						System.out.println("\nList is empty!");
					}
					break;
				case 5:
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

	// adds a new employee.
	private static void addEmployee() {
		System.out.println("\nEnter Employee Details:");

		System.out.print("\nID: ");
		String empId = input.nextLine().trim();

		System.out.print("Name: ");
		String name = input.nextLine().trim();

		System.out.print("Address: ");
		String address = input.nextLine().trim();

		Employee employee = new Employee(empId, name, address);
		if (!employees.contains(employee)) {
			employees.add(employee);
			System.out.println("\nEmployee added successfully.");
		} else {
			System.out.println("\nEmployee already exists!");
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