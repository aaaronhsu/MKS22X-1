public class OrderedArrayList<T extends Comparable<T>> extends NoNullArrayList<T> {
	
	OrderedArrayList() {
		super();
	}

	OrderedArrayList(int n) {
		super(n);
	}

	public boolean add(T v) throws IllegalArgumentException {
		boolean suc = super.add(v);

		sort();

		return suc;
	}

	public void add(int n, T v) throws IllegalArgumentException {
		if (v == null) throw new IllegalArgumentException();

		super.add(n, v);
		
		sort();
	}

	public T set(int n, T v) throws IllegalArgumentException {
		if (v == null) throw new IllegalArgumentException();

		T hold = super.remove(n);

		super.add(n, v);

		sort();

		return hold;
	}

	private void sort() {
		boolean more = true;
		
		while (more) {
			more = false;

			for (int i = 0; i < size() - 1; i++) {

				if (get(i).compareTo(get(i + 1)) > 0) {
					T hold = get(i + 1);

					set(i + 1, get(i));
					set(i, hold);

					more = true;
				}

			}

		}
	}
}
