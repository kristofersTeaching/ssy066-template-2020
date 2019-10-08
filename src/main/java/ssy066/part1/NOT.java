package ssy066.part1;



/**
 * This predicate negates the result of the included 
 * predicate. This class is already implemented.
 * 
 * @author Kristofer
 *
 */
public class NOT implements Predicate {
	private final Predicate x;
	
	public NOT(Predicate x){
		this.x = x;
	}

	public boolean eval(State s) {
        return !x.eval(s);
	}
	
	@Override
	public String toString() {
		return "NOT " + x.toString();
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NOT)) return false;

        NOT not = (NOT) o;

        if (x != null ? !x.equals(not.x) : not.x != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return x != null ? x.hashCode() : 0;
    }
}
