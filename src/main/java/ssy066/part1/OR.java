package ssy066.part1;



/**
 * This logical connective evaluates OR between the two predicates
 * x and y.
 * 
 * @author Kristofer
 *
 */
public class OR implements Predicate {
	private final Predicate x;
	private final Predicate y;
	
	public OR(Predicate x, Predicate y){
		this.x = x;
		this.y = y;
	}

	/**
	 * This method should implement the OR evaluation.
	 */
	public boolean eval(State s) {
        throw new NotImplementedException();
	}


	// Do not need to change below
	
	@Override
	public String toString() {
		return "(" + x.toString() + " OR " + y.toString() + ")";
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OR)) return false;

        OR or = (OR) o;

        if (x != null ? !x.equals(or.x) : or.x != null) return false;
        if (y != null ? !y.equals(or.y) : or.y != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x != null ? x.hashCode() : 0;
        result = 31 * result + (y != null ? y.hashCode() : 0);
        return result;
    }
}
