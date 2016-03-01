import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1Solution {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("Day1Input.txt")); // read in input file
		String input = in.next(); // store input as a String
		in.close();
		
		System.out.println("Part 1 Answer: " + finalFloor(input));
		System.out.println("Part 1 Answer: " + inBasement(input));
	}
	
	// return the floor Santa ends on after all instructions
	public static int finalFloor(String input) {
		int floor = 0;
		for (int i = 0; i < input.length(); i++) {
			String current = input.substring(i, i+1);
			if (current.equals("(")) floor++;
			else floor--;
		}
		return floor;
	}
	
	// return which instruction first sends Santa to the basement
	public static int inBasement(String input) {
		int floor = 0;
		for (int i = 0; i < input.length(); i++) {
			String current = input.substring(i, i+1);
			if (current.equals("(")) floor++;
			else floor--;
			
			if (floor == -1) {
				return i + 1;
			}
		}
		return -1; // Santa never reaches the basement
	}
}
