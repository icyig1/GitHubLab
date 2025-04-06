/**
 * Ian Green
 * Professur Kuijt
 * CMSC 204 CRN 31209
 * 4/6/2025
 * Course Data Element Class: Holds the elements of each course that will be held in data structure
 */

public class CourseDBElement implements Comparable<CourseDBElement> {
	private String ID; //Course ID
	private int crn; // Course CRN
	private int credits; // Number of credits 
	private String roomNum; // Room Number
	private String instructor; // Instructors name
	
	/**
	 * 
	 * @param ID is the courseID
	 * @param crn is the crn number
	 * @param credits is the amount of credits
	 * @param room is the room number
	 * @param inst is the class instructurs name
	 * This creates a CourseDBElement object
	 */
	public CourseDBElement(String courseID, int crn, int credits, String room, String inst) {
		ID = courseID;
		this.crn = crn;
		this.credits = credits;
		roomNum = room;
		instructor = inst;
	}
	/*
	 * This constructor class assigns deafult values if empty
	 */
	public CourseDBElement() {
		ID = "";
		this.crn = 0;
		this.credits = 0;
		this.roomNum = "";
		this.instructor = "";
	}
	
	
	@Override
	/**
	 * Compares this course data element to the given course data element
	 * @param element is the course data element
	 * @return a negative number if THIS course CRN is LESS than the GIVEN course, a 1 if THIS 
	 * course CRN is GREATER than GIVEN course CRN, and a 0 if both CRN are equal.
	 */
	public int compareTo(CourseDBElement element) {
		int otherCRN = element.getCRN();
		if(crn == otherCRN) {
			return 0;
		} else if(crn > otherCRN) {
			return 1;
		} else {
			return -1;
		}
	}
	
	@Override
	/**
	 * Returns a string of the data elements
	 */
	public String toString() {
		return "\nCourse:" + ID + " CRN:" + Integer.toString(crn) + " Credits:" + Integer.toString(credits) + " Instructor:" + instructor + " Room:" + roomNum;
	}
	@Override
	/**
	 * Returns true if THIS course is equal to GIVEN course
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		CourseDBElement other = (CourseDBElement) obj;
		return this.crn == other.crn;
	}
	@Override
	/**
	 * Returns the hash code based on CRN
	 */
	public int hashCode() {
		String key = Integer.toString(crn);
		return key.hashCode();
	}
	
	
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public int getCRN() {
		return crn;
	}
	public void setCRN(int crn) {
		this.crn = crn;
	}
	
	public int getCredits() {
		return credits;
	}
	public void setCredits(int cred) {
		credits = cred;
	}
	
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String room) {
		roomNum = room;
	}
	
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String inst) {
		instructor = inst;
	}
	
}
