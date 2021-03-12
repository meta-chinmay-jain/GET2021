package com.ques1_2;

import java.util.List;

/**
 * This interface defines the methods for undirected weighted graph.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-11
 */
public interface GraphInterface {
	boolean isConnected();

	List<Node> reachable(Node node);

	List<Node> minSpanningTree();

	List<Node> shortestPath(Node node1, Node node2);
}
