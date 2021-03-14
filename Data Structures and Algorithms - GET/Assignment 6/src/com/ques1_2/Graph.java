package com.ques1_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;

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
	private Node startNode;

	// Default Constructor
	public Graph() {
		nodes = new HashSet<>();
	}

	/**
	 * Adds an edge between two nodes of the graph.
	 * 
	 * @param v1     Node 1.
	 * @param v2     Node 2.
	 * @param weight Weight of edge.
	 * @return boolean True if edge added successfully, False otherwise.
	 */
	public boolean addEdge(Node v1, Node v2, int weight) {
		return v1.getEdges().add(new Edge(v1, v2, weight)) && v2.getEdges().add(new Edge(v2, v1, weight));
	}

	/**
	 * Adds a new node to the graph.
	 * 
	 * @param v The node to be added.
	 * @return boolean True if node added successfully, False otherwise.
	 */
	public boolean addVertex(Node v) {
		if (null == startNode) {
			startNode = v;
		}
		return nodes.add(v);
	}

	/**
	 * Prints all the nodes and edges of the graph.
	 */
	public void printGraph() {
		for (Node v : nodes) {
			System.out.println("Vertex " + v.getVertex() + ":");
			for (Edge e : v.getEdges()) {
				System.out.println("=> Dest. Vertex: " + e.getDestVertex().getVertex() + ", Weight: " + e.getWeight());
			}
			System.out.println();
		}
	}

	public boolean isConnected() {
		HashSet<Node> visitedNodes = dfs(startNode);
		if (visitedNodes.size() == nodes.size()) {
			return true;
		}
		return false;
	}

	public HashSet<Node> reachable(String vertex) {
		Node node = getNodeFromVertex(vertex);
		if (null != node) {
			return dfs(node);
		}
		return null;
	}

	public ArrayList<Edge> minSpanningTree() {
		HashSet<Node> visitedNodes = new HashSet<Node>();
		ArrayList<Edge> edgesInMST = new ArrayList<Edge>();

		HashMap<String, String> parents = new HashMap<String, String>();
		for (Node node : nodes) {
			parents.put(node.getVertex(), node.getVertex());
		}

		Node firstNode = startNode;
		PriorityQueue<Edge> edgeQueue = new PriorityQueue<Edge>();
		for (Edge edge : firstNode.getEdges()) {
			edgeQueue.add(edge);
		}

		Node secondNode;
		int nodesInMST = 1;
		visitedNodes.add(firstNode);
		while (nodesInMST < nodes.size() && !edgeQueue.isEmpty()) {
			Edge minWeightEdge = edgeQueue.poll();
			firstNode = minWeightEdge.getSourceVertex();
			secondNode = minWeightEdge.getDestVertex();

			String firstNodeParent = getParent(firstNode.getVertex(), parents);
			String secondNodeParent = getParent(secondNode.getVertex(), parents);

			if (!firstNodeParent.equals(secondNodeParent)) {
				edgesInMST.add(minWeightEdge);

				if (!visitedNodes.contains(firstNode)) {
					visitedNodes.add(firstNode);

					for (Edge edge : firstNode.getEdges()) {
						edgeQueue.add(edge);
					}
				}

				if (!visitedNodes.contains(secondNode)) {
					visitedNodes.add(secondNode);

					for (Edge edge : secondNode.getEdges()) {
						edgeQueue.add(edge);
					}
				}

				unionVertices(firstNodeParent, secondNodeParent, parents);
				nodesInMST++;
			}
		}
		if (nodesInMST != nodes.size()) {
			return null;
		}
		return edgesInMST;
	}

	public ArrayList<Edge> shortestPath(String source, String dest) {
		Node sourceVertex = getNodeFromVertex(source);
		Node destVertex = getNodeFromVertex(dest);

		if (null == sourceVertex || null == destVertex) {
			return null;
		}

		ArrayList<Edge> shortestPathEdges = new ArrayList<Edge>();
		HashMap<String, String> parents = new HashMap<String, String>();
		HashMap<String, Edge> edgeFromParent = new HashMap<String, Edge>();
		HashSet<String> visitedVertices = new HashSet<String>();

		HashMap<String, Integer> cost = new HashMap<String, Integer>();
		for (Node node : nodes) {
			cost.put(node.getVertex(), Integer.MAX_VALUE);
		}

		String initialVertex = sourceVertex.getVertex();
		cost.put(initialVertex, 0);
		parents.put(initialVertex, initialVertex);

		while (initialVertex != destVertex.getVertex()) {
			visitedVertices.add(initialVertex);
			int initialVertexCost = cost.get(initialVertex);

			for (Edge edge : sourceVertex.getEdges()) {
				Node otherVertex = edge.getDestVertex();

				if (!visitedVertices.contains(otherVertex.getVertex())
						&& initialVertexCost + edge.getWeight() < cost.get(otherVertex.getVertex())) {
					parents.put(otherVertex.getVertex(), initialVertex);
					cost.put(otherVertex.getVertex(), initialVertexCost + edge.getWeight());
					edgeFromParent.put(otherVertex.getVertex(), edge);
				}
			}

			initialVertex = minCodeVertex(cost, visitedVertices);
			if (null == initialVertex) {
				return null;
			}
			sourceVertex = getNodeFromVertex(initialVertex);
		}

		while (!initialVertex.equals(source)) {
			shortestPathEdges.add(edgeFromParent.get(initialVertex));
			initialVertex = parents.get(initialVertex);
		}

		return shortestPathEdges;
	}

	private String minCodeVertex(HashMap<String, Integer> cost, HashSet<String> visitedVertices) {
		int minCost = Integer.MAX_VALUE;
		String minCostVertex = null;

		for (Node node : nodes) {
			String vertex = node.getVertex();
			if (!visitedVertices.contains(vertex) && cost.get(vertex) < minCost) {
				minCost = cost.get(vertex);
				minCostVertex = vertex;
			}
		}

		return minCostVertex;
	}

	/**
	 * Finds the node with a given name of vertex.
	 * 
	 * @param vertex Name of the node.
	 * @return Node The node with the given name.
	 */
	private Node getNodeFromVertex(String vertex) {
		for (Node node : nodes) {
			if (node.getVertex().equals(vertex)) {
				return node;
			}
		}
		return null;
	}

	/**
	 * Depth First Search to find connectivity of graph.
	 * 
	 * @param startNode The starting node for DFS.
	 * @return HashSet<Node> Set of all the traversed node.
	 */
	private HashSet<Node> dfs(Node startNode) {
		Stack<Node> nodesToVisit = new Stack<Node>();
		HashSet<Node> visitedNodes = new HashSet<Node>();
		Node currentNode = startNode;

		nodesToVisit.push(currentNode);

		while (!nodesToVisit.isEmpty()) {
			currentNode = nodesToVisit.pop();
			visitedNodes.add(currentNode);

			for (Edge edge : currentNode.getEdges()) {
				if (!visitedNodes.contains(edge.getDestVertex())) {
					nodesToVisit.push(edge.getDestVertex());
				}
			}
		}

		return visitedNodes;
	}

	/**
	 * Part of Union Set Algorithm.<br>
	 * Finds the parent of a given vertex.
	 * 
	 * @param vertex  The vertex whose parent needs to be found.
	 * @param parents HashMap of all the vertices and their parents.
	 * @return String The name of parent of given vertex.
	 */
	private String getParent(String vertex, HashMap<String, String> parents) {
		while (!vertex.equals(parents.get(vertex))) {
			vertex = parents.get(vertex);
		}
		return vertex;
	}

	/**
	 * Part of Union Set Algorithm.<br>
	 * Replaces the parent of one of the vertices.
	 * 
	 * @param firstNodeParent  Parent of first node.
	 * @param secondNodeParent Parent of second node.
	 * @param parents          HashMap of all vertices and their parents.
	 */
	private void unionVertices(String firstNodeParent, String secondNodeParent, HashMap<String, String> parents) {
		parents.put(firstNodeParent, secondNodeParent);
	}
}
