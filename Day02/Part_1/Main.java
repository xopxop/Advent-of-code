import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Stream;

class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("../input.txt"));
		int result = 0;
		while (sc.hasNext()) {
			String[] elements =  sc.nextLine().split(" ");
			int[] range = Stream.of(elements[0].split("-")).mapToInt(Integer::parseInt).toArray();
			char c = elements[1].charAt(0);
			String password = elements[2];
			int count = 0;
			for(int i = 0; i < password.length(); i++) {
				if (password.charAt(i) == c) {
					count++;
				}
			}
			if (count >= range[0] && count <= range[1]) {
				result++;
			}
		}
		System.out.println("Answer: " + result);
	}
}