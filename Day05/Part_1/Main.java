import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
	static int highestSeatID = 0;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("../input.txt"));
		String line;
		while (scanner.hasNext()) {
			line = scanner.nextLine();
			decode(line);
		}
		System.out.println("Highest seat ID: " + highestSeatID);
	}
	public static void decode(String str) {
		int row = 0;
		int column = 0;
		int min = 0;
		int max = 127;
		int i = -1;
		int seatId = 0;

		while (++i < 6) {
			char c = str.charAt(i);
			if (c == 'F') {
				max = (int) Math.floor(((double)min + (double)max) / 2);
			} else if (c == 'B') {
				min = (int) Math.ceil(((double)min + (double)max) / 2);
			}
		}
		if (str.charAt(i) == 'F') {
			row = (int) Math.floor(((double)min + (double)max) / 2);
		} else if (str.charAt(i) == 'B') {
			row = (int) Math.ceil(((double)min + (double)max) / 2);
		}
		min = 0;
		max = 7;
		while (++i < 9) {
			char c = str.charAt(i);
			if (c == 'L') {
				max = (int) Math.floor(((double)min + (double)max) / 2);
			} else if (c == 'R') {
				min = (int) Math.ceil(((double)min + (double)max) / 2);
			}
		}
		if (str.charAt(i) == 'L') {
			column = (int) Math.floor(((double)min + (double)max) / 2);
		} else if (str.charAt(i) == 'R') {
			column = (int) Math.ceil(((double)min + (double)max) / 2);
		}
		seatId = row * 8 + column;
		if (seatId > highestSeatID) {
			highestSeatID = seatId;
		}
		System.out.println("row: "+row + ", column: " + column + ", seat ID: " + seatId);
	}
}