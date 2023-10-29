import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * This class creates a new hash table and keeps track of data
 * @author Alex Tseng
 * */
public class CourseDBStructure implements CourseDBStructureInterface {

	private final double LOADING_FACTOR = 1.5;
	private int tableSize;
	private LinkedList[] hashTable;
	
	public CourseDBStructure(int n) {
		int newSize = (int) (n/LOADING_FACTOR);
		int prime = 0;
		
		// addresses 2 cases where initially newSize is a prime/is not a prime
		if (isPrime(newSize)) {
			while (prime != 3) {
				if (isPrime(newSize)) {
					prime++;
					if (prime == 3) {
						break;
					}
				}
				newSize++;
			}
		}
		else if (!isPrime(newSize)) {
			while (prime != 2) {
				if (isPrime(newSize)) {
					prime++;
					if (prime == 2) {
						break;
					}
				}
				newSize++;
			}
		}
		
		this.tableSize = newSize;
		this.hashTable = new LinkedList[newSize];
	}
	
	public CourseDBStructure(String testing, int n) {
		this.tableSize = n;
		this.hashTable = new LinkedList[n];
	}
	/*
	 * Adds a course to the table
	 * @param takes an instance of CourseDBElement to add it to the table
	 * */
	@Override
	public void add(CourseDBElement element) {
		// get mapping index
		int mappingIndex = getMappingIndex(element.hashCode());
		
		if (hashTable[mappingIndex] == null) {
			hashTable[mappingIndex] = new LinkedList<CourseDBElement>();
			hashTable[mappingIndex].add(element);
		}
		else if (hashTable[mappingIndex] != null) {
			for (int i = 0; i < hashTable[mappingIndex].size(); i++) {
				if (element.hashCode() == hashTable[mappingIndex].get(i).hashCode()) {
					hashTable[mappingIndex].set(i, element);
					return;
				}
			}
			hashTable[mappingIndex].add(element);
		}
	}
	/*
	 * Gets a course based on crn
	 * @param crn used to generate a hashcode
	 * @return the course object at that crn
	 * */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		String stringCRN = crn + "";
		int mappingIndex = stringCRN.hashCode() % tableSize;
		
		if (hashTable[mappingIndex] == null) {
			throw new IOException();
		}
		else {
			return (CourseDBElement) hashTable[mappingIndex].get(0);
		}
	}
	/*
	 * Stores all of the values from the table
	 * @return an array of String representation of the courses
	 * */
	@Override
	public ArrayList<String> showAll() {
		//String temp = "s";
		ArrayList<String> returnValue = new ArrayList<String>(tableSize);
		
		// for every hashTable element
		for (int i = 0; i < tableSize; i++) {
			if (hashTable[i] != null) {
				// for every LinkedList element
				for (int j = 0; j < hashTable[i].size(); j++) {
					returnValue.add("\n" + hashTable[i].get(j).toString());
				}
			}
		}
		
		return returnValue;
	}
	/*
	 * Gets the table size
	 * @return the table size
	 * */
	@Override
	public int getTableSize() {
		return this.tableSize;
	}
	/*
	 * Checks if a number is prime
	 * @param number to be checked
	 * @return true if it is a prime, false otherwise
	 * */
	public boolean isPrime(int n) {
		// checks for all single digits/negatives
		if (n <= 1) {
			return false;
		}
		else if (n == 4 || n == 6 || n == 8 || n == 9) {
			return false;
		}
		
		// checks for the rest of the digits
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	/*
	 * Gets the mapping index based on the crn
	 * @param a crn to be converted
	 * @return the new mapping index
	 * */
	public int getMappingIndex(int hash) {
		return hash % tableSize;
	}
	
}
