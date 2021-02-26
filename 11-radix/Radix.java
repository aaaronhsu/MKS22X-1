import javax.swing.text.html.MinimalHTMLWriter;

public class Radix {
	public static int nth(int n, int col) {
		n /= Math.pow(10, col);

		return n % 10 < 0 ? n * -1 % 10 : n % 10;
	}

	public static int length(int n) {
		if (n == 0) return 1;
		if (n < 0) n = n * -1;
    	return (int) Math.log10(n) + 1;
	}

	public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
		for (SortableLinkedList i : buckets) {
			original.extend(i);
		}
	}

	public static void radixSortSimple(SortableLinkedList data) {
		int maxLen = 0;

		SortableLinkedList[] buckets = new SortableLinkedList[10];
		for (int a = 0; a < 10; a++) buckets[a] = new SortableLinkedList();
			
		while (data.size() != 0) {
			int hold = data.remove(0);

			maxLen = Integer.max(length(hold), maxLen);
			buckets[nth(hold, 0)].add(hold);
		}

		merge(data, buckets);

		for (int i = 1; i < maxLen; i++) {
			buckets = new SortableLinkedList[10];
			for (int a = 0; a < 10; a++) buckets[a] = new SortableLinkedList();
			
			while (data.size() != 0) {
				int hold = data.remove(0);
				buckets[nth(hold, i)].add(hold);
			}

			merge(data, buckets);
		}
	}

	public static void radixSort(SortableLinkedList data) {
		SortableLinkedList negative = new SortableLinkedList();
		SortableLinkedList positive = new SortableLinkedList();
		
		while (data.size() != 0) {
			int a = data.remove(0);

			if (a < 0) negative.add(a * -1);
			else positive.add(a);
		}

		radixSortSimple(negative);
		radixSortSimple(positive);

		while (negative.size() != 0) {
			data.add(negative.remove(negative.size() - 1) * -1);
		}

		data.extend(positive);
	}
}