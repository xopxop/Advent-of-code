import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("../input.txt"));
		String content = "";

		while(sc.hasNext()) {
			content += sc.nextLine() + "\n";
		}
		System.out.println(parseBag(content, "shiny gold", 1));
	}

	public static int parseBag(String content, String valid, int num) {
		String[] rules = content.split("\n");
		boolean stop = false;
		int total = 0;
		for (String rule : rules) {
			String[] parts = rule.split(" bags contain ");
			if(parts[0].equals(valid)) {
				if (parts[1].length() == 14) {
					return 0;
				}
				String[] bags = parts[1].split(", ");
				for (String bag : bags) {
					String[] words = bag.split(" ");
					String bagType = words[1] + " " + words[2];
					int passedNum = num * Integer.parseInt(words[0]);
					total += passedNum + parseBag(content, bagType, passedNum);
				}
				return total;
			}
		}
		System.out.println("HERE");
		return 0;
	}
}