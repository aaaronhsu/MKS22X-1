public class MyLinkedList {
	private int size;
	private Node start, end;

	public MyLinkedList() {
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean add(String value) {
		Node n = new Node(value);

		if (start == null) {
			start = n;
			end = n;
		}
		else {
			n.setPrev(end);
			end.setNext(n);
			end = n;
		}

		size++;

		return true;
	}

	public void add(int index, String value) throws IndexOutOfBoundsException {

		if (index == 0) {
			Node newNode = new Node(value);
			newNode.setNext(start);

			start.setPrev(newNode);
			start = newNode;
			size++;

			return;
		}
		if (index == size) {
			add(value);
			return;
		}

		Node prev = getNode(index - 1);
		Node next = getNode(index);

		Node newNode = new Node(value);
		newNode.setPrev(prev);
		newNode.setNext(next);

		prev.setNext(newNode);
		next.setPrev(newNode);
		size++;

		return;
	}

	public String get(int index) throws IndexOutOfBoundsException {
		return getNode(index).getData();
	}

	public String set(int index, String value) throws IndexOutOfBoundsException {
		Node n = getNode(index);

		String s = n.getData();
		n.setData(value);

		return s;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[");

		Node n = start;
		while (n != null) {
			str.append(n.getData());

			if (n.getNext() != null) str.append(", ");
			n = n.getNext();
		}

		str.append("]");
		return str.toString();
	}

	public String reverseToString() {
		StringBuilder str = new StringBuilder();
		Node n = end;
		while (n != null) {
			str.append(n.getData());

			if (n.getPrev() != null) str.append(", ");
			n = n.getPrev();
		}

		return str.toString();
	}

	public String remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();

		if (size() == 1) {
			String ret = start.getData();
			start = null;
			end = null;

			size--;
			return ret;
		}
		if (index == 0) {
			String ret = start.getData();

			start = start.getNext();
			start.getPrev().setNext(null);
			start.setPrev(null);

			size--;
			return ret;
		}
		if (index == size() - 1) {
			String ret = end.getData();

			end = end.getPrev();

			end.getNext().setPrev(null);
			end.setNext(null);

			size--;
			return ret;
		}

		Node prev = getNode(index - 1);
		Node rem = getNode(index);
		Node next = getNode(index + 1);

		String ret = rem.getData();

		prev.setNext(next);
		next.setPrev(prev);

		rem.setNext(null);
		rem.setPrev(null);
		
		size--;
		return ret;
	}

	public void extend(MyLinkedList other) {
		if (start == null) {
			start = other.start;
			end = other.end;
			return;
		}

		end.setNext(other.start);
		end = other.end;
		
		other.start.setPrev(end);

		size += other.size();

		other.start = null;
		other.end = null;
		other.size = 0;
	}

	private Node getNode(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

		Node n = start;
		for (int i = 0; i < index; i++) n = n.getNext();

		return n;
	}
}