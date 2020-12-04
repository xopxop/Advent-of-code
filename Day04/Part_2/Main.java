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
		if (this.byr.isEmpty() || !isValidByr(this.byr)) {
			return false;
		} else if (this.iyr.isEmpty() || !isValidIyr(this.iyr)) {
			return false;
		} else if (this.eyr.isEmpty() || !isValidEyr(this.eyr)) {
			return false;
		} else if (this.hgt.isEmpty() || !isValidHgt(this.hgt)) {
			return false;
		} else if (this.hcl.isEmpty() || !isValidHcl(this.hcl)) {
			return false;
		} else if (this.ecl.isEmpty() || !isValidEcl(this.ecl)) {
			return false;
		} else if (this.pid.isEmpty() || !isValidPid(this.pid)) {
			return false;
		}
		return true;
	}

	public boolean isValidByr(String str) {
		int countDiGit = 0;
		
		if (str.length() != 4) {
			return false;
		}
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isDigit(c)) {
				continue ;
			} else {
				return false;
			}
		}
		int num = Integer.parseInt(str);
		if (num < 1920 || num > 2002) {
			return false;
		}
		return true;
	}


	public boolean isValidIyr(String str) {
		int countDiGit = 0;
		
		if (str.length() != 4) {
			return false;
		}
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isDigit(c)) {
				continue ;
			} else {
				return false;
			}
		}
		int num = Integer.parseInt(str);
		if (num < 2010 || num > 2020) {
			return false;
		}
		return true;
	}

	public boolean isValidEyr(String str) {
		int countDiGit = 0;
		
		if (str.length() != 4) {
			return false;
		}
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isDigit(c)) {
				continue ;
			} else {
				return false;
			}
		}
		int num = Integer.parseInt(str);
		if (num < 2020 || num > 2030) {
			return false;
		}
		return true;
	}

	public boolean isValidHgt(String str) {
		int num = 0;
		int i = -1;
		String type;

		if (str.length() < 4 || str.length() > 5) {
			return false;
		}
		while(++i < str.length()) {
			char c = str.charAt(i);
			if (Character.isDigit(c)) {
				num = num * 10 + Character.getNumericValue(c);
			} else {
				break;
			}
		}
		type = str.substring(i);
		if (type.equals("cm")) {
			if (num < 150 || num > 193) {
				return false;
			} else {
				return true;
			}
		} else if (type.equals("in")) {
			if (num < 59 || num > 76) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean isValidHcl(String str) {
		int i = -1;

		if (str.length() != 7) {
			return false;
		}
		if (str.charAt(++i) != '#') {
			return false;
		}
		while (++i < str.length()) {
			char c  = str.charAt(i);
			if ((c >= '0' && c <= '9') || (c >= 'a' && c <='f')) {
				continue ;
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean isValidEcl(String str) {
		if (str.length() != 3) {
			return false;
		}
		if (str.equals("amb") || str.equals("blu") || str.equals("brn") || str.equals("gry") || str.equals("grn") || str.equals("hzl") || str.equals("oth")) {
			return true;
		}
		return false;
	}

	public boolean isValidPid(String str) {
		int i = -1;

		if (str.length() != 9) {
			return false;
		}
		while (++i < str.length()) {
			char c = str.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
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