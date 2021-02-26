import java.util.*;

import javax.print.event.PrintJobAdapter;

public class Testing {
	public static void main(String[] args) {

		LinkedList<Integer> a = new LinkedList<>();

		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);

		a.set(3, 2);

		System.out.println(a.toString());
		// MyLinkedList a = new MyLinkedList();

		// a.add("1");
		// a.add("2");
		// a.add("3");

		// MyLinkedList b = new MyLinkedList();

		// b.add("4");
		// b.add("5");
		// b.add("6");

		// a.extend(b);

		// a.remove(4);
		// System.out.println(a.size());
		// System.out.println(a.toString());
	}
}
