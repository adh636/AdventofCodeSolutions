import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {

	public static void main(String[] args) throws FileNotFoundException {
		
		printWrappingPaper(new File("Day2Input.txt")); // Print part 1 answer
		printRibbon(new File("Day2Input.txt")); // Print part 2 answer
	}
	
	public static void printWrappingPaper(File input) throws FileNotFoundException {

		Scanner in = new Scanner(new File("Day2Input.txt"));
		int wrappingPaper = 0;
		while (in.hasNextLine()) {	
			Dimension current = new Dimension(in.nextLine());			
			wrappingPaper += current.wrappingPaper();
		}
		in.close();
		System.out.println("Total wrapping paper: " + wrappingPaper);
	}
	
	public static void printRibbon(File input) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("Day2Input.txt")); 
		int ribbon = 0;
		while (in.hasNextLine()) {
			Dimension current = new Dimension(in.nextLine());
			ribbon += current.ribbon();
		}
		in.close();
		System.out.println("Total ribbon: " + ribbon);
	}
}

class Dimension {
	int l;
	int w;
	int h;
	
	Dimension(String input) {
		String[] dimensions = input.split("x");
		l = Integer.parseInt(dimensions[0]);
		w = Integer.parseInt(dimensions[1]);
		h = Integer.parseInt(dimensions[2]);
	}
	
	// surface area of box
	int surfaceArea() {
		return (2 * l * w) + (2 * w * h) + (2 * h * l);
	}
	
	// extra paper needed beyond surface area
	int slack() {
		if (l <= w && h <= w) {
			return l * h;
		}
		else if (l <= h && w <= h) {
			return l * w;
		}
		else {
			return w * h;
		}
	}
	
	// total paper needed to wrap box
	int wrappingPaper() {
		return surfaceArea() + slack();
	}
	
	// total ribbon needed for box
	int ribbon() {
		if (l <= w && h <= w) {
			return (2 * l) + (2 * h) + (l * w * h);
		}
		else if (l <= h && w <= h) {
			return (2 * l) + (2 * w) + (l * w * h);
		}
		else {
			return (2 * w) + (2 * h) + (l * w * h);
		}
	}
}
