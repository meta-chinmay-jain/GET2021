package com.scf3_3;

import java.util.Scanner;

/**
 * This class provides methods to find area of different shapes.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-08
 */
public class Area {

	// Default constructor
	public Area() {
	}

	/**
	 * This method finds the area of triangle.
	 * 
	 * @param width  Width of triangle, requires width > 0.
	 * @param height Height of triangle, requires height > 0.
	 * @return double Area of triangle.
	 * @throws ArithmeticException Height or Width <= 0.
	 */
	public double areaOfTriangle(double width, double height) throws ArithmeticException {
		if (width <= 0 || height <= 0) {
			throw new ArithmeticException("Height or Width less than or equal to zero");
		}

		double area = (width * height) / 2;
		return area;
	}

	/**
	 * This method finds the area of rectangle.
	 * 
	 * @param width  Width of rectangle, requires width > 0.
	 * @param height Height of rectangle, requires height > 0.
	 * @return double Area of rectangle.
	 * @throws ArithmeticException Height or Width <= 0.
	 */
	public double areaOfRectangle(double width, double height) throws ArithmeticException {
		if (width <= 0 || height <= 0) {
			throw new ArithmeticException("Height or Width less than or equal to zero");
		}

		double area = width * height;
		return area;
	}

	/**
	 * This method finds the area of square.
	 * 
	 * @param width Width of square, requires width > 0.
	 * @return double Area of square.
	 * @throws ArithmeticException Width <= 0.
	 */
	public double areaOfSquare(double width) throws ArithmeticException {
		if (width <= 0) {
			throw new ArithmeticException("Width less than or equal to zero");
		}

		double area = width * width;
		return area;
	}

	/**
	 * This method finds the area of circle.
	 * 
	 * @param radius Radius of circle, requires radius > 0.
	 * @return double Area of circle.
	 * @throws ArithmeticException Radius <= 0.
	 */
	public double areaOfCircle(double radius) throws ArithmeticException {
		if (radius <= 0) {
			throw new ArithmeticException("Radius less than or equal to zero");
		}

		double area = Math.PI * radius * radius;
		return area;
	}

	/**
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Area area = new Area();
		double width, height, radius;
		int choice;

		try {
			do {
				System.out.println("\nMENU");
				System.out.println("\n1. Area of Triangle");
				System.out.println("2. Area of Rectangle");
				System.out.println("3. Area of Square");
				System.out.println("4. Area of Circle");
				System.out.println("5. Exit");

				System.out.print("\nEnter your choice: ");
				choice = input.nextInt();

				switch (choice) {
				case 1:
					System.out.print("\nEnter width: ");
					width = input.nextDouble();

					System.out.print("Enter height: ");
					height = input.nextDouble();

					System.out.println("\nAREA OF TRIANGLE: " + area.areaOfTriangle(width, height));
					break;
				case 2:
					System.out.print("\nEnter width: ");
					width = input.nextDouble();

					System.out.print("Enter height: ");
					height = input.nextDouble();

					System.out.println("\nAREA OF RECTANGLE: " + area.areaOfRectangle(width, height));
					break;
				case 3:
					System.out.print("\nEnter width: ");
					width = input.nextDouble();

					System.out.println("\nAREA OF SQUARE: " + area.areaOfSquare(width));
					break;
				case 4:
					System.out.print("\nEnter radius: ");
					radius = input.nextDouble();

					System.out.println("\nAREA OF CIRCLE: " + area.areaOfCircle(radius));
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
