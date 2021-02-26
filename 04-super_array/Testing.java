import java.util.Arrays;

public class Testing {

	public static void main(String[] args) {
		SuperArray a = new SuperArray();
		SuperArray b = new SuperArray();

		a.add("1");
		a.add("4");
		a.add("3");
		a.add("7");
		a.add("5");
		a.add("4");

		b.add("1");
		b.add("4");
		b.add("3");
		b.add("7");
		b.add("5");
		b.add("2");

		System.out.println(a.equals(b));
	}

	public static void removeDuplicates(SuperArray s) {
		for (int i = s.size() - 1; i >= 0; i--) {
			if (s.indexOf(s.get(i)) != i) s.remove(i);
		}
	}

	public static SuperArray findOverlap(SuperArray a, SuperArray b) {
		SuperArray hold = new SuperArray(a.size());

		for (int i = 0; i < a.size(); i++) {
			if (b.contains(a.get(i))) hold.add(a.get(i));
		}

		removeDuplicates(hold);
		return hold;
	}
}
