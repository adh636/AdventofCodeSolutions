import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("Day2Input.txt"));
		int wrappingPaper = 0;
		int ribbon = 0;
		
		while (in.hasNextLine()) {
			Dimension current = new Dimension(in.nextLine());
			int surfaceArea = current.surfaceArea();
			int slack = current.slack();			
			wrappingPaper += surfaceArea + slack;	
			ribbon += current.ribbon();
		}
		
		System.out.println("Total wrapping paper: " + wrappingPaper);
		System.out.println("Total ribbon: " + ribbon);
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
	
	int surfaceArea() {
		return (2 * l * w) + (2 * w * h) + (2 * h * l);
	}
	
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
