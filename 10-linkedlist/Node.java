public class Node {
	private String data;
	private Node prev, next;

	Node(String s) {
		data = s;
	}

	public String getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setData(String s) {
		data = s;
	}

	public void setNext(Node n) {
		next = n;
	}

	public void setPrev(Node n) {
		prev = n;
	}
}