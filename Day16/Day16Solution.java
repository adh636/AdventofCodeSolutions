import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day16Solution {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner allSues = new Scanner(new File("Day16Input.txt"));
		Scanner present = new Scanner(new File("Day16MFCSAM.txt"));
		MFCSAM test = new MFCSAM(present);
		Sue[] arrayOfSues = new Sue[500];
		
		int arrayCounter = 0;
		while (allSues.hasNextLine()) {
			arrayOfSues[arrayCounter] = new Sue(allSues.nextLine());
			arrayCounter++;
		}
		
		for (Sue sue: arrayOfSues) {
			if (sue.compareSue(test)) System.out.println(sue.getName()); //question 1
			if (sue.compareSuev2(test)) System.out.println(sue.getName()); //question 2
		}
		
		allSues.close();
		present.close();
	}
}

class Sue {
	
	private String name;
	private int children = -1;
	private int cats = -1;
	private int samoyeds = -1;
	private int pomeranians = -1;
	private int akitas = -1;
	private int vizslas = -1;
	private int goldfish = -1;
	private int trees = -1;
	private int cars = -1;
	private int perfumes = -1;
	
	Sue(String input) {
		this.addStats(input);
	}
	
	void addStats(String input) {
		String[] stats = input.split(": ");
		String[] firstBreak = stats[2].split(", ");
		String[] secondBreak = stats[3].split(", ");
		name = stats[0];
		
		if (stats[1].equals("children")) children = Integer.parseInt(firstBreak[0]);
		if (stats[1].equals("cats")) cats = Integer.parseInt(firstBreak[0]);
		if (stats[1].equals("samoyeds")) samoyeds = Integer.parseInt(firstBreak[0]);
		if (stats[1].equals("pomeranians")) pomeranians = Integer.parseInt(firstBreak[0]);
		if (stats[1].equals("akitas")) akitas = Integer.parseInt(firstBreak[0]);
		if (stats[1].equals("vizslas")) vizslas = Integer.parseInt(firstBreak[0]);
		if (stats[1].equals("goldfish")) goldfish = Integer.parseInt(firstBreak[0]);
		if (stats[1].equals("trees")) trees = Integer.parseInt(firstBreak[0]);
		if (stats[1].equals("cars")) cars = Integer.parseInt(firstBreak[0]);
		if (stats[1].equals("perfumes")) perfumes = Integer.parseInt(firstBreak[0]);
		
		if (firstBreak[1].equals("children")) children = Integer.parseInt(secondBreak[0]);
		if (firstBreak[1].equals("cats")) cats = Integer.parseInt(secondBreak[0]);
		if (firstBreak[1].equals("samoyeds")) samoyeds = Integer.parseInt(secondBreak[0]);
		if (firstBreak[1].equals("pomeranians")) pomeranians = Integer.parseInt(secondBreak[0]);
		if (firstBreak[1].equals("akitas")) akitas = Integer.parseInt(secondBreak[0]);
		if (firstBreak[1].equals("vizslas")) vizslas = Integer.parseInt(secondBreak[0]);
		if (firstBreak[1].equals("goldfish")) goldfish = Integer.parseInt(secondBreak[0]);
		if (firstBreak[1].equals("trees")) trees = Integer.parseInt(secondBreak[0]);
		if (firstBreak[1].equals("cars")) cars = Integer.parseInt(secondBreak[0]);
		if (firstBreak[1].equals("perfumes")) perfumes = Integer.parseInt(secondBreak[0]);
		
		if (secondBreak[1].equals("children")) children = Integer.parseInt(stats[4]);
		if (secondBreak[1].equals("cats")) cats = Integer.parseInt(stats[4]);
		if (secondBreak[1].equals("samoyeds")) samoyeds = Integer.parseInt(stats[4]);
		if (secondBreak[1].equals("pomeranians")) pomeranians = Integer.parseInt(stats[4]);
		if (secondBreak[1].equals("akitas")) akitas = Integer.parseInt(stats[4]);
		if (secondBreak[1].equals("vizslas")) vizslas = Integer.parseInt(stats[4]);
		if (secondBreak[1].equals("goldfish")) goldfish = Integer.parseInt(stats[4]);
		if (secondBreak[1].equals("trees")) trees = Integer.parseInt(stats[4]);
		if (secondBreak[1].equals("cars")) cars = Integer.parseInt(stats[4]);
		if (secondBreak[1].equals("perfumes")) perfumes = Integer.parseInt(stats[4]);
	}
	
	boolean compareSue(MFCSAM test) {
		int score = 0;
		if (this.getChildren() == test.getChildren() && this.getChildren() != -1) score++;
		if (this.getCats() == test.getCats() && this.getCats() != -1) score++;
		if (this.getSamoyeds() == test.getSamoyeds() && this.getSamoyeds() != -1) score++;
		if (this.getPomeranians() == test.getPomeranians() && this.getPomeranians() != -1) score++;
		if (this.getAkitas() == test.getAkitas() && this.getAkitas() != -1) score++;
		if (this.getVizslas() == test.getVizslas() && this.getVizslas() != -1) score++;
		if (this.getGoldfish() == test.getGoldfish() && this.getGoldfish() != -1) score++;
		if (this.getTrees() == test.getTrees() && this.getTrees() != -1) score++;
		if (this.getCars() == test.getCars() && this.getCars() != -1) score++;
		if (this.getPerfumes() == test.getPerfumes() && this.getPerfumes() != -1) score++;
		if (score == 3) return true;
		return false;
	}
	
	boolean compareSuev2(MFCSAM test) {
		int score = 0;
		if (this.getChildren() == test.getChildren() && this.getChildren() != -1) score++;
		if (this.getCats() > test.getCats() && this.getCats() != -1) score++;
		if (this.getSamoyeds() == test.getSamoyeds() && this.getSamoyeds() != -1) score++;
		if (this.getPomeranians() < test.getPomeranians() && this.getPomeranians() != -1) score++;
		if (this.getAkitas() == test.getAkitas() && this.getAkitas() != -1) score++;
		if (this.getVizslas() == test.getVizslas() && this.getVizslas() != -1) score++;
		if (this.getGoldfish() < test.getGoldfish() && this.getGoldfish() != -1) score++;
		if (this.getTrees() > test.getTrees() && this.getTrees() != -1) score++;
		if (this.getCars() == test.getCars() && this.getCars() != -1) score++;
		if (this.getPerfumes() == test.getPerfumes() && this.getPerfumes() != -1) score++;
		if (score == 3) return true;
		return false;
	}
	
	String getName() {
		return name;
	}
	
	public int getChildren() {
		return children;
	}

	public int getCats() {
		return cats;
	}

	public int getSamoyeds() {
		return samoyeds;
	}

	public int getPomeranians() {
		return pomeranians;
	}

	public int getAkitas() {
		return akitas;
	}

	public int getVizslas() {
		return vizslas;
	}

	public int getGoldfish() {
		return goldfish;
	}

	public int getTrees() {
		return trees;
	}

	public int getCars() {
		return cars;
	}

	public int getPerfumes() {
		return perfumes;
	}
}

class MFCSAM {
	private int children;
	private int cats;
	private int samoyeds;
	private int pomeranians;
	private int akitas;
	private int vizslas;
	private int goldfish;
	private int trees;
	private int cars;
	private int perfumes;
	
	MFCSAM(Scanner input) {	
		while (input.hasNextLine()) {
			String[] current = input.nextLine().split(": ");
			if (current[0].equals("children")) children = Integer.parseInt(current[1]);
			if (current[0].equals("cats")) cats = Integer.parseInt(current[1]);
			if (current[0].equals("samoyeds")) samoyeds = Integer.parseInt(current[1]);
			if (current[0].equals("pomeranians")) pomeranians = Integer.parseInt(current[1]);
			if (current[0].equals("akitas")) akitas = Integer.parseInt(current[1]);
			if (current[0].equals("vizslas")) vizslas = Integer.parseInt(current[1]);
			if (current[0].equals("goldfish")) goldfish = Integer.parseInt(current[1]);
			if (current[0].equals("trees")) trees = Integer.parseInt(current[1]);
			if (current[0].equals("cars")) cars = Integer.parseInt(current[1]);
			if (current[0].equals("perfumes")) perfumes = Integer.parseInt(current[1]);
		}
	}
	
	public int getChildren() {
		return children;
	}

	public int getCats() {
		return cats;
	}

	public int getSamoyeds() {
		return samoyeds;
	}

	public int getPomeranians() {
		return pomeranians;
	}

	public int getAkitas() {
		return akitas;
	}

	public int getVizslas() {
		return vizslas;
	}

	public int getGoldfish() {
		return goldfish;
	}

	public int getTrees() {
		return trees;
	}

	public int getCars() {
		return cars;
	}

	public int getPerfumes() {
		return perfumes;
	}
}
