import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
	public static List<Long> list = new ArrayList<Long>();
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("../input.txt"));

		while(sc.hasNext()) {
			list.add(Long.parseLong(sc.nextLine()));
		}

		System.out.println(findingInvalidNumber());
	}

	public static long findingInvalidNumber() {
		int i = 25;

		while (i < list.size()) {
			int base = i - 25;
			int ceil = i - 1;
			if (isValidRange(base, ceil, i) == false) {
				return (list.get(i));
			}
			i++;
		}
		return (0);
	}

	public static boolean isValidRange(int base, int ceil, int sum) {
		while (base < ceil) {
			int step = 1;
			while (base + step <= ceil) {
				if (isValidPair(list.get(base), list.get(base + step), list.get(sum))) {
					return true;
				}
				step ++;
			}
			base++;
		}
		return false;
	}

	public static boolean isValidPair(long num1, long num2, long sum) {
		return sum == (num1 + num2);
	}
}