import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day14 {
	static Reindeer[] herd = new Reindeer[9];
	static int time = 2503;

	public static void main(String[] args) throws FileNotFoundException {	
		Scanner in = new Scanner(new File("Day14Input.txt"));
		addReindeerToHerd(in);
		
		int mostDistance = farthestReindeer(herd).getTotalDistance(); // part 1 answer
		int mostPoints = highestScoringReindeer(herd).getPoints(); // part 2 answer
		
		System.out.println("Farthest Reindeer: " + mostDistance);
		System.out.println("Highest Scoring Reindeer: " + mostPoints);
	}
	
	static void addReindeerToHerd(Scanner input) {
		int herdCounter = 0;
		while (input.hasNextLine()) {
			herd[herdCounter] = new Reindeer(input.nextLine(), time);
			herdCounter++;	
		}
	}
	
	static Reindeer farthestReindeer(Reindeer[] herd) {
		Reindeer farthestReindeer = herd[0];
		for (Reindeer currentReindeer: herd) {
			if (currentReindeer.getTotalDistance() > farthestReindeer.getTotalDistance()) {
				farthestReindeer = currentReindeer;
			}
		}
		return farthestReindeer;
	}
	
	static Reindeer highestScoringReindeer(Reindeer[] herd) {
		int farthestLocation = 0;
		for (int i = 1; i <= time; i++) {		
			//updates each Reindeer's location and farthestLocation
			for (Reindeer currentReindeer: herd) {
				currentReindeer.updateLocation(i);
				if (currentReindeer.getLocation() > farthestLocation) {
					farthestLocation = currentReindeer.getLocation();
				}
			}
			// adds a point to the Reindeer who is leading after each second
			for (Reindeer currentReindeer: herd) {
				if (currentReindeer.getLocation() == farthestLocation) {
					currentReindeer.addPoint();
				}	
			}
		}	
		// bestReindeer stores the Reindeer with the most points
		Reindeer bestReindeer = herd[0];
		for (Reindeer currentReindeer: herd) {
			if (currentReindeer.getPoints() > bestReindeer.getPoints()) {
				bestReindeer = currentReindeer;
			}
		}
		return bestReindeer;
	}
	
}

class Reindeer {
	
	private int kmps;
	private int flyTime;
	private int restTime;
	private String name;
	private int totalDistance;
	private int location = 0;
	private int points = 0;

	Reindeer(String bio, int time) {
		String[] stats = bio.split(" ");
		name = stats[0];
		kmps = Integer.parseInt(stats[3]);
		flyTime = Integer.parseInt(stats[6]);
		restTime = Integer.parseInt(stats[13]);
		int cycles = time / (flyTime + restTime);
		int leftoverSeconds = time % (flyTime + restTime);
		totalDistance = kmps * (cycles * flyTime + Math.min(flyTime, leftoverSeconds));	
	}
	
	void updateLocation(int second) {
		int leftoverSeconds = second % (flyTime + restTime);
		if (leftoverSeconds <= flyTime && leftoverSeconds > 0) {
			location += kmps;
		}
	}
	
	void addPoint() {
		points++;
	}
	
	public int getPoints() {
		return points;
	}
	
	int getTotalDistance() {
		return totalDistance;
	}
	
	int getLocation() {
		return location;
	}
	
	String getName() {
		return name;
	}
}