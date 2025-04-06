/**
 * Ian Green
 * Prof. Kuijt
 * CMSC 204 CRN 31209
 * 4/6/2025
 * This class creates a structure (hash table with buckets) that will establish a linked list. Based on the course's CRN, the hash code
 * will assign it to a LinkedList. 
 */

import java.io.IOException;
import java.util.*;

public class CourseDBStructure implements CourseDBStructureInterface {
	
	public LinkedList<CourseDBElement>[] hashTable;
	private static final double LOAD_FACTOR = 1.5;
	
	/**
	 * 
	 * @param n Estimated number of courses
	 * This method takes the estimated number of courses and divides by the load factor, then locates the next prime number
	 * that satisfies 4k + 3 to determine the size of the hash table.
	 */
	public CourseDBStructure (int n) {
		int hashNum = (int) (n / LOAD_FACTOR);
		int primeValue = prime(hashNum);
		
		
		hashTable = new LinkedList[primeValue];
		
		for (int i = 0; i < primeValue; i++) {
			hashTable[i] = new LinkedList<CourseDBElement>();
		}
	}
	/**
	 * This method is a test constructor
	 * @param test 
	 * @param numOfCourses
	 */
	public CourseDBStructure(String test, int numOfCourses) {
		hashTable = new LinkedList[numOfCourses];
		for (int i = 0; i < numOfCourses; i++) {
			hashTable[i] = new LinkedList<CourseDBElement>();
		}
	}
	
	
	@Override
	/**
	 * Adds an element (course) to the hash table and creates new linked list if doesn't exist
	 * @param element is the course to be added
	 */
	public void add(CourseDBElement element) {
		int hashCode = element.hashCode();
		int index = hashCode % getTableSize();
		
		if (hashTable[index] == null) {
			hashTable[index] = new LinkedList<>();
		}
		boolean elementExists = false;
		for(int i = 0; i < hashTable[index].size(); i++) {
			
			CourseDBElement existingElement = hashTable[index].get(i);
			if (existingElement.getCRN() == element.getCRN()) {
				hashTable[index].set(i, element);
				elementExists = true;
				break;
			}
		}
		
		if(!elementExists) {
			hashTable[index].add(element);
		}
	}
	@Override
	/**
	 * Returns the course element if it exists
	 * @param crn is how the method locates the hash code to return the element of the given crn
	 */
	public CourseDBElement get(int crn) throws IOException {
		String key = Integer.toString(crn);
		int hashCode = key.hashCode();
		int index = hashCode % getTableSize();
		
		for (int i = 0; i < hashTable[index].size(); i++) {
			if(hashTable[index].get(i).getCRN() == crn) {
				return hashTable[index].get(i);
			}
		}
		throw new IOException();
	}
	@Override
	/**
	 * Returns a String of all the elements in the hash table
	 */
	public ArrayList<String> showAll() {
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
	        result.add(course.toString());  // Add each course as a string representation
	    }
		return result;	
	}
	@Override
	public int getTableSize() {
		return hashTable.length;
	}
	
	private int prime(int num) {
		int nextPrime = num;
		while(true) {
			if (isPrime(nextPrime) && nextPrime % 4 == 3) {
				return nextPrime;
			}
			nextPrime++;
		}
	}
	private boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}
		if (num == 2) {
			return true;
		}
		for (int i = 3; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public LinkedList<CourseDBElement>[] getHashTable() {
		return hashTable;
	}
}
