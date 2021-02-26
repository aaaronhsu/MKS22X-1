import java.util.NoSuchElementException;

public class Range implements IntegerSequence {
	private int start, end, current;

	public Range(int s, int e) {
		start = s;
		end = e;
		current = s;
	}

	public void reset() {
		current = start;
	}

	public int length() {
		return end - start + 1;
	}

	public boolean hasNext() {
		return current != end + 1;
	}

	public int next() {
		if (!hasNext()) throw new NoSuchElementException();

		current++;
		return current - 1;
	}
}
