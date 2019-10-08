package ssy066.part2;

import junit.framework.TestCase;
import ssy066.part1.*;

import java.util.*;

/**
 * Based on the graph implementation, it is time to try out search strategies. You have to create
 * your own tests and implement a search strategy that can find both the shortest and lowest cost path.
 *
 * Your task is to implement the methods findShortestPath and findLowestCostPath in SearchAGraph, where a
 * graph have cost on each transition.
 *   .
 * You can decide how to implement them, but they need to work with any graph, also one with loops. Remember
 * to check your code from Test3, so it also includes the cost of the operation in the transition!
 *
 * If your end up with memory overflow or stack overflow, you are probably not considering the loops
 * in a correct way.
 *
 * 
 * @author Kristofer
 *
 */
public class Test4_Optimization extends TestCase {
	
	/**
	 * This is an example test to find the shortest path to a goal in the graph created in the method
	 * searchGraph_no_loops() below. There is a also another graph with loops defined in searchGraph_with_loops()
	 * which you also test your code against. Create new tests!
	 * 
	 * Add more printout for other methods in graph, for better help.
	 * 
	 * Remember that the operations and the transitions include cost (so that you added it in your Graph-making
	 * code from Test3). You can access it by calling the transition.cost() method. In the printout you will
	 * see the cost. Try out the test graphs in different tests as well as other goals
	 * 
	 * Tip: draw the graph by hand as a reference by looking at the definitions of the operations and the printout.
	 * 
	 */
	public void test_find_shortest_path() {
		Graph g = searchGraph_no_loops();
		SearchAGraph search = new SearchAGraph();

		Predicate goal = new EQ("v", 6);
		
		System.out.println("States in g: "+ g.getStates());
		System.out.println("Transitions in g: "+g.getTransitions());

		SearchResult result = search.findShortestPath(g, goal);

		LinkedList<String> shortestPath = new LinkedList<String>();
		shortestPath.add("o2");
		shortestPath.add("o8");

		System.out.println("found: "+ result.getPath());
		System.out.println("should be: "+shortestPath);

		assert(result.getPath().equals(shortestPath));
	}


	/**
	 * A test-model including cost in operations, does not have any loops
	 * @return the graph
	 */
	public Graph searchGraph_no_loops() {
		String v = "v";
		State testState;

		Predicate vEq0 = new EQ(v, 0);
		Predicate vEq1 = new EQ(v, 1);
		Predicate vEq2 = new EQ(v, 2);
		Predicate vEq3 = new EQ(v, 3);
		Predicate vEq4 = new EQ(v, 4);

		Action vInc = new NextInc(v,1);
		Action vDec = new NextDec(v,1);
		Action vInc2 = new NextInc(v,2);
		Action vTo4 = new Next(v,4);
		Action vTo6 = new Next(v,6);
		Action vTo7 = new Next(v,7);

		Operation o1 = new Operation("o1", vEq0, Arrays.asList(vInc), 1);
		Operation o2 = new Operation("o2", vEq0, Arrays.asList(vInc2), 3);
		Operation o3 = new Operation("o3", vEq1, Arrays.asList(vInc2), 4);
		Operation o4 = new Operation("o4", vEq1, Arrays.asList(vTo4), 2);
		Operation o5 = new Operation("o5", vEq3, Arrays.asList(vInc2), 1);
		Operation o6 = new Operation("o6", vEq4, Arrays.asList(vInc), 3);
		Operation o7 = new Operation("o7", vEq4, Arrays.asList(vInc2), 3);
		Operation o8 = new Operation("o8", vEq2, Arrays.asList(vTo6), 5);
		Operation o9 = new Operation("o9", vEq2, Arrays.asList(vTo7), 10);

		Map<String, Object> state = new HashMap<String, Object>();
		state.put(v, 0);
		State initial = new State(state);

		HashSet<Operation> operations =  new HashSet<Operation>();
		operations.add(o1); operations.add(o2);operations.add(o3);operations.add(o4);operations.add(o5);
		operations.add(o6); operations.add(o7);operations.add(o8);operations.add(o9);

		return GraphFactory.makeMeAGraph(operations, initial);
	}


	/**
	 * A test-model including cost in operations. Observe, include loops!
	 * @return the graph
	 */
	public Graph searchGraph_with_loops() {
		String v = "v";
		State testState;

		Predicate vEq0 = new EQ(v, 0);
		Predicate vEq1 = new EQ(v, 1);
		Predicate vEq2 = new EQ(v, 2);
		Predicate vEq3 = new EQ(v, 3);
		Predicate vEq4 = new EQ(v, 4);
		Predicate vEq5 = new EQ(v, 5);

		Action vInc = new NextInc(v,1);
		Action vDec = new NextDec(v,1);
		Action vInc2 = new NextInc(v,2);
		Action vTo4 = new Next(v,4);
		Action vTo6 = new Next(v,6);
		Action vTo0 = new Next(v,0);

		Operation o1 = new Operation("o1", vEq0, Arrays.asList(vInc), 1);
		Operation o2 = new Operation("o2", vEq0, Arrays.asList(vInc2), 3);
		Operation o3 = new Operation("o3", vEq1, Arrays.asList(vInc2), 4);
		Operation o4 = new Operation("o4", vEq1, Arrays.asList(vTo4), 2);
		Operation o5 = new Operation("o5", vEq3, Arrays.asList(vInc2), 1);
		Operation o6 = new Operation("o6", vEq4, Arrays.asList(vInc), 3);
		Operation o7 = new Operation("o7", vEq4, Arrays.asList(vInc2), 3);
		Operation o8 = new Operation("o8", vEq2, Arrays.asList(vTo6), 5);
		Operation o9 = new Operation("o9", vEq2, Arrays.asList(vTo0), 4);
		Operation o10 = new Operation("o10", vEq5, Arrays.asList(vTo0), 1);

		Map<String, Object> state = new HashMap<String, Object>();
		state.put(v, 0);
		State initial = new State(state);

		HashSet<Operation> operations =  new HashSet<Operation>();
		operations.add(o1); operations.add(o2);operations.add(o3);operations.add(o4);operations.add(o5);
		operations.add(o6); operations.add(o7);operations.add(o8);operations.add(o9);operations.add(o10);

		return GraphFactory.makeMeAGraph(operations, initial);
	}




}
