package com.queue;

/**
 * This interface supports methods for queue implementation.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-06
 */
public interface Queue<T> {
	/**
	 * This method inserts a new element in the queue.
	 * 
	 * @param element Integer to insert in the queue.
	 * @return boolean True is insertion successful, False otherwise.
	 */
	public boolean enQueue(T element);

	/**
	 * This method removes an element from the queue.
	 * 
	 * @return Integer Element that is removed.
	 */
	public T deQueue();

	/**
	 * This method finds if the queue is empty.
	 * 
	 * @return boolean True if queue is empty, False otherwise.
	 */
	public boolean isEmpty();

	/**
	 * This method find if the queue is full.
	 * 
	 * @return boolean True if queue if full, False otherwise.
	 */
	public boolean isFull();
}
