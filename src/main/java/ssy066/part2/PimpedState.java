package ssy066.part2;

import ssy066.part1.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Use this to store the state together with the path to it and the cost
 * @author Kristofer
 *
 */
class PimpedState {
	public final State state;
	private final List<Transition> pathToState;
	private final int costToState;
	
	public PimpedState(State state, List<Transition> pathToState, int costToState){
		this.state = state;
		this.pathToState = new LinkedList<Transition>(pathToState);
		this.costToState = costToState;
	}
	
	/**
	 * This represent the transitions to reach this state
	 * @return
	 */
	public List<Transition> pathToState() {
		return new LinkedList<>(pathToState);
	}

	/**
	 * This represent the labels on the transitions taken to reach this state
	 * @return
	 */
	public List<String> labelsToState() {
		LinkedList<String> res = new LinkedList<>();
		for (Transition t: this.pathToState) {
			res.push(t.label);
		}
		return res;
	}
	
	
	public int cost() {
		return costToState;
	}


	@Override
	public String toString() {
		return "PimpedState: [" +
				"state=" + this.state
				+ ", pathToState=" + this.pathToState + ", " +
				"cost=" + this.costToState
				+ "]";
	}




}
