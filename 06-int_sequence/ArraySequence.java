import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArraySequence implements IntegerSequence {
	int currentIndex;
	int[] data;

	public ArraySequence(int[] other) {
		data = other.clone();
	}

	public ArraySequence(IntegerSequence otherseq) {
		otherseq.reset();
		data = new int[otherseq.length()];

		for (int i = 0; i < otherseq.length(); i++) {
			data[i] = otherseq.next();
		}
	}

	public boolean hasNext() {
		return currentIndex != data.length;
	}

	public int next() {
		if (!hasNext()) throw new NoSuchElementException();

		currentIndex++;
		return data[currentIndex - 1];
	}

	public int length() {
		return data.length;
	}

	public void reset() {
		currentIndex = 0;
	}
}
