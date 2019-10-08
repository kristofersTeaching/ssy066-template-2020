package ssy066.part1;


/**
 * Implements the action v := value of v - dec. This is already implemented.
 * @author Kristofer
 *
 */
public class NextDec implements Action {
	private final String v;
	private final Integer dec;

	public NextDec(String v, Integer dec){
		this.v = v;
		this.dec = dec;
	}

    // Throws classcastexception if value is not an integer
	public State next(State s) {
        Object value = s.get(v);
        return s.newState(v, (Integer)value - dec);
	}

	@Override
	public String toString() {
		return  v + " -= " + dec;
	}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NextDec)) return false;

        NextDec next = (NextDec) o;

        if (dec != null ? !dec.equals(next.dec) : next.dec != null) return false;
        if (v != null ? !v.equals(next.v) : next.v != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = v != null ? v.hashCode() : 0;
        result = 31 * result + (dec != null ? dec.hashCode() : 0);
        return result;
    }
}
