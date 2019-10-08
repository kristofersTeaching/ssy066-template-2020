package ssy066.part1;

/**
 * This is an interface used by the atomic predicates and the connectives.
 * 
 * You do not need to change it.
 * 
 * @author Kristofer
 *
 */
public interface Predicate {
	boolean eval(State s);
}
