/**
 * Ian Green
 * Professor Kuijt
 * 2/22/2025
 * CMSC 204 CRNN 31209
 */
import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T>{
	
	private class Node {
		T data;
		Node next;
	}
	private Node head;
	private int size;
	
	public MyStack(int size) {
		this.head = null;
		this.size = 0;
	}
	public MyStack() {
		this.head = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	public boolean isFull() {
		return false;
	}
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException("Stack is empty");
		}
		T data = head.data;
		head = head.next;
		size--;
		return data;
	}
	public T top() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException("Stack is empty");
		}
		return head.data;
	}
	public int size() {
		return size;
	}
	public boolean push (T e) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException("Stack is full");
		}
		Node newNode = new Node();
		newNode.data = e;
		newNode.next = head;
		head = newNode;
		size++;
		return true;
	}
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
				push(item);
			} catch (StackOverflowException e) {
				System.out.println(e);
			}
		}
	}
}
