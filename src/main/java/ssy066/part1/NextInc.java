package ssy066.part1;


/**
 * Implements the action v := value of v + inc. This is already implemented.
 * @author Kristofer
 *
 */
public class NextInc implements Action {
	private final String v;
	private final Integer inc;

	public NextInc(String v, Integer inc){
		this.v = v;
		this.inc = inc;
	}

    // Throws classcastexception if value is not an integer
	public State next(State s) {
        Object value = s.get(v);
        return s.newState(v, (Integer)value + inc);
	}

	@Override
	public String toString() {
		return  v + " += " + inc ;
	}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NextInc)) return false;

        NextInc next = (NextInc) o;

        if (inc != null ? !inc.equals(next.inc) : next.inc != null) return false;
        if (v != null ? !v.equals(next.v) : next.v != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = v != null ? v.hashCode() : 0;
        result = 31 * result + (inc != null ? inc.hashCode() : 0);
        return result;
    }
}
