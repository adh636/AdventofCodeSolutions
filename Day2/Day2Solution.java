import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2Solution {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("Day2Input.txt"));
		int totalWrappingPaper = 0;
		int totalRibbon = 0;
		
		while (in.hasNextLine()) {
			Dimension current = new Dimension(in.nextLine());		
			wrappingPaper += current.getSurfaceArea() + current.getSlack();	
			ribbon += current.getRibbon();
		}
		
		System.out.println("Total wrapping paper: " + totalWrappingPaper);
		System.out.println("Total ribbon: " + totalRibbon);
		in.close();
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
	
	int getSurfaceArea() {
		return (2 * l * w) + (2 * w * h) + (2 * h * l);
	}
	
	int getSlack() {
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
	
	int getRibbon() {
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
