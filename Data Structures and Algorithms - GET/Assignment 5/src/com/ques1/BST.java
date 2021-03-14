package com.ques1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;

/**
 * Implements a BST (Binary Search Tree) to provide methods to add, delete and
 * get values to/from dictionary.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-10
 */
public class BST implements DictionaryInterface {
	private Node root;
	private static boolean isDeleted = true;
	private static boolean isAdded = true;
	private static List<Node> sortedList;

	/**
	 * Class containing left and right child of current node and key-value pair.
	 */
	public static class Node {
		String key, value;
		Node left, right;

		public Node(String key, String value) {
			this.key = key;
			this.value = value;
		}
	}

	// Default Constructor
	public BST() {
		root = null;
	}

	// Parameterized Constructor
	public BST(String jsonString) {
		// decoding JSON string into JSON object
		JSONObject obj = new JSONObject(jsonString.trim());
		@SuppressWarnings("unchecked")
		Iterator<String> keys = obj.keys();

		// adding these key-value pairs to dictionary
		root = null;
		while (keys.hasNext()) {
			String key = keys.next();
			add(key, obj.getString(key));
		}
	}

	public boolean add(String key, String value) {
		root = addKey(root, key, value);
		if (isAdded) {
			return true;
		} else {
			isAdded = true;
			return false;
		}
	}

	public boolean delete(String key) {
		root = deleteKey(root, key);
		if (isDeleted) {
			return true;
		} else {
			isDeleted = true;
			return false;
		}
	}

	public String getValue(String key) {
		Node node = searchKey(root, key);
		String value = null;
		if (null != node) {
			value = node.value;
		}
		return value;
	}

	public List<Node> sorted() {
		sortedList = new ArrayList<Node>();
		inorderTraversal(root);
		return sortedList;
	}

	public List<Node> sorted(String k1, String k2) {
		sortedList = new ArrayList<Node>();
		rangedInorderTraversal(root, k1, k2);
		return sortedList;
	}

	/**
	 * This method runs recursively to add a new key-value pair to dictionary.
	 */
	private static Node addKey(Node root, String key, String value) {
		if (root == null) {
			root = new Node(key, value);
			return root;
		}

		if (key.compareToIgnoreCase(root.key) < 0) {
			root.left = addKey(root.left, key, value);
		} else if (key.compareToIgnoreCase(root.key) > 0) {
			root.right = addKey(root.right, key, value);
		} else {
			isAdded = false;
		}

		return root;
	}

	/**
	 * This method runs recursively to traverse dictionary items.
	 */
	private static void inorderTraversal(Node root) {
		if (null != root) {
			inorderTraversal(root.left);
			sortedList.add(root);
			inorderTraversal(root.right);
		}
	}

	/**
	 * This method runs recursively to search a key-value pair from dictionary.
	 */
	private static Node searchKey(Node root, String key) {
		if (null == root || root.key.equals(key)) {
			return root;
		}

		if (root.key.compareToIgnoreCase(key) < 0) {
			return searchKey(root.right, key);
		}

		return searchKey(root.left, key);
	}

	/**
	 * This method runs recursively to delete a key-value pair from dictionary (if
	 * exists).
	 */
	private static Node deleteKey(Node root, String key) {
		if (null == root) {
			isDeleted = false;
			return root;
		}

		if (key.compareToIgnoreCase(root.key) < 0) {
			root.left = deleteKey(root.left, key);
		} else if (key.compareToIgnoreCase(root.key) > 0) {
			root.right = deleteKey(root.right, key);
		} else {
			if (null == root.left) {
				return root.right;
			} else if (null == root.right) {
				return root.left;
			}

			Node temp = minValue(root.right);
			root.key = temp.key;
			root.value = temp.value;

			root.right = deleteKey(root.right, root.key);
		}

		return root;
	}

	/**
	 * This method finds the node with minimum value from right sub-tree (used to
	 * replace the deleted node).
	 */
	private static Node minValue(Node root) {
		while (null != root.left) {
			root = root.left;
		}
		return root;
	}

	/**
	 * This method runs recursively to traverse dictionary items which lie between a
	 * range (>=k1 and <=k2).
	 */
	private static void rangedInorderTraversal(Node root, String k1, String k2) {
		if (null != root) {
			rangedInorderTraversal(root.left, k1, k2);
			if (root.key.compareToIgnoreCase(k1) >= 0 && root.key.compareToIgnoreCase(k2) <= 0) {
				sortedList.add(root);
			}
			rangedInorderTraversal(root.right, k1, k2);
		}
	}
}
