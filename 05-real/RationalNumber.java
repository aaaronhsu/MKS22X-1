public class RationalNumber extends Number
{
  	private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *	@param nume the numerator
  *	@param deno the denominator
  */
  	public RationalNumber(int nume, int deno){
      super();

      if (deno == 0 || nume == 0) {
        numerator = 0;
        denominator = 1;
      }
      else if (deno < 0) {
        numerator = nume * -1;
        denominator = deno * -1;
      }
      else {
        numerator = nume;
        denominator = deno;
      }

      reduce();
    }

  	public double getValue(){
  	  	return (double) numerator / denominator;
  	}

  /**
  *	@return the numerator
  */
  	public int getNumerator(){
    	return numerator;
  	}
  /**
  *	@return the denominator
  */
  	public int getDenominator(){
    	return denominator;
  	}
  /**
  *	@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  	public RationalNumber reciprocal(){
    	return new RationalNumber(getDenominator(), getNumerator());
  	}
  /**
  *	@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  	public boolean equals(RationalNumber other){
    	return getNumerator() == other.getNumerator() && getDenominator() == other.getDenominator();
  	}


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  	public String toString(){
      if (getDenominator() == 1) return "" + getNumerator();
      if (getNumerator() == 0) return "0";
    	return getNumerator() + "/" + getDenominator();
  	}

  /**Calculate the GCD of two integers.
  *	@param a the first integers
  *	@param b the second integer
  *	@return the value of the GCD
  */
  	public static int gcd(int a, int b){
    /*use euclids method or a better one*/
    http://sites.math.rutgers.edu/~greenfie/gs2004/euclid.html
      if (a == 0 || b == 0) return 1;
      
      while (a != b) {
        if (a > b) a = a - b;
        else b = b - a;
      }

      return b;
  	}

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  	private void reduce(){
      int gcd = gcd(getNumerator(), getDenominator());

      numerator /= gcd;
      denominator /= gcd;
  	}
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  	public RationalNumber multiply(RationalNumber other){
      int n = getNumerator() * other.getNumerator();
      int d = getDenominator() * other.getDenominator();

      return new RationalNumber(n, d);
  	}

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  	public RationalNumber divide(RationalNumber other){
      return multiply(other.reciprocal());
  	}

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  	public RationalNumber add(RationalNumber other){
      int n = (getNumerator() * other.getDenominator()) + (other.getNumerator() * getDenominator());
      int d = getDenominator() * other.getDenominator();

      return new RationalNumber(n, d);
  	}
  /**
  *Return a new RationalNumber that this minus the other
  */
  	public RationalNumber subtract(RationalNumber other){
    	int n = (getNumerator() * other.getDenominator()) - (other.getNumerator() * getDenominator());
      int d = getDenominator() * other.getDenominator();
      
      return new RationalNumber(n, d);
  	}
} 