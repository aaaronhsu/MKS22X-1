import java.util.Arrays;

public class Demo {
	public static void main(String[] args) {
		
		SuperArray a = new SuperArray();
		SuperArray b = new SuperArray();

		for (int i = 0; i < 5; i++) {
			a.add(i + "");

			b.add(i + "");
		}

		b.add("asdf");
		b.add("qwer");
		b.add("zxcv");

		System.out.println(Arrays.toString(zip(b, a).toArray()));
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

	public static SuperArray zip(SuperArray a, SuperArray b) {

		SuperArray small = a.size() < b.size() ? a : b;
		SuperArray big = a.size() < b.size() ? b : a;

		SuperArray combined = new SuperArray();

		for (int i = 0; i < small.size(); i++) {
			combined.add(small.get(i));
			combined.add(big.get(i));
		}

		for (int i = small.size(); i < big.size(); i++) {
			combined.add(big.get(i));
		}

		return combined;
	}
}
