package com.ques1_2;

import java.util.ArrayList;
import java.util.HashSet;
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
		graph.addEdge(v3, v1, 4);

		Integer choice;

		while (true) {
			System.out.println("\nMENU\n");
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

	// takes user input, calls shortestPath() method of graph and displays result
	private static void findShortestPath() {
		System.out.print("\nEnter Source Vertex: ");
		String source = input.nextLine().trim();

		System.out.print("Enter Destination Vertex: ");
		String dest = input.nextLine().trim();

		ArrayList<Edge> path = graph.shortestPath(source, dest);

		if (null != path) {
			System.out.println("\nShortest Path:");

			int cost = 0;
			String sourceToDest = "";
			for (Edge edge : path) {
				sourceToDest = "\n" + edge.getSourceVertex().getVertex() + "->" + edge.getDestVertex().getVertex()
						+ sourceToDest;
				cost += edge.getWeight();
			}
			System.out.println(sourceToDest);
			System.out.println("\nTotal Cost: " + cost);
		} else {
			System.out.println("\nPath could not be found!");
		}
	}

	// calls minSpanningTree() method of graph and displays result
	private static void minimumSpanningTree() {
		ArrayList<Edge> edges = graph.minSpanningTree();
		int cost = 0;

		if (null != edges) {
			System.out.println("\nEdges in MST:\n");

			for (Edge edge : edges) {
				System.out.println(edge.getSourceVertex().getVertex() + " -- " + edge.getDestVertex().getVertex()
						+ " == " + edge.getWeight());
				cost += edge.getWeight();
			}

			System.out.println("\nMinimum Cost Spanning Tree: " + cost);
		} else {
			System.out.println("\nMinimum Spanning Tree could not be found!");
		}
	}

	// takes user input, calls reachable() method of graph and displays result
	private static void findReachable() {
		System.out.print("\nEnter vertex: ");
		String vertex = input.nextLine().trim();

		HashSet<Node> nodes = graph.reachable(vertex);
		if (null != nodes) {
			for (Node node : nodes) {
				System.out.println("Vertex: " + node.getVertex());
			}
		} else {
			System.out.println("\nEntered vertex does not exist!");
		}
	}

	// calls isConnected() method of graph and displays result
	private static void checkIsConnected() {
		if (graph.isConnected()) {
			System.out.println("\nYes, graph is connected.");
		} else {
			System.out.println("\nNo, graph is NOT connected.");
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