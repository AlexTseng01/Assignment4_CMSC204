import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseDBStructureTest_STUDENT {
	CourseDBStructure cds;
	CourseDBElement a, b, c;
	
	@BeforeEach
	void setUp() throws Exception {
		cds = new CourseDBStructure(30);
		a = new CourseDBElement("CMSC204", 12345, 4, "SC123", "Person1");
		b = new CourseDBElement("CMSC203", 54321, 4, "SC132", "Person2");
		c = new CourseDBElement("CMSC202", 23451, 4, "SC101", "Person3");
	}

	@AfterEach
	void tearDown() throws Exception {
		cds = null;
		a = b = c = null;
	}

	@Test
	void testAdd() {
		cds.add(a);
		cds.add(b);
		cds.add(b);
		try {
			assertEquals("CMSC204", cds.get(12345).getID());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testGet() {
		cds.add(a);
		cds.add(c);
		cds.add(b);
		try {
			assertEquals("CMSC203", cds.get(54321).getID());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testShowAll() {
		cds.add(a);
		cds.add(c);
		cds.add(b);
		ArrayList list = cds.showAll();
		assertEquals("\nCourse:CMSC202 CRN:23451 Credits:4 Instructor:Person3 Room:SC101", list.get(0));
	}

	@Test
	void testGetTableSize() {
		cds.add(a);
		cds.add(b);
		cds.add(b);
		assertEquals(29, cds.getTableSize());
	}

}
