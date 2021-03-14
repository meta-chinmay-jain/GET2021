package com.ques1;

import java.util.List;

import com.ques1.BST.Node;

/**
 * Interface for a Dictionary.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-10
 */
public interface DictionaryInterface {
	/**
	 * This method adds a new key-value pair in Dictionary.
	 * 
	 * @param key   Word to be added.
	 * @param value Meaning of the word.
	 * @return boolean True if added successfully, False if already present.
	 */
	public boolean add(String key, String value);

	/**
	 * This method deletes a key-value pair from Dictionary (if exists).
	 * 
	 * @param key Word to be deleted.
	 * @return boolean True if deleted successfully, False if not found.
	 */
	public boolean delete(String key);

	/**
	 * This methods gets the value corresponding to a key in Dictionary.
	 * 
	 * @param key Word whose meaning needs to be searched.
	 * @return String Meaning of the given word.
	 */
	public String getValue(String key);

	/**
	 * This method prints the list of all entries of dictionary in ascending order.
	 * 
	 * @return List<Node> The list of sorted nodes.
	 */
	public List<Node> sorted();

	/**
	 * This method prints the list of all entries in ascending order lying between
	 * K1 and K2.
	 * 
	 * @param k1 Starting word of range.
	 * @param k2 Ending word of range.
	 * @return List<Node> The list of sorted nodes in a given range.
	 */
	public List<Node> sorted(String k1, String k2);
}
