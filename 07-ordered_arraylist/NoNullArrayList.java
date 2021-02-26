import java.util.ArrayList;

class NoNullArrayList<T> extends ArrayList<T> {
	
	NoNullArrayList() {
		super();
	}

	NoNullArrayList(int n) {
		super(n);
	}

	public boolean add(T v) throws IllegalArgumentException {
		if (v == null) throw new IllegalArgumentException();

		return super.add(v);
	}

	public void add(int n, T v) throws IllegalArgumentException {
		if (v == null) throw new IllegalArgumentException();

		super.add(n, v);
	}

	public T set(int n, T v) throws IllegalArgumentException {
		if (v == null) throw new IllegalArgumentException();

		return super.set(n, v);
	}

}