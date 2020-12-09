import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;
import javax.sound.midi.SysexMessage;
import javax.swing.plaf.synth.SynthMenuBarUI;

class Main {
	public static ArrayList<String> result = new ArrayList<String>();

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("../input.txt"));
		String content = "";

		while(sc.hasNext()) {
			content += sc.nextLine() + "\n";
		}
		parseBag(content, "shiny gold");
		System.out.println(result.size());
	}

	public static void parseBag(String content, String valid) {
		String[] rules = content.split("\n");
		for (String rule : rules) {
			String[] bag = rule.split(" bags contain ");
			if(!bag[0].equals(valid) && bag[1].contains(valid)) {
				if (!result.contains(bag[0])) {
					result.add(bag[0]);
					parseBag(content, bag[0]);
				}
			}
		}
	}

	public static void printList(ArrayList<String> list) {
		for (String item : list) {
			System.out.println(item);
		}
	}
}
