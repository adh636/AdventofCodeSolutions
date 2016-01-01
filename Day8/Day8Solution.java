import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day8Solution {

	public static void main(String[] args) throws FileNotFoundException {
		File input = new File("Day8Input.txt");
		StringCounter one = new StringCounter(input);
		System.out.println("Part 1: " + one.wastedStrings);
	}

}


class StringCounter {
	int wastedStrings = 0;
	int partTwo = 0;
	
	StringCounter(File input) throws FileNotFoundException {
		Scanner in = new Scanner(input);
		while (in.hasNextLine()) {
			String current = in.nextLine();
			wastedStrings += getSpecialCharacters(current);
			
		}
	}
	
	static int getSpecialCharacters(String input) {
		int counter = 0;
		char[] characters = input.toCharArray();
		for (int i = 0; i < characters.length; i++) {
			if (characters[i] == '\"') {
				counter++;
			}
			else if (characters[i] == '\\') {
				if (characters[i + 1] == 'x') {
					i += 2;
					counter += 3;
				}
				else {
					i += 1;
					counter++;
				}
			}
		}
		return counter;
	}	
}