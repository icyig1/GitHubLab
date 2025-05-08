import java.io.*;
import java.util.*;


public class TownGraphManager implements TownGraphManagerInterface {
private Graph townGraph;
	
	/** Constructor that creates a new graph to work with */
	public TownGraphManager() {
		townGraph = new Graph();
	}

	/** Adds a road to the graph
	 * 
	 * @param town1 The first town of the road
	 * @param town2 The second town of the road
	 * @param weight The weight of the road
	 * @param roadName The name of the road
	 * 
	 * @return True if the road was added, false if not
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town town1Town = getTown(town1);
		Town town2Town = getTown(town2);
		
		if (town1Town == null || town2Town == null)
			return false;
		
		if (townGraph.containsEdge(town1Town, town2Town))
			return false;
		
		townGraph.addEdge(town1Town, town2Town, weight, roadName);
		
		return true;
	}

	/** Gets the name of the road requested
	 * 
	 * @param town1 The name of the first town
	 * @param town2 The name of the second town
	 * 
	 * @return the name of the road
	 */
	@Override
	public String getRoad(String town1, String town2) {
		String roadGotten = "";
		Town town1Town = getTown(town1);
		Town town2Town = getTown(town2);
		
		for(Road road : townGraph.edgeSet())
			if (road.contains(town1Town) && road.contains(town2Town))
				roadGotten = road.getName();
		
		return roadGotten;
	}
	
	/** Helper method of deleteRoadConnection that gets a Road that contains both towns
	 * 
	 * @param town1 The name of the first town
	 * @param town2 The name of the second town
	 * @return A road that contains both towns
	 */
	public Road getRoadR(String town1, String town2) {
		Road roadGotten = null;
		Town town1Town = getTown(town1);
		Town town2Town = getTown(town2);
		
		for(Road road : townGraph.edgeSet())
			if (road.contains(town1Town) && road.contains(town2Town))
				roadGotten = road;
		
		return roadGotten;
	}

	/** Adds a town to the graph
	 * 
	 * @param v The name of the town
	 * 
	 * @param True if the town was created, false if not
	 */
	@Override
	public boolean addTown(String v) {
		return townGraph.addVertex(new Town(v));
	}

	/** Gets a town based off of its name
	 * 
	 * @param name the name of the town to get
	 * 
	 * @return The town with the name requested
	 */
	@Override
	public Town getTown(String name) {
		Town gottenTown = null;
		for (Town town : townGraph.vertexSet())
			if (town.getName().equals(name))
				gottenTown = town;
		return gottenTown;
	}

	/** Checks if the graph contains a certain town
	 * 
	 * @param v The name of the town
	 * 
	 * @return True if the town is in the graph, false if not
	 */
	@Override
	public boolean containsTown(String v) {
		if (getTown(v) == null)
			return false;
		else
			return true;
	}

	/** Checks if a road connection exists between two towns
	 * 
	 * @param town1 The first town of the road
	 * @param town2 The second town of the road
	 * 
	 * @return True if the road exists, false if not
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		return townGraph.containsEdge(getTown(town1), getTown(town2));
	}

	/** Gets a list of roads in a sorted order
	 * 
	 * @return A list of the roads in sorted order
	 */
	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> roadNames = new ArrayList<>();
		for (Road road: townGraph.edgeSet())
			roadNames.add(road.getName());
		
		roadNames.sort(String.CASE_INSENSITIVE_ORDER);
		return roadNames;
	}

	/** Deletes a road connection between two towns
	 * 
	 * @param town1 The first town of the road
	 * @param town2 The second town of the road
	 * 
	 * @return True if the road was deleted, false otherwise
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Road roadGotten = getRoadR(town1, town2);
		townGraph.removeEdge(getTown(town1), getTown(town2), roadGotten.getWeight(), roadGotten.getName());
		return true;
	}

	/** Removes a town from the graph
	 * 
	 * @param v The name of the town
	 * 
	 * @return True if the town was removed, false if not
	 */
	@Override
	public boolean deleteTown(String v) {
		return townGraph.removeVertex(getTown(v));
	}

	/** Gets a list of all towns in sorted order
	 * 
	 * @return A list of all towns in sorted order
	 */
	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> townNames = new ArrayList<>();
		for (Town town : townGraph.vertexSet())
			townNames.add(town.getName());
		
		townNames.sort(String.CASE_INSENSITIVE_ORDER);
		return townNames;
	}

	/** Gets the shortest path from town 1 and town2
	 * 
	 * @param town1 The source town
	 * @param town2 The destination town
	 * 
	 * @return a list of the instructions on how to get from town1 to town2
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		return townGraph.shortestPath(getTown(town1), getTown(town2));
	}

	/** Populates a graph from a file
	 * 
	 * @param selectedFile The file to read from
	 * @throws FileNotFoundException If the file doesn't exist
	 */
	public void populateTownGraph(File selectedFile) throws FileNotFoundException{
		List<String> inList = new ArrayList<>();
		
		if (!selectedFile.exists())
			throw new FileNotFoundException();
		
		Scanner inFile = new Scanner(selectedFile);
		
		while (inFile.hasNextLine()) {
			inList.add(inFile.nextLine());
		}
		
		for (String line : inList) {
			String[] currentLine = line.split(";");
			int commaIndex = currentLine[0].indexOf(",");
			String roadName = currentLine[0].substring(0,commaIndex);
			String weight = currentLine[0].substring(commaIndex+1,currentLine[0].length());
			String source = currentLine[1];
			String destination = currentLine[2];
			
			addTown(source);
			addTown(destination);
			
			addRoad(source, destination, Integer.parseInt(weight), roadName);
		}
		
		inFile.close();
	}
}