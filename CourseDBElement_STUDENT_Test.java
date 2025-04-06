import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseDBElement_STUDENT_Test {
	
	private CourseDBElement course1, course2;

	@BeforeEach
	void setUp() throws Exception {
		course1 = new CourseDBElement("CMSC100", 22154, 3, "SW201", "Bob Bob");
		course2 = new CourseDBElement("CMSC204", 22254, 4, "SW403", "Joe Joe");
	}

	@AfterEach
	void tearDown() throws Exception {
		course1 = null;
		course2 = null;
	}

	@Test
	void testHashCode() {
		assertNotEquals(course1.hashCode(), course2.hashCode());
	}


	@Test
	void testCompareTo() {
		assertEquals(-1, course1.compareTo(course2));
		
		assertTrue(course1.compareTo(course2) < 0);
	}

	@Test
	void testToString() {
		assertEquals("\nCourse:CMSC100 CRN:22154 Credits:3 Instructor:Bob Bob Room:SW201", course1.toString());
	}


}
