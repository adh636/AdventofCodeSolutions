import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Day3Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("Day3Input.txt"));
		String directions = input.next();
		input.close();
		
		int oneSanta = housesVisited(directions, 1);
		int twoSantas = housesVisited(directions, 2);	
		System.out.println("Part 1 Answer: " + oneSanta);
		System.out.println("Part 2 Answer: " + twoSantas);
	}
	
	static int housesVisited(String directions, int numberOfSantas) {
		HashSet<String> locationSet = new HashSet<String>();
		locationSet.add("0,0");
		int length = directions.length();
		
		Santa[] allSantas = new Santa[numberOfSantas];
		for (int b = 0; b < numberOfSantas; b++) {
			allSantas[b] = new Santa();
		}
		for (int i = 0; i < length; i++) {
			allSantas[i % numberOfSantas].move(directions.charAt(i));
			locationSet.add(allSantas[i % numberOfSantas].getLocation());
		}		
		return locationSet.size();
	}
}

class Santa {
	private int x;
	private int y;

	Santa() {
		x = 0;
		y = 0;
	}
	
	public void move(char direction) {
		if (direction == '^') y++;
		if (direction == '>') x++;
		if (direction == 'v') y--;
		if (direction == '<') x--;
	}
	
	public String getLocation() {
		return x + "," + y;
	}
}
