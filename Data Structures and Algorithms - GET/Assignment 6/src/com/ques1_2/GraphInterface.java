package com.ques1_2;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * This interface defines the methods for various operations on undirected
 * weighted graph.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-11
 */
public interface GraphInterface {
	/**
	 * This method check whether the graph is connected or not.
	 * 
	 * @return boolean True if graph is connected, False otherwise.
	 */
	boolean isConnected();

	/**
	 * This method returns all the nodes which are reachable from given node.
	 * 
	 * @param vertex The node from which we have to find all reachable nodes.
	 * @return HashSet<Node> Set of all reachable nodes.
	 */
	HashSet<Node> reachable(String vertex);

	/**
	 * This method returns the minimum spanning tree of given graph.
	 * 
	 * @return ArrayList<Edge> All the edges of minimum spanning tree.
	 */
	ArrayList<Edge> minSpanningTree();

	/**
	 * This method finds the shortest path between two node of a graph.
	 * 
	 * @param source Source Node of graph.
	 * @param dest   Destination Node of graph.
	 * @return ArrayList<Edge> List of all the edges needed to complete the shortest
	 *         path.
	 */
	ArrayList<Edge> shortestPath(String source, String dest);
}
