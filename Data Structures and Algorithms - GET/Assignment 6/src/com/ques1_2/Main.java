package com.ques1_2;

import java.util.Scanner;

/**
 * Driver code for Graph Implementation using Edge list representation.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-11
 */
public class Main {
	private static Scanner input = new Scanner(System.in);
	private static Graph graph;

	// Default constructor
	public Main() {
	}

	/**
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		graph = new Graph();

		// creating graph manually
		// creating nodes
		Node v0 = new Node("0");
		Node v1 = new Node("1");
		Node v2 = new Node("2");
		Node v3 = new Node("3");

		// adding nodes to graph
		graph.addVertex(v0);
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);

		// adding edges between nodes
		graph.addEdge(v0, v1, 2);
		graph.addEdge(v1, v2, 3);
		graph.addEdge(v2, v0, 1);
		graph.addEdge(v2, v3, 1);
		graph.addEdge(v3, v2, 4);

		Integer choice;

		while (true) {
			System.out.println("\nMENU");
			System.out.println("1. Is Graph Connected?");
			System.out.println("2. Find Reachable Vertices");
			System.out.println("3. Minimum Spanning Tree");
			System.out.println("4. Find Shortest Path");
			System.out.println("5. Display Graph");
			System.out.println("6. Exit");

			System.out.print("\nEnter choice: ");
			choice = getUserChoice();

			if (null != choice) {
				switch (choice) {
				case 1:
					checkIsConnected();
					break;
				case 2:
					findReachable();
					break;
				case 3:
					minimumSpanningTree();
					break;
				case 4:
					findShortestPath();
					break;
				case 5:
					System.out.println("\nGRAPH:\n");
					graph.printGraph();
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

	private static void findShortestPath() {
		// TODO Auto-generated method stub

	}

	private static void minimumSpanningTree() {
		// TODO Auto-generated method stub

	}

	private static void findReachable() {
		// TODO Auto-generated method stub

	}

	private static void checkIsConnected() {
		// TODO Auto-generated method stub

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