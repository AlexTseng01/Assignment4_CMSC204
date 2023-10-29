import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * This class utilizes CourseDBStructure to manage data
 * @author Alex Tseng
 * */
public class CourseDBManager implements CourseDBManagerInterface {

	CourseDBStructure struct;
	
	public CourseDBManager() {
		this.struct = new CourseDBStructure(10);
	}
	/*
	 * Adds a course to the database structure
	 * @param takes an id, crn, credits, room number, and instructor to create an instance of CourseDBElement
	 * */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		this.struct.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
	}
	/*
	 * Gets a course based on crn
	 * @param crn used to generate a hashcode
	 * @return the course object at that crn
	 * */
	@Override
	public CourseDBElement get(int crn) {
		try {
			return this.struct.get(crn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * Reads from a file and adds it to the current database structure
	 * @param input is a file used to be read from
	 * */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner scan = new Scanner(input);
		String[] attributes;
		String id, roomNum, instructor = "";
		int crn, credits = 0;
		
		while (scan.hasNextLine()) {
			String currentLine = scan.nextLine();
			String temp = currentLine.replace("Distance Learning", "Distance-Learning");
			attributes = temp.split(" ", 5);
			
			id = attributes[0];
			crn = Integer.parseInt(attributes[1]);
			credits = Integer.parseInt(attributes[2]);
			roomNum = attributes[3];
			instructor = attributes[4];
			
			struct.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
		}
		scan.close();
	}
	/*
	 * Stores all of the values from the database structure
	 * @return an array of String representation of the courses
	 * */
	@Override
	public ArrayList<String> showAll() {
		return this.struct.showAll();
	}

}
