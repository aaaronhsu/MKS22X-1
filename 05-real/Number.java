public abstract class Number {
	
	public abstract double getValue();

	public int compareTo(Number other) {
		if (getValue() == other.getValue()) return 0;
		return getValue() < other.getValue() ? -1 : 1;
	}

	public boolean equals(Number other) {
		if (this.getValue() == 0 && other.getValue() == 0) return true;

		if (Math.abs((other.getValue() - getValue())) < 0.00001 * other.getValue()
            && Math.abs((other.getValue() - getValue())) < 0.00001 * getValue())
      	return true;

		return false;
	}
}
