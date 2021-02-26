public class SuperArray {

	private String[] data;
	private int size = 10;

	public SuperArray() {
		data = new String[10];
	}

	public SuperArray(int initialCapacity) {
		if (initialCapacity < 0) throw new IllegalArgumentException();

		data = new String[initialCapacity];
		size = initialCapacity;
	}

	public int size() {
		for (int i = size - 1; i >= 0; i--) {
			if (data[i] != null) return i + 1;
		}
		return 0;
	}

	public boolean add(String element) {
		if (size() != size) {
			data[size()] = element;
			return true;
		}

		resize();
		return add(element);
	}

	public String get(int index) {
		if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
		if (index >= size()) return null;
		return data[index];
	}

	public String set(int index, String element) {
		if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
		String hold = data[index];
		if (hold == null) return null;
		data[index] = element;
		return hold;
	}

	private void resize() {
		String[] hold = new String[size * 2];
		if (size == 0) hold = new String[1];
		
		for (int i = 0; i < size; i++) {
			hold[i] = data[i];
		}

		data = hold;
		size = data.length;

	}

	public boolean isEmpty() {
		if (size == 0 || data[0] == null) return true;
		return false;
	}

	public void clear() {
		data = new String[10];
		size = 10;
	}

	public String toString() {
		if (size() == 0) return "[]";
		String hold = "[";

		for (int i = 0; i < size() - 1; i++) {
			hold += data[i] + ", ";
		}
		hold += data[size() - 1] + "]";
		return hold;
	}

	public boolean contains(String s) {
		for (int i = 0; i < size(); i++) {
			if (s.equals(data[i])) return true;
		}
		return false;
	}

	public void add(int index, String element) {
		if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
		if (size() == size) resize();

		for (int i = size(); i > index; i--) {
			data[i] = data[i - 1];
		}

		data[index] = element;
	}

	public String remove(int index) {
		if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
		String hold = data[index];

		for (int i = index; i < size() - 1; i++) {
			data[i] = data[i + 1];
		}

		data[size() - 1] = null;
		return hold;
	}

	public int indexOf(String s) {
		for (int i = 0; i < size(); i++) {
			if (data[i].equals(s)) return i;
		}
		return -1;
	}

	public String[] toArray() {
		String[] hold = new String[size()];

		for (int i = 0; i < size(); i++) {
			hold[i] = data[i];
		}

		return hold;
	}

	public int lastIndexOf(String value) {
		int hold = -1;

		for (int i = 0; i < size(); i++) {
			if (get(i).equals(value)) hold = i;
		}

		return hold;
	}
 
	public boolean equals(SuperArray other) {
		if (other.size() != size()) return false;

		for (int i = 0; i < size(); i++) {
			if (!other.get(i).equals(get(i))) return false;
		}

		return true;
	}
}