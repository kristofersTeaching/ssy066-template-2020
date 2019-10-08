package ssy066.part1;

import java.util.HashMap;
import java.util.Map;


/**
 * This logical connective evaluates AND between the two predicates x and y.
 * 
 * @author Kristofer
 *
 */
public class AND implements Predicate {
	private final Predicate x;
	private final Predicate y;
	
	public AND(Predicate x, Predicate y){
		this.x = x;
		this.y = y;
	}

	/**
	 * This method should implement the AND evaluation.
	 */
	public boolean eval(State s) {
        throw new NotImplementedException();
	}

	// Do not change below
	
	@Override
	public String toString() {
		return "(" + x.toString() + " AND " + y.toString() + ")";
	}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AND)) return false;

        AND and = (AND) o;

        if (x != null ? !x.equals(and.x) : and.x != null) return false;
        if (y != null ? !y.equals(and.y) : and.y != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x != null ? x.hashCode() : 0;
        result = 31 * result + (y != null ? y.hashCode() : 0);
        return result;
    }
}
