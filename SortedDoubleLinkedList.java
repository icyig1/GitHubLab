/**
 * Ian Green
 * Professor Kuijt
 * 3/16/2025
 * CMSC 204 CRNN 31209
 * This class sorts the double linked list
 */

import java.util.*;


public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	private Comparator<T> comparator;
	
	public SortedDoubleLinkedList(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}
	
	/**
	 * 
	 * @param data object the user wants to add to the linked list
	 */
	public void add(T data) {
		Node newNode = new Node(data);
		
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			Node current = head;
			while (current != null && comparator.compare(current.data, data) < 0) {
				current = current.next;
			}
			
			if (current == null) {
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			} else if (current == head) {
				newNode.next = head;
				head.prev = newNode;
				head = newNode;
			} else {
				newNode.prev = current.prev;
				newNode.next = current;
				current.prev.next = newNode;
				current.prev = newNode;
			}
		}
		size++;
	}
	public int size() {
		return size;
	}
	
	public ArrayList<T> toArrayList() {
		ArrayList<T> result = new ArrayList<>();
		Node current = head;
		while (current != null) {
			result.add(current.data);
			current = current.next;
		}
		return result;
	}
	
	public T getFirst() {
		if (head == null) {
			throw new NoSuchElementException();
		}
		return head.data;
	}
	public T getLast() {
		if (tail == null) {
			throw new NoSuchElementException();
		}
		return tail.data;
	}
	
	@Override
	public void addToFront(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	@Override
	public void addToEnd(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
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
