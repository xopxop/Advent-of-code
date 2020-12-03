import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

class Main {

	public static void counter(String line, int[] pos, int[] count) {
		if (line.charAt(pos[0]) == '#') {
			count[0]++;
		}
		for (int i = 0; i < 3; i++) {
			pos[0]++;
			if (pos[0] == line.length()) {
				pos[0] = 0;
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		int pos = 0;
		int[] posAdd = {pos};
		int count = 0;
		int[] countAdd = {count};
		Scanner scanner = new Scanner(new File("../input.txt"));
		String line;
		if (scanner.hasNext()) {
			line = scanner.nextLine();
			counter(line, posAdd, countAdd);
		}
		while(scanner.hasNext()) {
			line = scanner.nextLine();
			counter(line, posAdd, countAdd);

		}
		System.out.println("Answer: " + countAdd[0]);
	}
}