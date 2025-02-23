/**
 * Ian Green
 * Professor Kuijt
 * 2/22/2025
 * CMSC 204 CRNN 31209
 */
import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T>{
	private class Node {
		T data;
		Node next;
	}
	
	private Node head, tail;
	private int size;
	
	public MyQueue(int size) {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public MyQueue() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	public boolean isFull() {
		return size >= Integer.MAX_VALUE;
	}
	public T dequeue() throws QueueUnderflowException {
	    if (isEmpty()) {
	        throw new QueueUnderflowException("Queue is empty");
	    }
	    T data = head.data;
	    head = head.next;
	    if (head == null) {
	        tail = null;
	    }
	    size--;
	    return data;
	}
	public int size() {
		return size;
	}
	public boolean enqueue(T e) throws QueueOverflowException {
		if (isFull() ) {
			throw new QueueOverflowException("Queue is full");
		}
		Node newNode = new Node();
		newNode.data = e;
		newNode.next = null;
		if(tail == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node current = head;
		while (current != null) {
			sb.append(current.data);
			current = current.next;
		}
		return sb.toString();
	}
	public String toString(String delimiter) {
		StringBuilder sb = new StringBuilder();
		Node current = head;
		while (current != null) {
			sb.append(current.data);
			if (current.next != null) {
				sb.append(delimiter);
			}
			current = current.next;
		}
		return sb.toString();
	}
	public void fill(ArrayList<T> list) {
		for (T item : list) {
				try {
					enqueue(item);
				} catch (QueueOverflowException e) {
					System.out.println(e);
				}

		}
	}
}
