package ssy066.part1;


/**
 * Implements the action v := value.
 * @author Kristofer
 *
 */
public class Next implements Action {
	private final String v;
	private final Object nextValue;
	
	public Next(String v, Object nextValue){
		this.v = v;
		this.nextValue = nextValue;
	}

    /**
     * assign the value nextValue to variable v in the state.
     * @param s Current state
     * @return an updated state
     */
	public State next(State s) {
        throw new NotImplementedException();

	}

	@Override
	public String toString() {
		return  v + " := " + nextValue ;
	}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Next)) return false;

        Next next = (Next) o;

        if (nextValue != null ? !nextValue.equals(next.nextValue) : next.nextValue != null) return false;
        if (v != null ? !v.equals(next.v) : next.v != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = v != null ? v.hashCode() : 0;
        result = 31 * result + (nextValue != null ? nextValue.hashCode() : 0);
        return result;
    }
}
