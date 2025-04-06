import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseDBManager_STUDENT_Test {
	
	private CourseDBManager dbMgr;

	@BeforeEach
	void setUp() throws Exception {
		dbMgr = new CourseDBManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		dbMgr = null;
	}

	@Test
	void testAdd() {
		String courseID = "CMSC204";
		int crn = 22153;
		int credits = 4;
		String roomNum = "SW217";
		String instructor = "Bobby";
		
		dbMgr.add(courseID, crn, credits, roomNum, instructor);
		CourseDBElement course = dbMgr.get(crn);
		assertEquals(courseID, course.getID());
		assertEquals(crn, course.getCRN());
		assertEquals(credits, course.getCredits());
		assertEquals(roomNum, course.getRoomNum());
		assertEquals(instructor, course.getInstructor());
	}


	@Test
	void testReadFile() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC203 30504 4 SC450 Joey Bag-O-Donuts");
			inFile.print("CMSC204 30503 4 SC450 Jill B. Who-Dunit");
			
			inFile.close();
			dbMgr.readFile(inputFile);
			assertEquals("CMSC203",dbMgr.get(30504).getID());
			assertEquals("CMSC204",dbMgr.get(30503).getID());
			assertEquals("SC450",dbMgr.get(30503).getRoomNum());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}

	@Test
	void testShowAll() {
		dbMgr.add("CMSC204", 22124, 4, "SW212", "Bob");
		dbMgr.add("CMSC207", 25432, 4, "Distance-Learning", "Joe");
		ArrayList<String> list = dbMgr.showAll();
		assertEquals(list.get(0),"\nCourse:CMSC204 CRN:22124 Credits:4 Instructor:Bob Room:SW212");
		assertEquals(list.get(1),"\nCourse:CMSC207 CRN:25432 Credits:4 Instructor:Joe Room:Distance-Learning");
		
	}

}
