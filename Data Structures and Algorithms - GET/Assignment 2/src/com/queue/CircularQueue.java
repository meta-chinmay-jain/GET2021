package com.queue;

/**
 * This class represents circular implementation of the queue.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-06
 */
public class CircularQueue<T> implements Queue<T> {
	private int size;
	private int front;
	private int rear;
	private Object[] queue;

	// Constructor
	public CircularQueue(int size) {
		this.size = size;
		this.front = -1;
		this.rear = -1;
		this.queue = new Object[size];
	}

	/**
	 * This method inserts a new element in the queue.
	 */
	@SuppressWarnings("unchecked")
	public boolean enQueue(Object element) {
		if (null == element) {
			return false;
		}

		if (isFull()) {
			return false;
		} else if (isEmpty()) {
			front = 0;
			rear = 0;
			queue[rear] = (T) element;
		} else if (rear == size - 1 && front != 0) {
			rear = 0;
			queue[rear] = (T) element;
		} else {
			queue[++rear] = (T) element;
		}

		return true;
	}

	/**
	 * This method removes an element from the queue.
	 */
	public T deQueue() {
		if (isEmpty()) {
			return null;
		}

		@SuppressWarnings("unchecked")
		T element = (T) queue[front];

		if (front == rear) {
			front = -1;
			rear = -1;
		} else if (front == size - 1) {
			front = 0;
		} else {
			front++;
		}

		return (T) element;
	}

	/**
	 * This method finds if the queue is empty.
	 */
	public boolean isEmpty() {
		if (front == -1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method find if the queue is full.
	 */
	public boolean isFull() {
		if ((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method displays the whole queue.
	 */
	public void display() {
		if (isEmpty()) {
			System.out.println("\nQueue is Empty!");
			return;
		}
		System.out.println("\nElements in the Queue are: ");
		if (rear >= front) {
			for (int i = front; i <= rear; i++) {
				System.out.print(queue[i] + " ");
			}
		} else {
			for (int i = front; i < size; i++) {
				System.out.print(queue[i] + " ");
			}
			for (int i = 0; i <= rear; i++) {
				System.out.print(queue[i] + " ");
			}
		}
		System.out.println();
	}
}
