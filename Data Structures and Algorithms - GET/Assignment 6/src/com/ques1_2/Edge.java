package com.ques1_2;

/**
 * Edge class represents the structure of an edge of a graph.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-11
 */
public class Edge {
	private int weight;
	private Node destVertex;

	public Edge(Node dest, int weight) {
		this.destVertex = dest;
		this.weight = weight;
	}

	public Edge(Node dest) {
		this.destVertex = dest;
		this.weight = 1;
	}

	public int getWeight() {
		return weight;
	}

	public Node getDestVertex() {
		return destVertex;
	}
}
