import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TownGraphManager_STUDENT_Test {
	
	TownGraphManager TGM;

	String town1;
	String town2;
	String town3;
	String town4;
	@Before
	public void setUp() throws Exception {
		TGM = new TownGraphManager();
		
		town1 = "Gaithersburg";
		town2 = "Rockville";
		town3 = "Silver Spring";
		town4 = "Clinton";

		TGM.addTown(town1);
		TGM.addTown(town2);
		TGM.addTown(town3);
		TGM.addTown(town4);
	
		
		TGM.addRoad(town1, town2, 3, "Shady Grove Road");
		TGM.addRoad(town1, town3, 8, "ICC 200");
		TGM.addRoad(town2, town3, 5, "Randolph Road");
		TGM.addRoad(town3, town4, 10, "I-495");

	}

	@After
	public void tearDown() throws Exception {
		town1 = town2 = town3 = town4 = null;
		TGM = null;
	}

	@Test
	public void testAddRoad() {
		TGM.addRoad(town4, town1, 200, "DNE");
		assertTrue(TGM.getRoad(town4, town1).equals("DNE"));
		
		
		TGM.addRoad(town2, town4, 30, "Wow");
		assertTrue(TGM.getRoad(town2, town4).equals("Wow"));
		
		TGM.addRoad(town4, town3, 20, "Nope");
		assertFalse(TGM.getRoad(town4, town3).equals("Not Nope"));
	}

	@Test
	public void testGetRoad() {
		assertTrue(TGM.getRoad(town1, town2).equals("Shady Grove Road"));
		assertTrue(TGM.getRoad(town1, town3).equals("ICC 200"));

	}

	@Test
	public void testAddTown() {
		String tTown1 = "LOLTOWN";
		String tTown2 = "SCREW PS5 SCALPERS";
		
		TGM.addTown(tTown1);
		assertTrue(TGM.containsTown(tTown1));
		
		assertFalse(TGM.containsTown(tTown2));
		
		TGM.addTown(tTown2);
		assertTrue(TGM.containsTown(tTown2));
	}

	@Test
	public void testGetTown() {
		assertNotNull(TGM.getTown("Silver Spring"));
		assertNotNull(TGM.getTown("Rockville"));
		assertNotNull(TGM.getTown("Gaithersburg"));
	}

	@Test
	public void testContainsTown() {
		assertTrue(TGM.containsTown(town1));
		assertTrue(TGM.containsTown(town4));
		
		assertFalse(TGM.containsTown("Laurel"));
	}

	@Test
	public void testContainsRoadConnection() {
		assertTrue(TGM.containsRoadConnection(town1, town2));
		assertTrue(TGM.containsRoadConnection(town1, town3));
		assertTrue(TGM.containsRoadConnection(town3, town4));
	}



	@Test
	public void testAllTowns() {
		ArrayList<String> allTown = TGM.allTowns();
		assertTrue(allTown.contains("Clinton"));
		assertTrue(allTown.contains("Gaithersburg"));
		assertTrue(allTown.contains("Rockville"));
		assertTrue(allTown.contains("Silver Spring"));
	}



	@Test
	public void testPopulateTownGraph() throws FileNotFoundException {
		File newFile = new File("testFile.txt");
		
		PrintWriter pw = new PrintWriter(newFile);
		pw.println("I270-N,14;Frederick;Clarksburg");
		pw.println("MD109,13;Clarksburg;Poolesville");
		pw.println("MD121,8;Clarksburg;Boyds");
		pw.println("I270-NC,5;Clarksburg;Germantown");
		pw.println("MD108,14;Clarksburg;Olney");
		pw.println("MD117W,9;Poolesville;Boyds");
		pw.println("MD28,8;Poolesville;Darnestown");
		pw.println("MD117E,4;Germantown;Boyds");
		pw.println("MD118W,6;Germantown;Darnestown");
		pw.println("I270-C,6;Germantown;Gaithersburg");
		pw.println("MD118E,15;Germantown;Olney");
		pw.println("MD124,7;Gaithersburg;Darnestown");
		pw.println("I270-SC,7;Gaithersburg;Rockville");
		pw.println("BowieMill,11;Gaithersburg;Olney");
		pw.println("MD190W,8;Darnestown;Potomac");
		pw.println("MD97,8;Rockville;Olney");
		pw.println("MD109,13;Clarksburg;Poolesville");
		pw.println("MD189,6;Rockville;Potomac");
		pw.println("I270-S,7;Rockville;Bethesda");
		pw.println("MD190E,7;Bethesda;Potomac");
		
		pw.close();
		
		try {
			TGM.populateTownGraph(newFile);
			assertTrue("No exception thrown", true);
		} catch (Exception e) {
			assertTrue("Exception thrown", false);
		}
		
		assertTrue(TGM.containsTown("Rockville"));
		assertTrue(TGM.containsTown("Gaithersburg"));
		
		newFile.delete();
	}

}