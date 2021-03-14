package com.poly;

/**
 * This class is used to define the structure of a single Node of nested Linked
 * List for polynomial representation.
 */
public class VarNode {
	VarNode next;
	char varName;
	int power;

	public VarNode(char varName, int power) {
		this.varName = varName;
		this.power = power;
		this.next = null;
	}
}
