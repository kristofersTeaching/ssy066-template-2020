package ssy066.part2;

import ssy066.part1.*;

import java.util.LinkedList;
import java.util.List;

/**
 * This class is a wrapper around the result of the graph search. It just includes path
 * to the goal as well the cost.
 * 
 * @author Kristofer
 *
 */
public class SearchResult {
	private final List<String> pathToGoal;
	private final int costToGoal;

	public SearchResult(List<String> pathToGoal, int costToGoal) {
		this.pathToGoal = new LinkedList<>(pathToGoal);
		this.costToGoal = costToGoal;
	}

	public SearchResult() {
		this.pathToGoal = new LinkedList<>();
		this.costToGoal = -1;
	}



	public List<String> getPath() {
		return new LinkedList<>(pathToGoal);
	}

	public int getCostToGoal() {
		return costToGoal;
	}

	@Override
	public String toString() {
		return "Result: [" +
				"path=" + this.pathToGoal+ ", " +
				"costToGoal=" + costToGoal
				+ "]";
	}



}
