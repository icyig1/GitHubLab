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

public class MyStackTest {
	public MyStack<String> stringS;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleS
	public MyStack<Double> doubleS;
	// STUDENT: add variables as needed for your student tests
	public Double one = 1.0, two = 2.0, three = 3.0, four = 4.0, five = 5.0;
	
	@BeforeEach
	public void setUp() throws Exception {
		stringS = new MyStack<String>(5);
		stringS.push(a);
		stringS.push(b);
		stringS.push(c);
		
		//STUDENT: add setup for doubleS for student tests
		doubleS = new MyStack<Double>(5);
		doubleS.push(one);
		doubleS.push(two);
		doubleS.push(three);
	}

	@AfterEach
	public void tearDown() throws Exception {
		stringS = null;
		doubleS = null;
	}

	@Test
	public void testIsEmpty() {
		assertEquals(false,stringS.isEmpty());
		try {
		stringS.pop();
		stringS.pop();
		stringS.pop();
		} catch (StackUnderflowException e) {
			fail("StackUnderflowexception shouldn't happen");
		}
		assertEquals(true, stringS.isEmpty());
	}

	@Test
	public void testIsFull() throws StackOverflowException {
		assertEquals(false, stringS.isFull());
		stringS.push(d);
		stringS.push(e);
		assertEquals(false, stringS.isFull());
	}

	@Test
	public void testPop() {
		try {
			assertEquals(c, stringS.pop());
			assertEquals(b, stringS.pop());
			assertEquals(a, stringS.pop());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringS.pop();
			assertTrue("This should have caused an StackUnderflowException", false);
		}
		catch (StackUnderflowException e){
			assertTrue("This should have caused an StackUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackUnderflowException", false);
		}
	}

	@Test
	public void testPopStudent() {
		//Use the doubleQ for student tests
		try {
			assertEquals(three, doubleS.pop(), 0.001);
			assertEquals(two, doubleS.pop(), 0.001);
			assertEquals(one, doubleS.pop(), 0.001);
			doubleS.pop();
			fail("This should have caused an StackUnderflowException");
		} catch (StackUnderflowException e) {
			assertTrue("This should have caused an StackUnderflowException", true);
		} catch (Exception e) {
			fail ("This should have caused an StackUnderflowException");
		}
	}
	
	@Test
	public void testTop() throws StackOverflowException {
		try {
		assertEquals(c, stringS.top());
		stringS.push(d);
		assertEquals(d, stringS.top());
		stringS.pop();
		stringS.pop();
		assertEquals(b, stringS.top());	
		} catch (StackUnderflowException e) {
			fail("StackUnerflowException should not occur here");
		}
	}

	@Test
	public void testSize() throws StackOverflowException, StackUnderflowException {
		assertEquals(3, stringS.size());
		stringS.push(d);
		assertEquals(4, stringS.size());
		stringS.pop();
		stringS.pop();
		assertEquals(2, stringS.size());
	}

	@Test
	public void testPush() {
		try {
			assertEquals(3, stringS.size());
			assertEquals(true, stringS.push(d));
			assertEquals(4, stringS.size());
			assertEquals(true, stringS.push(e));
			assertEquals(5, stringS.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringS.push(f);
			assertTrue("This should have caused an StackOverflowException", true);
		}
		catch (StackOverflowException e){
			assertTrue("This should have caused an StackOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackOverflowException", false);
		}
	}

	@Test
	public void testPushStudent() {
		//Use the doubleQ for student tests
		try {
			assertEquals(3, doubleS.size());
			assertTrue(doubleS.push(four));
			assertEquals(4, doubleS.size());
			assertTrue(doubleS.push(five));
			assertEquals(5, doubleS.size());
			doubleS.push(four);
			assertTrue("This should have caused an StackOverflowException", true);
		} catch (StackOverflowException e) {
			assertTrue("This should have caused an StackOverflowException", true);
		} catch (Exception e) {
			fail("This should have caused an StackOverflowException");
		}
	}
	
	@Test
	public void testToString() throws StackOverflowException {
		assertEquals("cba", stringS.toString());
		stringS.push(d);
		assertEquals("dcba", stringS.toString());
		stringS.push(e);
		assertEquals("edcba", stringS.toString());
	}

	@Test
	public void testToStringStudent() throws StackOverflowException {
		//Use the doubleQ for student tests
		assertEquals("3.02.01.0", doubleS.toString());
		doubleS.push(four);
		assertEquals("4.03.02.01.0", doubleS.toString());
	}
	
	@Test
	public void testToStringDelimiter() throws StackOverflowException {
		assertEquals("c%b%a", stringS.toString("%"));
		stringS.push(d);
		assertEquals("d&c&b&a", stringS.toString("&"));
		stringS.push(e);
		assertEquals("e/d/c/b/a", stringS.toString("/"));
	}

	@Test
	public void testFill() throws StackUnderflowException {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringS = new MyStack<String>(5);
		//fill with an ArrayList
		stringS.fill(fill);
		assertEquals(3,stringS.size());
		assertEquals("carrot", stringS.pop());
		assertEquals("banana", stringS.pop());
		assertEquals("apple", stringS.pop());		
	}

}
