import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class Main {
	public static List<Integer> stack = new ArrayList<Integer>();
	public static int acc = 0;

	public static void main(String[] args) throws IOException {
		String content = Files.readString(Paths.get("../input.txt"));
		String[] lines = content.split("\n");

		corrector(lines, 0, 0);
		System.out.println("Answer: " + acc);
	}

	public static boolean corrector(String[] lines, int i, int sticky) {
		// printList();
		if (i >= lines.length) {
			System.out.println("End of File");
			return true;
		}
		if (stack.contains(i)) {
			return false;
		} else {
			stack.add(i);
		}
		String[] parts = lines[i].split(" ");
		switch (parts[0]) {
			case ("acc"):
				int savedAcc = acc;
				acc += Integer.parseInt(parts[1]);
				if (corrector(lines, i + 1, sticky) == false) {
					acc = savedAcc;
					stack.remove(stack.indexOf(i));
					return false;
				}
				break ;
			case ("jmp"):
				if (corrector(lines, i + Integer.parseInt(parts[1]), sticky) == false) {
					if (sticky == 0) {
						lines[i] = lines[i].replace("jmp", "nop");
						if (corrector(lines, i + 1, 1) == false) {
							stack.remove(stack.indexOf(i));
							lines[i] = lines[i].replace("nop", "jmp");
							return false;
						}
					} else {
						return false;
					}
				}
				break ;
			case ("nop"):
				if (corrector(lines, i + 1, sticky) == false) {
					if (sticky == 0) {
						lines[i] = lines[i].replace("nop", "jmp");
						if (corrector(lines, i + Integer.parseInt(parts[1]), 1) == false) {
							stack.remove(stack.indexOf(i));
							lines[i] = lines[i].replace("jmp", "nop");
							return false;
						}
					} else {
						return false;
					}
				}
				break ;
		}
		return true;
	}

	public static void printList() {
		for (int i : stack) {
			System.out.print(i + ",");
		}
		System.out.println();
	}
}