import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Slope {
	int _right;
	int _down;

	public Slope(int right, int down) {
		_right = right;
		_down = down;
	}
}

class Main {

	public static void counter(String line, int[] pos, int[] count, Slope slope) {
		if (line.charAt(pos[0]) == '#') {
			count[0]++;
		}
		for (int i = 0; i < slope._right; i++) {
			pos[0]++;
			if (pos[0] == line.length()) {
				pos[0] = 0;
			}
		}
	}

	public static int withSlope(Slope slope) throws FileNotFoundException {
		int pos = 0;
		int[] posAdd = {pos};
		int count = 0;
		int[] countAdd = {count};
		Scanner scanner = new Scanner(new File("../input.txt"));
		String line;
		if (scanner.hasNext()) {
			line = scanner.nextLine();
			counter(line, posAdd, countAdd, slope);
			for (int i = 1; i < slope._down; i++) {
				if (scanner.hasNext())
					scanner.nextLine();
			}
		}
		while(scanner.hasNext()) {
			line = scanner.nextLine();
			counter(line, posAdd, countAdd, slope);
			for (int i = 1; i < slope._down; i++) {
				if (scanner.hasNext())
					scanner.nextLine();
			}
		}
		System.out.println("Answer: " + countAdd[0]);
		return countAdd[0];
	}

	public static void main(String[] args) throws FileNotFoundException {
		long int ret;

		ret = 1;
		Slope[] slopes = new Slope[5];
		slopes[0] = new Slope(1, 1);
		slopes[1] = new Slope(3, 1);
		slopes[2] = new Slope(5, 1);
		slopes[3] = new Slope(7, 1);
		slopes[4] = new Slope(1, 2);
		for (int i = 0; i < 5; i++) {
			ret *= withSlope(slopes[i]);
		}
		System.out.println("Final Answer: " + ret);
	}
}