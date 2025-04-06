/**
 * Ian Green
 * Prof. Kuijt
 * CMSC 204 CRN 31209
 * 4/6/2025
 * This class allows user to manually add elements or read a file to add to the data structure
 */

import java.io.*;
import java.util.*;

public class CourseDBManager implements CourseDBManagerInterface{

	private CourseDBStructure dbStructure;
	
	public CourseDBManager() {
		dbStructure = new CourseDBStructure(10);
	}
	
	public CourseDBManager(int n) {
		dbStructure = new CourseDBStructure(n);
	}
	@Override
	/**
	 * Adds a course to the data structure
	 */
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement course = new CourseDBElement(id, crn, credits, roomNum, instructor);
		dbStructure.add(course);
		
	}

	@Override
	/**
	 * Gets the course based on the given crn
	 */
	public CourseDBElement get(int crn)  {
		try {
			return dbStructure.get(crn);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	/**
	 * Reads a text file and adds the courses to the data structure
	 */
	public void readFile(File input) throws FileNotFoundException {
		try {
			Scanner scanner = new Scanner(input);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] attributes = line.split("\\s+");
				
				if (attributes.length >= 5) {
					String courseID = attributes[0];
					int CRN = Integer.parseInt(attributes[1]);
					int credits = Integer.parseInt(attributes[2]);
					String room = attributes[3];
					
					StringBuilder instructor = new StringBuilder();
					for (int i = 4; i < attributes.length; i++) {
						instructor.append(attributes[i]).append(" ");
					}
					String instructorName = instructor.toString();
					
					CourseDBElement course = new CourseDBElement(courseID, CRN, credits, room, instructorName);
					dbStructure.add(course);
				}
			}
			scanner.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	/**
	 * Returns a string of all courses in the data structure
	 */
	public ArrayList<String> showAll() {
		LinkedList<CourseDBElement>[] hashTable = dbStructure.getHashTable();
		ArrayList<CourseDBElement> list = new ArrayList<>();
	    
		for (LinkedList<CourseDBElement> bucket : hashTable) {
	        if (bucket != null && !bucket.isEmpty()) {
	            list.addAll(bucket); 
	        }
	    }
		
		for (int i = 0; i < list.size() - 1; i++) {
	        for (int j = 0; j < list.size() - 1 - i; j++) {
	            if (list.get(j).compareTo(list.get(j + 1)) > 0) {
	                Collections.swap(list, j, j + 1);
	            }
	        }
	    }
		
		ArrayList<String> result = new ArrayList<>();
	    for (CourseDBElement course : list) {
	        result.add(course.toString());  
	    }
		return result;		
	}
	

}
