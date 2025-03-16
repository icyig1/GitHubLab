/**
 * Ian Green
 * Professor Kuijt
 * 3/16/2025
 * CMSC 204 CRNN 31209
 * This class creates a double linked list that is iterable
 */

import java.util.*;

public class BasicDoubleLinkedList<T> implements Iterable<T> {

	/**
	 * Creates node class
	 */
	protected  class Node {
		T data;
		Node next;
		Node prev;
		
		public Node(T data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	
	protected class DoubleLinkedListIterator implements ListIterator<T>{
		private Node current;
		private Node previous;
		
		DoubleLinkedListIterator() {
			current = head;
			previous = null;
		}
		/**
		 * Returns true if there is a next position
		 */
		@Override
		public boolean hasNext() {
			return current != null;
		}
		/**
		 * Returns the value of next position
		 */
		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			T data = current.data;
			previous = current;
			current = current.next;
			return data;
			}
		/**
		 * Returns true if there is a previous position
		 */
		@Override
		public boolean hasPrevious() {
			return previous != null;
		}
		/**
		 * Returns the value of previous position
		 */
		@Override
		public T previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			T data = previous.data;
			current = previous;
			previous = previous.prev;
			return data;
		}
		//These methods return an exception and are not used in this project
		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		public void add(T e) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		public void add(int index, T e) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		public boolean contains(T e) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		public int nextIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		public int previousIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		public void set(T e) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		public void addToEnd(T data) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		public Iterator<T> iterator() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
	}
	
	
	protected Node head;
	protected Node tail;
	protected int size;
	
	
	public BasicDoubleLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	/**
	 * Creates an iterator of double linked list iterator object
	 */
	public DoubleLinkedListIterator iterator() {
		return new DoubleLinkedListIterator();
	}
	
	/**
	 * 
	 * @param data that is an object the user is adding to the front of the linked list
	 */
	public void addToFront(T data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		size++;
	}
	
	/**
	 * 
	 * @param data that is an object the user is adding to the end of the linked list
	 */
	public void addToEnd(T data) {
		Node newNode = new Node(data);
		if(tail == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}
	
	/**
	 * 
	 * @return an integer of the size of linked list
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * 
	 * @return an array list of the linked list
	 */
	public ArrayList<T> toArrayList() {
		ArrayList<T> result = new ArrayList<>();
		Node current = head;
		
		while (current != null) {
			result.add(current.data);
			current = current.next;
		}
		return result;
	}
	
	/**
	 * 
	 * @return the data value of the first object in the linked list and removes it
	 */
	public T getFirst() {
		if (head == null) {
			throw new NoSuchElementException();
		}
		return head.data;
	}
	/**
	 * 
	 * @return the data value of the last object in the linked list and removes it
	 */
	public T getLast() {
		if (head == null || tail == null) {
			throw new NoSuchElementException();
		}
		return tail.data;
	}
	
	/**
	 * 
	 * @param data is a object 
	 * @param comparator compares two values
	 * @return true if the object was in the linked list and successfully removed
	 */
	public boolean remove(T data, Comparator<T> comparator) {
        if (head == null) {
            return false; 
        }
        Node current = head;

        while (current != null) {
            if (comparator.compare(current.data, data) == 0) { 
                if (current == head) { 
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    } else { 
                        tail = null;
                    }
                } else if (current == tail) { 
                    tail = tail.prev;
                    tail.next = null;
                } else { 
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }

                size--; 
                return true;  
            }
            current = current.next;
        }

        return false;  
    }

	/**
	 * 
	 * @return the first element in the linked list
	 */
	public T retrieveFirstElement() {
		if (head == null) {
			throw new NoSuchElementException();
		}
		
		T data = head.data;
		if (head == tail) {
			head = null;
			tail = null;
		} else {
			head = head.next;
			head.prev = null;
		}
		size--;
		return data;
	}
	/**
	 * 
	 * @return the last element in the linked list
	 */
	public T retrieveLastElement() {
		if (tail == null) {
			throw new NoSuchElementException();
		}
		
		T data = tail.data;
		
		if (head == tail) {
			head = null;
			tail = null;
		} else {
			tail = tail.prev;
			tail.next = null;
		}
		size--;
		return data;
	}
	
}
