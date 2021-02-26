import java.util.*;

public class PigLatin {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		while (in.hasNextLine()) {
			Scanner s = new Scanner(in.nextLine());
			
			while (s.hasNext()) {
				
				System.out.print(pigLatinSimple(s.next()));

				if (s.hasNext()) System.out.print(" ");
			}

			if (in.hasNext()) System.out.println();
		}
	}

	public static String pigLatinSimple(String s) {
		s = s.toLowerCase();
		char first = s.charAt(0);

		if (s.length() == 1) {
			if (first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u') return s + "hay";
			return s + "ay";
		}

		if (first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u') return s + "hay";

		return s.substring(1) + s.charAt(0) + "ay";
	}

	public static String pigLatin(String s) {
		s = s.toLowerCase();
		char first = s.charAt(0);
		ArrayList<String> dia = new ArrayList<>(Arrays.asList(new String[] {"bl", "br", "ch", "ck", "cl", "cr", "dr", "fl", "fr", "gh", "gl", "gr", "ng", "ph", "pl", "pr", "qu", "sc", "sh", "sk", "sl", "sm", "sn", "sp", "st", "sw", "th", "tr", "tw", "wh", "wr"}));

		if (s.length() == 1) {
			if (first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u') return s + "hay";
			return s + "ay";
		}

		if (dia.contains(s.substring(0, 2))) return s.substring(2) + s.substring(0, 2) + "ay";
		else if (first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u') return s + "hay";

		return s.substring(1) + s.charAt(0) + "ay";
	}

	public static String pigLatinBest(String s) {
		s = s.toLowerCase();
		
		char first = s.charAt(0);
		char last = s.charAt(s.length() - 1);

		if (!((48 <= first && first <= 57) || (97 <= first && first <= 122))) return s;
		
		else if (!((48 <= last && last <= 57) || (97 <= last && last <= 122))) return pigLatin(s.substring(0, s.length() - 1)) + last;
		
		return pigLatin(s);
	}
}
