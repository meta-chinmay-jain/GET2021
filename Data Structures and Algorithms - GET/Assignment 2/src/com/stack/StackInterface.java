package com.stack;

/**
 * This interface supports methods for stack implementation.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-07
 */
public interface StackInterface {
	/**
	 * This method adds an element into stack.
	 * 
	 * @param str Element to be added into stack.
	 * @return boolean True if element added successfully, False otherwise.
	 */
	public boolean push(String str);

	/**
	 * This method removes an element from stack.
	 * 
	 * @return T Value that is removed from stack.
	 */
	public String pop();

	/**
	 * This method gets the top element from stack.
	 * 
	 * @return T Value that is at the top of stack.
	 */
	public String peek();
}
