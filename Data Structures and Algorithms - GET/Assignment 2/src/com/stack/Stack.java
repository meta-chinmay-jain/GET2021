package com.stack;

/**
 * This class implements stack interface to provide stack operations.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-07
 */
public class Stack implements StackInterface {
	private static final int SIZE = 50;
	private int top;
	private String stack[] = new String[SIZE];

	// Default constructor
	public Stack() {
		top = -1;
	}

	/**
	 * This method adds an element into stack.
	 */
	public boolean push(String str) {
		if (top >= (SIZE - 1)) {
			return false;
		} else {
			stack[++top] = str;
			return true;
		}
	}

	/**
	 * This method removes an element from stack.
	 */
	public String pop() {
		if (isEmpty()) {
			return null;
		} else {
			String str = stack[top--];
			return str;
		}
	}

	/**
	 * This method gets the top element from stack.
	 */
	public String peek() {
		if (isEmpty()) {
			return null;
		} else {
			String str = stack[top];
			return str;
		}
	}

	/**
	 * Checks if stack is empty.
	 * 
	 * @return boolean True if stack is empty, False otherwise
	 */
	public boolean isEmpty() {
		return (top < 0);
	}
}
