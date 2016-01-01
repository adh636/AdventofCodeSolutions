import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Day07Solution {
	public static void main(String[] args) throws IOException {
		File input = new File("Day7Input.txt");
		BitwiseMap circuit = new BitwiseMap(input);
		int partOne = circuit.getValue("a");
		System.out.println("Part 1: " + partOne);
		
		circuit.bitMap.clear();
		circuit.instructions.put("b", Integer.toString(partOne));
		int partTwo = circuit.getValue("a");
		System.out.println("Part 2: " + partTwo);
	}
}

class BitwiseMap {
	Map<String, String> instructions = new HashMap<>();
	Map<String, Integer> bitMap = new HashMap<>();
	
	BitwiseMap(File input) throws FileNotFoundException {
		Scanner in = new Scanner(input);
		while (in.hasNextLine()) {
			String[] line = in.nextLine().split(" -> ");
			instructions.put(line[1], line[0]);
		}
	}
	
	public int getValue(String input) {
		if (!bitMap.containsKey(input)) {
			if (isStringInt(input)) {
				bitMap.put(input, Integer.valueOf(input));
			} else if (input.contains("AND")) {
				String[] line = input.split(" AND ");
				bitMap.put(input, getValue(line[0]) & getValue(line[1]));
			} else if (input.contains("OR")) {
				String[] line = input.split(" OR ");
				bitMap.put(input, getValue(line[0]) | getValue(line[1]));
			} else if (input.contains("NOT")) {
				bitMap.put(input, ~getValue(input.substring(4)));
			} else if (input.contains("LSHIFT")) {
				String[] line = input.split(" LSHIFT ");
				bitMap.put(input, (getValue(line[0]) << getValue(line[1])));
			} else if (input.contains("RSHIFT")) {
				String[] line = input.split(" RSHIFT ");
				bitMap.put(input, getValue(line[0]) >> getValue(line[1]));
			} else {
				bitMap.put(input, getValue(instructions.get(input)));
			}
		}
		return bitMap.get(input);
	}
	
	public boolean isStringInt(String s) {
	    try {
	        Integer.parseInt(s);
	        return true;
	    } catch (NumberFormatException ex) {
	        return false;
	    }
	}
}


