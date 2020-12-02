import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws IOException {

		int[] list = new int[200];
		int i = 0;
		Scanner scan = new Scanner(new File("input.txt"));
		while (scan.hasNext()) {
			list[i++] = scan.nextInt();
		}
		i = 0;
		int j = 0;
		int k = 0;
		boolean stop = false;
		while (i < 200 && stop == false) {
			j = 0;
			while (j < 200 && stop == false) {
				k = 0;
				if (i == j) {
					j++;
					continue;
				}
				while (k < 200 && stop == false) {
					if (k == j || k == i) {
						k++;
						continue;
					}
					if (list[i] + list[j] + list[k] == 2020) {
						System.out.println(list[i] * list[j] * list[k]);
						stop = true;
					}
					k++;
				}
				j++;
			}
			i++;
		}
	}
}