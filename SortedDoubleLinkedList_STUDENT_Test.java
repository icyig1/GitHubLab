/**
 * Ian Green
 * Professor Kuijt
 * 3/16/2025
 * CMSC 204 CRNN 31209
 * This is a JUNIT test
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
class SortedDoubleLinkedList_STUDENT_Test {

	private SortedDoubleLinkedList<Integer> sortedList;
	
	private Comparator<Integer> comparator = Integer::compareTo;
	@BeforeEach
	void setUp() throws Exception {
		sortedList = new SortedDoubleLinkedList<>(comparator);
		sortedList.add(0);
		sortedList.add(1);
	}

	@AfterEach
	void tearDown() throws Exception {
		sortedList = null;
	}

	@Test
	void testToArrayList() {
	    sortedList.add(7);
        sortedList.add(6);

        ArrayList<Integer> list = sortedList.toArrayList();
        assertEquals(4, list.size());
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
	}

	@Test
	void testGetFirst() {
		sortedList.add(2);
		sortedList.add(10);
		assertEquals(0, sortedList.getFirst());
	}

	@Test
	void testGetLast() {
		sortedList.add(5);
		sortedList.add(9);
		assertEquals(9, sortedList.getLast());
	}


	@Test
	void testRetrieveFirstElement() {
	     sortedList.add(5);
	        sortedList.add(1);
	        sortedList.add(3);

	        assertEquals(0, sortedList.retrieveFirstElement());
	        assertEquals(4, sortedList.size());
	}

	@Test
	void testRetrieveLastElement() {
	    sortedList.add(5);
        sortedList.add(1);
        sortedList.add(3);

        assertEquals(5, sortedList.retrieveLastElement());
        assertEquals(4, sortedList.size());
	}


	@Test
	void testAdd() {
		sortedList.add(2);
		sortedList.add(3);
		assertEquals(4, sortedList.size());
		assertEquals(3, sortedList.getLast());
	}

	@Test
	void testSize() {
		assertEquals(2, sortedList.getSize());
	}

}
