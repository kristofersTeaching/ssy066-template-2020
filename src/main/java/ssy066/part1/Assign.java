package ssy066.part1;



/**
 * Implements the action v := value of otherVar.
 * @author Kristofer
 *
 */
public class Assign implements Action {
	private final String v;
	private final String otherVar;

	public Assign(String v, String otherVar){
		this.v = v;
		this.otherVar = otherVar;
	}

    /**
     * Get the value of otherVar from the state and assign it to variable v.
     * @param s Current state
     * @return an updated state
     */
	public State next(State s) {
        throw new NotImplementedException();

	}

	@Override
	public String toString() {
		return  v + " := " + otherVar;
	}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Assign)) return false;

        Assign next = (Assign) o;

        if (otherVar != null ? !otherVar.equals(next.otherVar) : next.otherVar != null) return false;
        if (v != null ? !v.equals(next.v) : next.v != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = v != null ? v.hashCode() : 0;
        result = 31 * result + (otherVar != null ? otherVar.hashCode() : 0);
        return result;
    }
}
