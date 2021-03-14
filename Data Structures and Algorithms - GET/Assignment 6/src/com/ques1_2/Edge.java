package com.ques1_2;

/**
 * Edge class represents the structure of an edge of a graph.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-11
 */
public class Edge implements Comparable<Edge> {
	private int weight;
	private Node sourceVertex;
	private Node destVertex;

	public Edge(Node source, Node dest, int weight) {
		this.sourceVertex = source;
		this.destVertex = dest;
		this.weight = weight;
	}

	public Edge(Node dest) {
		this.destVertex = dest;
		this.weight = 1;
	}

	@Override
	public int compareTo(Edge edge) {
		return this.weight - edge.weight;
	}

	public int getWeight() {
		return weight;
	}

	public Node getSourceVertex() {
		return sourceVertex;
	}

	public Node getDestVertex() {
		return destVertex;
	}

}
