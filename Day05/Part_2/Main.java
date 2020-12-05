import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

class Main {
	static int highestSeatID = 0;
	static ArrayList<Integer> seatColection = new ArrayList<Integer>();
	static int lowestSeatID;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("../input.txt"));
		String line;
		int count = 0;
		int mySeatID = 0;

		while (scanner.hasNext()) {
			line = scanner.nextLine();
			decode(line);
			count++;
		}
		Collections.sort(seatColection);
		lowestSeatID = seatColection.get(0);
		for (int seatId : seatColection) {
			if (lowestSeatID != seatId) {
				mySeatID = lowestSeatID;
				break;
			}
			lowestSeatID++;
		}
		System.out.println("My seat ID is: " + mySeatID);
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
		seatColection.add(seatId);
	}
}