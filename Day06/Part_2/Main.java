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
				groupAnswer += lineInput + "\n";
			}
		}
		if (!groupAnswer.isEmpty()) {
			sum += groupHelper(groupAnswer);
		}
		System.out.println("Answer: " + sum);
	}

	public static int groupHelper(String inputGroup) {
		String[] answers = inputGroup.split("\n");

		if (answers.length == 1) {
			return (answers[0].length());
		}
		String template = answers[0];
		for (String answer : answers) {
			StringBuilder innerStringbuilder = new StringBuilder("");
			for (int i = 0; i < answer.length(); i++) {
				if (template.indexOf("" + answer.charAt(i)) != -1) {
					innerStringbuilder.append(answer.charAt(i));
				}
			}
			template = innerStringbuilder.toString();
		}
		return (template.length());
	}
}