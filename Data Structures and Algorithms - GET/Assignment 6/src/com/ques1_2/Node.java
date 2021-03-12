package com.ques1_2;

import java.util.LinkedList;

/**
 * Node class represents the structure of each node of a graph.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-11
 */
public class Node {
	private String name;
	private LinkedList<Edge> edgeList;

	public Node(String name) {
		this.name = name;
		edgeList = new LinkedList<>();
	}

	public String getName() {
		return name;
	}

	public LinkedList<Edge> getEdges() {
		return edgeList;
	}
}
