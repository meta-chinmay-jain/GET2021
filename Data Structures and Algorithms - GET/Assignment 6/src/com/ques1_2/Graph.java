package com.ques1_2;

import java.util.HashSet;
import java.util.List;

/**
 * Graph Implementation using Edge list representation. Provide various methods
 * to perform graph operations.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-11
 */
public class Graph implements GraphInterface {
	private HashSet<Node> nodes;

	public Graph() {
		nodes = new HashSet<>();
	}

	public boolean addEdge(Node v1, Node v2, int weight) {
		return v1.getEdges().add(new Edge(v2, weight)) && v2.getEdges().add(new Edge(v1, weight));
	}

	public boolean addVertex(Node v) {
		return nodes.add(v);
	}

	public void printGraph() {
		for (Node v : nodes) {
			System.out.println("Vertex " + v.getName() + ":");
			for (Edge e : v.getEdges()) {
				System.out.println("=> Dest. Vertex: " + e.getDestVertex().getName() + ", Weight: " + e.getWeight());
			}
			System.out.println();
		}
	}

	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Node> reachable(Node node) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Node> minSpanningTree() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Node> shortestPath(Node node1, Node node2) {
		// TODO Auto-generated method stub
		return null;
	}
}
