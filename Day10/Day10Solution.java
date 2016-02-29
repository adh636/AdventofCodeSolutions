import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day10Solution {
	
	public static void main(String[] args) {
		System.out.println(lookAndSay(1113122113, 40));
		System.out.println(lookAndSay(1113122113, 50));

	}
	
	public static int lookAndSay(int num, int count) {
		String oldNum = Integer.toString(num);
		StringBuilder newNum = new StringBuilder();
		int counter = 0;
		while (counter < count) {
			String current = oldNum.substring(0, 1);
			int currentCount = 1;
			for (int i = 1; i < oldNum.length(); i++) {
				if (i == oldNum.length() - 1) {
					newNum.append(currentCount);
					newNum.append(oldNum.substring(i-1, i));
					newNum.append(1);
					newNum.append(oldNum.substring(i, i+1));
				}
				else if (current.equals(oldNum.substring(i, i+1))) {
					currentCount++;
				}
				else {
					newNum.append(currentCount);
					newNum.append(current);
					current = oldNum.substring(i, i+1);
					currentCount = 1;
				}			
			}
			oldNum = newNum.toString();
			newNum = new StringBuilder();
			counter++;
		}
		return oldNum.length();
	}
	
	/*
	private static Pattern pattern = Pattern.compile("([0-9])(\\1*)");
	
	public static String folder(String num) {
	    Matcher m = pattern.matcher(num);

	    StringBuilder newNum = new StringBuilder();
	    while (m.find()) {
	        int length = (m.group(2) != null) ? m.group(2).length() + 1 : 1;
	        newNum.append(length + m.group(1));
	    }
	    return newNum.toString();
	}
	
	public static void main(String[] args) {
	    String num = "1113122113";
		
	    for (int i = 0; i < 40; i++) {
	        num = folder(num);
	    }
	    System.out.println(num.length());
	}
	*/

}
