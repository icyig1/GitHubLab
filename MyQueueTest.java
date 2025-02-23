/**
 * Ian Green
 * Professor Kuijt
 * 2/22/2025
 * CMSC 204 CRNN 31209
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class MyQueueTest {
	public MyQueue<String> stringQ;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleQ
	public MyQueue<Double> doubleQ;
	// STUDENT: add variables as needed for your student tests
	public Double first = 1.1, second = 2.3, third = 4.2;
	@BeforeEach
	public void setUp() throws Exception {
		stringQ = new MyQueue<String>(5);
		stringQ.enqueue(a);
		stringQ.enqueue(b);
		stringQ.enqueue(c);
		
		//STUDENT: add setup for doubleQ for student tests
		doubleQ = new MyQueue<Double>(5);
		doubleQ.enqueue(first);
		doubleQ.enqueue(second);
		doubleQ.enqueue(third);
	}

	@AfterEach
	public void tearDown() throws Exception {
		stringQ = null;
		doubleQ = null;
	}

	@Test
	public void testIsEmpty() throws QueueUnderflowException {
	    assertEquals(false, stringQ.isEmpty());
	    stringQ.dequeue();
	    stringQ.dequeue();
	    stringQ.dequeue();
	    assertEquals(true, stringQ.isEmpty());

	    try {
	        stringQ.dequeue();  
	        fail("This should have caused a QueueUnderflowException"); 
	    } catch (QueueUnderflowException e) {
	        assertTrue("QueueUnderflowException was thrown", true);
	    }
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(a, stringQ.dequeue());
			assertEquals(b, stringQ.dequeue());
			assertEquals(c, stringQ.dequeue());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringQ.dequeue();
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
		catch (QueueUnderflowException e){
			assertTrue("This should have caused an QueueUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
	}
	
	@Test
	public void testDequeueStudent() {
		//Use the doubleQ for student tests
		try {
			assertEquals(1.1, doubleQ.dequeue(), 0.001);
			assertEquals(2.3, doubleQ.dequeue(), 0.001);
			assertEquals(4.2, doubleQ.dequeue(), 0.001);
		} catch (QueueUnderflowException e) {
			assertTrue("This should have caused an QueueUnderflowException", true);
		}
	}

	@Test
	public void testSize() throws QueueUnderflowException, QueueOverflowException {
		assertEquals(3, stringQ.size());
		stringQ.enqueue(d);
		assertEquals(4, stringQ.size());
		stringQ.dequeue();
		stringQ.dequeue();
		assertEquals(2, stringQ.size());
	}

	@Test
	public void testEnqueue() {
		try {
			assertEquals(3, stringQ.size());
			assertEquals(true, stringQ.enqueue(d));
			assertEquals(4, stringQ.size());
			assertEquals(true, stringQ.enqueue(e));
			assertEquals(5, stringQ.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringQ.enqueue(f);
			assertTrue("This should have caused an QueueOverflowException", true);
		}
		catch (QueueOverflowException e){
			assertTrue("This should have caused an QueueOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueOverflowException", false);
		}
	}

	@Test
	public void testEnqueueStudent() {
		//Use the doubleQ for student tests
		try {
			assertEquals(true, doubleQ.enqueue(4.2));
			assertEquals(4, doubleQ.size());
			assertEquals(1.1, doubleQ.dequeue(), 0.001);
		} catch (QueueOverflowException e) {
			System.out.println(e);
		} catch (QueueUnderflowException e) {
			System.out.println(e);
		}
	}

	@Test
	public void testIsFull() throws QueueOverflowException {
		assertEquals(false, stringQ.isFull());
		stringQ.enqueue(d);
		stringQ.enqueue(e);
		assertEquals(false, stringQ.isFull());
	}

	@Test
	public void testToString() throws QueueOverflowException {
		assertEquals("abc", stringQ.toString());
		stringQ.enqueue(d);
		assertEquals("abcd", stringQ.toString());
		stringQ.enqueue(e);
		assertEquals("abcde", stringQ.toString());
	}
	
	@Test
	public void testToStringStudent() {
		//Use the doubleQ for student tests
		String result = doubleQ.toString();
		String expected = "1.12.34.2";
		assertEquals(expected, result);
	}

	@Test
	public void testToStringDelimiter() throws QueueOverflowException {
		assertEquals("a%b%c", stringQ.toString("%"));
		stringQ.enqueue(d);
		assertEquals("a&b&c&d", stringQ.toString("&"));
		stringQ.enqueue(e);
		assertEquals("a/b/c/d/e", stringQ.toString("/"));
	}

	@Test
	public void testFill() throws QueueUnderflowException {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringQ = new MyQueue<String>(5);
		//fill with an ArrayList
		stringQ.fill(fill);
		assertEquals(3,stringQ.size());
		assertEquals("apple", stringQ.dequeue());
		assertEquals("banana", stringQ.dequeue());
		assertEquals("carrot", stringQ.dequeue());		
	}

}
