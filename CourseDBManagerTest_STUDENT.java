import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseDBManagerTest_STUDENT {
	CourseDBManager cdm;
	CourseDBManagerInterface reader;
	
	@BeforeEach
	void setUp() throws Exception {
		cdm = new CourseDBManager();
		reader = new CourseDBManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		cdm = null;
		reader = null;
	}

	@Test
	void testAdd() {
		cdm.add("CMSC201", 23456, 4, "SC102", "Person1");
		cdm.add("CMSC204", 92846, 4, "SC132", "Person2");
		assertEquals("CMSC204", cdm.get(92846).getID());
	}

	@Test
	void testGet() {
		cdm.add("CMSC201", 23456, 4, "SC102", "Person1");
		cdm.add("CMSC204", 92846, 4, "SC132", "Person2");
		assertEquals("CMSC201", cdm.get(23456).getID());
	}

	@Test
	void testReadFile() {
		try {
			File f = new File("test.txt");
			PrintWriter printWriter = new PrintWriter(f);
			printWriter.println("CMSC204 10245 4 SC124 Person1");
			printWriter.print("CMSC204 94832 5 SC570 Person2");
			printWriter.close();
			
			reader.readFile(f);
			assertEquals("Person2",reader.get(94832).getInstructor());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testShowAll() {
		cdm.add("CMSC201", 23456, 4, "SC102", "Person1");
		cdm.add("CMSC204", 92846, 4, "SC132", "Person2");
		ArrayList list = cdm.showAll();
		assertEquals("\nCourse:CMSC201 CRN:23456 Credits:4 Instructor:Person1 Room:SC102", list.get(1));
	}

}
