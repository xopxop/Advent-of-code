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

		System.out.println(findingEncryptionWeakness(findingInvalidNumber()));
	}

	public static long findingEncryptionWeakness(long theInvalidNumber) {
		int posNum = list.indexOf(theInvalidNumber);
		int ceil = posNum - 1;
		int base = -1;
		
		while (++base <= ceil) {
			int i = base;
			long sum = 0;
			while (i <= ceil) {
				sum += list.get(i);
				System.out.println(sum);
				if (sum == theInvalidNumber) {
					return theSum(base, i);
				} else if (sum > theInvalidNumber) {
					break;
				}
				i++;
			}
		}
		return -1;
	}

	public static long theSum(int base, int ceil) {
		return findMin(base, ceil) + findMax(base, ceil);
	}

	public static long findMin(int base, int ceil) {
		long min = list.get(base);

		while (base <= ceil) {
			if (min > list.get(base)) {
				min = list.get(base);
			}
			base++;
		}
		return min;
	}

	public static long findMax(int base, int ceil) {
		long max = 0;

		while (base <= ceil) {
			if (max < list.get(base)) {
				max = list.get(base);
			}
			base++;
		}
		return max;
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
		return -1;
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