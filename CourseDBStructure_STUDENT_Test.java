import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseDBStructure_STUDENT_Test {

	private CourseDBStructure dbStructure;
	@BeforeEach
	void setUp() throws Exception {
		dbStructure = new CourseDBStructure(10);
	}

	@AfterEach
	void tearDown() throws Exception {
		dbStructure = null;
	}


	@Test
	void testAdd() {
		CourseDBElement course = new CourseDBElement("CMSC204", 21245, 4, "SW217", "Billy Joe");
		dbStructure.add(course);
		
		try {
			CourseDBElement getCourse = dbStructure.get(21245);
			assertEquals(course, getCourse);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Test
	void testGet() {
		try {
			dbStructure.get(12345);
			fail("Course doesn't exist");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testShowAll() {
		CourseDBElement course1 = new CourseDBElement("CMSC100", 11111, 3, "SW100", "Bob");
		CourseDBElement course2 = new CourseDBElement("CMSC200", 22222, 4, "SW200", "Joe");
		
		dbStructure.add(course1);
		dbStructure.add(course2);
		
		ArrayList<String> courses = dbStructure.showAll();
		assertTrue(courses.size()==2);
		
		assertEquals(11111, course1.getCRN());
		assertEquals("CMSC200", course2.getID());
	}

	@Test
	void testGetTableSize() {
		assertEquals(7, dbStructure.getTableSize());
	}

}
