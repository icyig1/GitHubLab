/**
 * Ian Green
 * Professor Kuijt
 * 3/16/2025
 * CMSC 204 CRNN 31209
 * JUNIT Test
 */

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasicDoubleLinkedList_STUDENT_Test {

	private BasicDoubleLinkedList<Integer> list;
	@BeforeEach
	void setUp() throws Exception {
		list = new BasicDoubleLinkedList<>();
		list.addToFront(2);
		list.addToFront(1);
	}

	@AfterEach
	void tearDown() throws Exception {
		list = null;
	}

	@Test
	void testBasicDoubleLinkedList() {
		assertEquals(2, list.getSize());
	}

	@Test
	void testIterator() {
		BasicDoubleLinkedList<Integer>.DoubleLinkedListIterator iterator = list.iterator();
		
		assertTrue(iterator.hasNext());
		assertEquals(1, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(2, iterator.next());
		assertFalse(iterator.hasNext());
	}

	@Test
	void testAddToFront() {
		list.addToFront(0);	
		assertEquals(0, list.getFirst());
		list.addToFront(1);
		assertEquals(1, list.getFirst());
	}

	@Test
	void testAddToEnd() {
		list.addToEnd(4);
		assertEquals(4, list.getLast());
		list.addToEnd(3);
		assertEquals(3, list.getLast());
	}

	@Test
	void testGetSize() {
		assertEquals(2, list.getSize());
		list.addToFront(3);
		
		assertEquals(3, list.getSize());
	}

	@Test
	void testToArrayList() {
		list.addToFront(1);
        list.addToEnd(2);
        list.addToEnd(3);
        ArrayList<Integer> arrayList = list.toArrayList();

        assertEquals(5, arrayList.size());
        assertEquals(1, arrayList.get(0));
        assertEquals(1, arrayList.get(1));
        assertEquals(2, arrayList.get(2));
	}

	@Test
	void testGetFirst() {
		list.addToFront(0);
		assertEquals(0, list.getFirst());
		list.addToFront(1);
		assertEquals(1, list.getFirst());
	}

	@Test
	void testGetLast() {
		list.addToEnd(4);	
		assertEquals(4, list.getLast());
		list.addToEnd(3);
		assertEquals(3, list.getLast());
	}


	@Test
	void testRetrieveFirstElement() {
		list.addToFront(1);
	    list.addToEnd(2);
	    assertEquals(1, list.retrieveFirstElement());
	    assertEquals(3, list.getSize());
	}

	@Test
	void testRetrieveLastElement() {
		list.addToFront(1);
	    list.addToEnd(2);
	    assertEquals(2, list.retrieveLastElement());
	    assertEquals(3, list.getSize());
	}

}
