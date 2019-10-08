package ssy066.part1;

import ssy066.part1.Predicate;

/**
 * Used when a guard should be always true. Already implemented
 * 
 * @author Kristofer
 *
 */
public class TrueGuard implements Predicate {

	public boolean eval(State s) {
		return true;
	}

	@Override
	public String toString() {
		return "true";
	}

}
