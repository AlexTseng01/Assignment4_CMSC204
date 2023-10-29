
/*
 * This is a first-level class that creates a course
 * @author Alex Tseng
 * */
public class CourseDBElement implements Comparable {

	private String id;
	private int crn;
	private int credits;
	private String roomNum;
	private String instructor;
	
	public CourseDBElement() {
		this.id = null;
		this.crn = 0;
		this.credits = 0;
		this.roomNum = null;
		this.instructor = null;
	}
	
	public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
		this.id = id;
		this.crn = crn;
		this.credits = credits;
		this.roomNum = roomNum;
		this.instructor = instructor;
	}
	/*
	 * Compares two CourseDBElement objects based on crn
	 * @param takes a CourseDBElement instance and evaluates the crn
	 * @return 0 if equal, 1 if current crn is greater, -1 if current crn is less
	 * */
	@Override
	public int compareTo(Object o) {
		CourseDBElement temp = (CourseDBElement)o;
		if (this.crn == temp.crn) {
			return 0;
		}
		else if (this.crn > temp.crn) {
			return 1;
		}
		else {
			return -1;
		}
	}
	/*
	 * Gets the current ID
	 * @return the ID
	 * */
	public String getID() {
		return id;
	}
	/*
	 * Sets the current ID as a new ID
	 * @param takes an ID and sets the current ID
	 * */
	public void setId(String id) {
		this.id = id;
	}
	/*
	 * Gets the current CRN
	 * @return the CRN
	 * */
	public int getCRN() {
		return crn;
	}
	/*
	 * Sets the current CRN as a new CRN
	 * @param takes an CRN and sets the current CRN
	 * */
	public void setCRN(int crn) {
		this.crn = crn;
	}
	/*
	 * Gets the current credits
	 * @return the credits
	 * */
	public int getCredits() {
		return credits;
	}
	/*
	 * Sets the current credits as a new credits
	 * @param takes an credits and sets the current credits
	 * */
	public void setCredits(int credits) {
		this.credits = credits;
	}
	/*
	 * Gets the current room number
	 * @return the room number
	 * */
	public String getRoomNum() {
		return roomNum;
	}
	/*
	 * Sets the current room number as a new room number
	 * @param takes an room number and sets the current room number
	 * */
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	/*
	 * Gets the current instructor
	 * @return the instructor
	 * */
	public String getInstructor() {
		return instructor;
	}
	/*
	 * Sets the current instructor as a new instructor
	 * @param takes an instructor and sets the current instructor
	 * */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	/*
	 * Generates a hashcode for the current course
	 * @return the hashcode based on crn
	 * */
	@Override
	public int hashCode() {
		String hash = crn + "";
		return hash.hashCode();
	}
	/*
	 * Converts the current course to a String representation
	 * @return the String representation of the course
	 * */
	@Override
	public String toString() {
		return "Course:" + id + " CRN:" + crn + " Credits:" + credits + " Instructor:" + instructor + " Room:" + roomNum;
	}

}
