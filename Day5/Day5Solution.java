import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day5Solution {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner("Day5input.txt");
		int numberOfNice = 0;
		
		while (in.hasNextLine()) {
			String current = in.nextLine();
			int length = current.length();
			boolean enoughVowels = false;
			boolean doubleLetter = false;
			boolean badString = false;			
			
			enoughVowels = getVowelCount(current, length);
			for (int i = 0; i < length -1; i++) {
				String charPair = current.substring(i, i + 2);
				if (!doubleLetter) doubleLetter = testForDoubleLetter(charPair);
				if (!badString) badString = testForBadString(charPair);
			}			
			if (testIfNice(enoughVowels, doubleLetter, badString)) numberOfNice++;
		}
		
		System.out.println(numberOfNice);
	}
	
	static boolean testForDoubleLetter(String charPair) {
		if (charPair.substring(0, 1).equals(charPair.substring(1))) return true;
		return false;
	}
	
	static boolean testForBadString(String charPair) {
		if (charPair.equals("ab") || charPair.equals("cd") ||
			charPair.equals("pq") || charPair.equals("xy")) return true;
		return false;
	}
	
	static boolean getVowelCount(String current, int length) {
		int vowelCount = 0;	
		for (int i = 0; i < length; i++) {
			if (current.substring(i, i+1).equals("a") ||
				current.substring(i, i+1).equals("e") || 
				current.substring(i, i+1).equals("i") || 
				current.substring(i, i+1).equals("o") ||
				current.substring(i, i+1).equals("u")) {
				vowelCount++;
			}
		}
		if (vowelCount >= 3) return true;
		return false;
	}
	
	static boolean testIfNice(boolean enoughVowels, boolean doubleLetter, boolean badString) {
		if (enoughVowels && doubleLetter && !badString) return true;
		return false;
	}
}

