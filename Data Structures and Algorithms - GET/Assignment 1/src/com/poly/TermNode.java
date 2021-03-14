package com.poly;

/**
 * This class is used to define the structure of a single Node of outer Linked
 * List for polynomial representation.
 */
public class TermNode {
	TermNode next;
	VarList varList;
	int coefficient;

	public TermNode(int coefficient) {
		this.coefficient = coefficient;
		this.varList = new VarList();
		this.next = null;
	}
}
