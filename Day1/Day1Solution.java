import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1Solution {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("Day1Input.txt"));
		String input = in.next();
		in.close();
		
		int floor = 0;
		boolean aboveBasement = true;
		
		for (int i = 0; i < input.length(); i++) {
			String current = input.substring(i, i+1);
			if (current.equals("(")) floor++;
			else floor--;
			
			if (floor == -1 && aboveBasement) {
				System.out.println(i+1); // first print statement will return Part Two answer
				aboveBasement = false;
			}
		}
		
		System.out.println(floor); // final print statement will return Part One answer
	}
}
