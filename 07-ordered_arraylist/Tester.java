public class Tester {
	public static void main(String[] args) {
		
		OrderedArrayList<Integer> hold = new OrderedArrayList<>();

		hold.add(5);

		hold.add(2);
		hold.add(100);

		hold.set(1, null);
		for (int i : hold) {
			System.out.println(i);
		}
	}
}
