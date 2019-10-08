package ssy066.part2;

import java.util.*;

import ssy066.part1.*;


public class GraphFactory {


    /**
     * This is a so called factory method. It makes graphs.
     * Creates a Graph based on a set of operations and an initial state. If you divide this method
     * into multiple parts, do not forget to make your methods in this file public static.
     * Remember that you must create your own implementation of the interface Graph
     *
     * @param operations All the operations in the system
     * @param init       The initial state
     * @return The graph
     */
    public static Graph makeMeAGraph(Set<Operation> operations, State init) {
        Graph g = new Graph(init);

        // Implement your graph making code here. Use separate methods for each part and create your
        // unit tests for them. Do not forget to make your methods in this file public static.

        return g;
    }
}