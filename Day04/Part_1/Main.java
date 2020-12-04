import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Passport {
	static int count = 0;
	public String byr = "";
	public String iyr = "";
	public String eyr = "";
	public String hgt = "";
	public String hcl = "";
	public String ecl = "";
	public String pid = "";
	public String cid = "";

	public boolean isValid() {
		if (this.byr.isEmpty()) {
			return false;
		} else if (this.iyr.isEmpty()) {
			return false;
		} else if (this.eyr.isEmpty()) {
			return false;
		} else if (this.hgt.isEmpty()) {
			return false;
		} else if (this.hcl.isEmpty()) {
			return false;
		} else if (this.ecl.isEmpty()) {
			return false;
		} else if (this.pid.isEmpty()) {
			return false;
		}
		return true;
	}

	public void put(String key, String value) {
		if (key.equals("byr")) {
			this.byr = value;
		} else if (key.equals("iyr")) {
			this.iyr = value;
		} else if (key.equals("eyr")) {
			this.eyr = value;
		} else if (key.equals("hgt")) {
			this.hgt = value;
		} else if (key.equals("hcl")) {
			this.hcl = value;
		} else if (key.equals("ecl")) {
			this.ecl = value;
		} else if (key.equals("pid")) {
			this.pid = value;
		} else if (key.equals("cid")) {
			this.cid = value;
		}
	}

	public void reset() {
		if (!this.byr.isEmpty()) {
			this.byr = "";
		} else if (!this.iyr.isEmpty()) {
			this.iyr = "";
		} else if (!this.eyr.isEmpty()) {
			this.eyr = "";
		} else if (!this.hgt.isEmpty()) {
			this.hgt = "";
		} else if (!this.hcl.isEmpty()) {
			this.hcl = "";
		} else if (!this.ecl.isEmpty()) {
			this.ecl = "";
		} else if (!this.pid.isEmpty()) {
			this.pid = "";
		} else if (!this.cid.isEmpty()) {
			this.cid = "";
		}
	}
}

class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("../input.txt"));
		int count;
		String line;
		String buffer = new String();
		count = 0;
		while(scanner.hasNext()) {
			line = scanner.nextLine();
			buffer += line;
			if(line.isEmpty()) {
				checking(buffer);
				buffer = "";
			} else {
				buffer += " ";
			}
		}
		checking(buffer);
		buffer = "";
		System.out.println("Answer: " + Passport.count);
	}

	public static void validate(Passport obj) {
		if (obj.isValid()) {
			Passport.count++;
		}
	}

	public static void checking(String buffer) {
		Passport obj = new Passport();
		String[] keyValue = new String[2];

		for (String a : buffer.split(" ")) {
			keyValue = a.split(":");
			obj.put(keyValue[0], keyValue[1]);
		}
		validate(obj);
	}
}