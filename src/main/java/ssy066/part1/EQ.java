package ssy066.part1;

import ssy066.part1.Predicate;


/**
 * This class implements a predicate that checks if the variable is EQUAL to a 
 * specific value.
 * 
 * @author Kristofer
 *
 */
public class EQ implements Predicate {
	private final String v;
	private final Object value;


	/**
	 * This constructor is creating a predicate that checks for
	 * equality against a value. p(v) : v = value
	 * @param v String - is the variable
	 * @param value Object - the value the variable should be equal to. 
	 */
	public EQ(String v, Object value) {
		this.v = v;
		this.value = value;
	}

	/**
	 * Given a State, evaluates the equality of the variable state and the given value.
	 * Remember that in java, == means object equality and may not work as expected...
	 * 
	 * returns true if they are equal
	 */
	public boolean eval(State s) {
		throw new NotImplementedException();

	}


	// Do not change below

	@Override
	public String toString() {
		return v + " = " + value.toString();
	}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EQ)) return false;

        EQ eq = (EQ) o;

        if (v != null ? !v.equals(eq.v) : eq.v != null) return false;
        if (value != null ? !value.equals(eq.value) : eq.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = v != null ? v.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
