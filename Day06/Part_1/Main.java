import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("../input.txt"));
		int sum = 0;
		String lineInput;
		String groupAnswer = "";

		while (scanner.hasNext()) {
			lineInput = scanner.nextLine();
			if (lineInput.length() == 0) {
				sum += groupHelper(groupAnswer);
				groupAnswer = "";
			} else {
				groupAnswer += lineInput;
			}
		}
		if (!groupAnswer.isEmpty()) {
			sum += groupHelper(groupAnswer);
		}
		System.out.println("Answer: " + sum);
	}

	public static int groupHelper(String input) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if (sb.indexOf("" + input.charAt(i)) == -1) {
				sb.append(input.charAt(i));
			}
		}
		return (sb.toString().length());
	}
}