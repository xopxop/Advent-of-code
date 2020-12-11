import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
	public static int byOne = 0;
	public static int byTwo = 0;
	public static int byThree = 0;
	public static int highestAddapter = 0;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("../input.txt"));
		List<Integer> list = new ArrayList<Integer>();
		
		while (sc.hasNext()) {
			list.add(Integer.parseInt(sc.nextLine()));
		}

		addingTheHighestIntoTheList(list);
		findingTheDifference(list);
		System.out.println(byOne + " differences of 1");
		System.out.println(byTwo + " differences of 2");
		System.out.println(byThree + " differences of 3");
		System.out.println("Answer :" + (byOne * byThree));
	}

	public static void findingTheDifference(List<Integer> list) {
		boolean stop = false;
		int currentAdappter = 0;

		while (stop == false) {
			if (list.contains(currentAdappter + 1)) {
				currentAdappter += 1;
				byOne++;
			} else if (list.contains(currentAdappter + 2)) {
				currentAdappter += 2;
				byTwo++;
			} else if (list.contains(currentAdappter + 3)) {
				currentAdappter += 3;
				byThree++;
			} else {
				stop = true;
			}
		}
	}

	public static void addingTheHighestIntoTheList(List<Integer> list) {
		int highest = 0;
		for (int item : list) {
			if (highest < item) {
				highest = item;
			}
		}

		highestAddapter = highest + 3;
		list.add(highestAddapter);
	}

	public static void printList(List<Integer> list) {
		for (int item : list) {
			System.out.println(item);
		}
	}
}