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

		for (int i = 0; i < lines.length; i++) {
			lines[i] = (i + 1) + " " + lines[i];
		}
		partOne(lines, 0);
		System.out.println(acc);
	}

	public static void partOne(String[] lines, int i) {
		if (stack.contains(i)) {
			return ;
		} else {
			stack.add(i);
		}

		String[] parts = lines[i].split(" ");
		switch (parts[1]) {
			case ("acc"):
				acc += Integer.parseInt(parts[2]);
				if (lines[i + 1] != null) {
					partOne(lines, i + 1);
				}
				break ;
			case ("jmp"):
				if (lines[i + Integer.parseInt(parts[2])] != null) {
					partOne(lines, i + Integer.parseInt(parts[2]));
				}
				break ;
			case ("nop"):
				if (lines[i + 1] != null) {
					partOne(lines, i + 1);
				}
				break ;
		}
	}
}