import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	
	GradeBook GB1;
	GradeBook GB2;

	@BeforeEach
	void setUp() throws Exception {
		
		GB1 = new GradeBook(5);
		GB2 = new GradeBook(5);
		
		GB1.addScore(98.0);
		GB1.addScore(93.0);
		
		
		GB2.addScore(76.0);
		GB2.addScore(81.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		
		GB1 = null;
		GB2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(GB1.toString().equals("98.0 93.0"));
		assertTrue(GB2.toString().equals("76.0 81.0"));	
	}

	@Test
	void testSum() {
		assertEquals(191.0, GB1.sum(), .0001);
		assertEquals(157.0, GB2.sum(), .0001);
	}

	@Test
	void testMinimum() {
		assertEquals(93.0, GB1.minimum(), .0001);
		assertEquals(76.0, GB2.minimum(), .0001);
	}

	@Test
	void testFinalScore() {
		assertEquals(98.0, GB1.finalScore(), .0001);
		assertEquals(81.0, GB2.finalScore(), .0001);
	}

}
