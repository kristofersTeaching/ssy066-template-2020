package ssy066.part1;



import java.util.*;

/**
 * The operation is a simplified version of our operations. It is only a precondition with
 * a guard and a set of actions. It does not keep track of its state, so in later algorithms,
 * that need to be taken care of by someone else.
 * 
 * @author Kristofer
 *
 */
public class Operation {
	public final String name;
	private final Predicate guard;
	private final List<Action> actions;
	private final int cost;
	
	/**
	 * Evaluates if the operation is allowed to execute.
	 * @param s The current State
	 * @return If the operation is allowed to start
	 */
	public boolean eval(State s) {
        throw new NotImplementedException();

	}

	/**
	 * Updates the state based on its actions.
	 *
	 * @param s Current state
	 * @return the updated state, or throw IllegalStateException if the operation evaluates to false.
	 */
	public State execute(State s) {
        throw new NotImplementedException();
	}


    // You do not need to change anything below

    /**
     * Creates an immutable operation with a precondition.
     * @param name The name of the operation
     * @param guard The guard predicate stating when the operation can execute
     * @param actions A List of actions
     */
    public Operation(String name, Predicate guard, List<Action> actions, int cost){
        this.name = name;
        this.guard = guard;
        this.actions = new LinkedList<Action>(actions);
        this.cost = cost;
    }
    public Operation(String name){this(name, new TrueGuard(), new LinkedList<Action>(), 1);}
    public Operation(String name, Predicate guard){this(name, guard, new LinkedList<Action>(), 1);}
    public Operation(String name, Action action){this(name, new TrueGuard(), Arrays.asList(action), 1);}
    public Operation(String name, List<Action> actions){this(name, new TrueGuard(), actions, 1);}
    public Operation(String name, Predicate guard, Action action){this(name, guard, Arrays.asList(action), 1);}
    public Operation(String name, Predicate guard, List<Action> actions){this(name, guard, actions, 1);}

    /**
     * The cost of the operation
     * @return the cost in int
     */
    public int cost(){
        return cost;
    }

	@Override
	public String toString() {
		return name;
	}
	
	/**
	 * Use this method in System.out.println when troubleshooting and for info
	 * @return The operation condition as string
	 */
	public String conditionAsString() {
		// lamdas version!
		// String act = actions.stream().map(Object::toString).collect(Collectors.joining (","));

		String act = "";
        for (Action a : actions){
            act += a.toString() + "; ";
        }

        return name +" : "+ guard.toString()  + "/" + act +" cost:"+ cost;
	}

}
