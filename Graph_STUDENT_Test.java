import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Graph_STUDENT_Test {
	
	Graph townGraph;

	Town town1;
	Town town2;
	Town town3;

	
	@Before
	public void setUp() throws Exception {
		townGraph = new Graph();
		
		town1 = new Town("Gaithersburg");
		town2 = new Town("Rockville");
		town3 = new Town("Silver Spring");

		
		townGraph.addVertex(town1);
		townGraph.addVertex(town2);
		townGraph.addVertex(town3);
	
		
		townGraph.addEdge(town1, town2, 3, "Shady Grove Road");
		townGraph.addEdge(town1, town3, 8, "ICC 200");
		townGraph.addEdge(town2, town3, 5, "Randolph Road");

	}

	@After
	public void tearDown() throws Exception {
		town1 = town2 = town3 = null;
		townGraph = null;
	}

	@Test
	public void testGetEdge() {
		assertTrue(townGraph.getEdge(town1, town2).getName().equals("Shady Grove Road"));
	}


	@Test
	public void testAddVertex() {
		Town tTown1 = new Town("LOLTOWN");
		Town tTown2 = new Town("PS5 SCALPERS");
		
		townGraph.addVertex(tTown1);
		assertTrue(townGraph.containsVertex(tTown1));
		
		assertFalse(townGraph.containsVertex(tTown2));
		
		townGraph.addVertex(tTown2);
		assertTrue(townGraph.containsVertex(tTown2));
	}

	@Test
	public void testContainsEdge() {
		assertTrue(townGraph.containsEdge(town1, town2));

	}

	@Test
	public void testContainsVertex() {
		assertTrue(townGraph.containsVertex(town1));

		assertTrue(townGraph.containsVertex(town3));

		Town tTown1 = new Town("LOLTOWN");
		
		assertFalse(townGraph.containsVertex(tTown1));
	}


	@Test
	public void testRemoveEdge() {
		townGraph.removeEdge(town1, town2, 3, "Shady Grove Road");
		assertFalse(townGraph.containsEdge(town1, town2));

	}

	@Test
	public void testRemoveVertex() {
		townGraph.removeVertex(town1);
		assertFalse(townGraph.containsVertex(town1));
		assertFalse(townGraph.containsEdge(town1, town2));
	}

	@Test
	public void testVertexSet() {
		Set<Town> townSet = townGraph.vertexSet();
		
		assertTrue(townSet.contains(town1));
		assertTrue(townSet.contains(town2));
		assertTrue(townSet.contains(town3));

	}

}