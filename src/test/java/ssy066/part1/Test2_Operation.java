package ssy066.part1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

/**
 * It is time to use the state that we created in test 1.
 * In this test we will work with predicates, actions and operations. Like in test1, try to make each test
 * below pass by updating the missing code in the various files.
 *
 * A predicate is a function that is either true of false, given a state. Every predicate implements the interface
 * Predicate, @see ssy066.part1.Predicate, which defined one method, boolean eval(State s).
 * Your task is to update some of the predicates that implements this method, like EQ, AND, OR...
 *
 * After that you will work with classes that implements the Action interface. That interface defines the method
 * State next(State s), which takes a state and update some of the variable values of that state and returns
 * a new state. You have to complete some of these actions, like Next and Assign.
 *
 * When you have both predicates and actions, you finally can implement the operation. An operaiton has a guard
 * (a predicate) when it can start, and a list of actions that happens when the operation start.
 *
 *
 *
 * 
 * @author Kristofer
 *
 */
public class Test2_Operation extends TestCase {
	
	// these are used in the tests and are initialized in the setUp() method. You do not
	// need to change it.
	private String v1 = "v1";
	private String v2 = "v2";
	private String v3 = "v3";
	private Map<String, Object> initMap;
    private State testState;
	
	/**
	 * This is the setup method for the variables that are used. This is run before each test.
	 * Scroll down for the tests!!
	 */
	protected void setUp() {
		initMap = new HashMap<String, Object>();
		initMap.put(v1, 0);
        initMap.put(v2, false);
        initMap.put(v3, "Initial");
		testState = new State(initMap);
	}
	
	
	
	
	/**
	 * Here you need to implement the evaluation method eval of a predicate.
	 * The predicate Eq is created with a variable and a value. The eval method
	 * check if the variable in the state state is equal to a given value, p(x): x = value.
	 * 
	 * We will only use Equal and not. <, >, =>, x > y+c,  etc are not implemented, but it is easy to add 
	 * that later. If you are interested after completing the assignment, try it by creating new
	 * tests and classes that uses these operators.
	 */
	public void test2_1_PredicateEqual() {
		Predicate p1 = new EQ(v1, 0);
		Predicate p2 = new EQ(v2, true);
		
		assertTrue(p1.eval(testState));
		assertFalse(p2.eval(testState));
	}
	
	/**
	 * The same as test1 but for strings. Hint, you do not have to check each variable type, so
	 * if you implemented test1 correct, this should just pass.
	 */
	public void test2_2_PredicateString(){
		Predicate p1 = new EQ(v3, "Initial");
		Predicate p2 = new EQ(v3, "Running");
		
		assertTrue(p1.eval(testState));
		State newS = testState.newState(v3, "Running");
		assertTrue(p2.eval(newS));
	}
	
	/**
	 * Our atomic predicate Eq can be combined with the connective AND. 
	 * Implement the eval method in the AND class. Also note that this 
	 * test is also using the NOT connective, which you need to implement.
	 * 
	 * Note that Eq, AND, OR, NOT are predicates and that AND, OR, NOT takes
	 * another predicate as parameter. This gives us the possibility to create
	 * a hierarchy of predicates, hence we can create any statement. 
	 */
	public void test2_3_PredicateAND() {
		Predicate p1 = new EQ(v1, 0);
		Predicate p2 = new EQ(v2, true);
		Predicate p3 = new EQ(v3, "Initial");
		
		Predicate AND1 = new AND(p1, p3);
		Predicate AND2 = new AND(AND1, new NOT(p2));
		Predicate AND3 = new AND(p1, p2);

		
		assertTrue(AND1.eval(testState));
		assertTrue(AND2.eval(testState));
		assertFalse(AND3.eval(testState));
	}
	
	/**
	 * As above, but for OR.
     *
	 */
	public void test2_4_PredicateOR() {
        Predicate p1 = new EQ(v1, 0);
        Predicate p2 = new EQ(v2, true);
        Predicate p3 = new EQ(v3, "Initial");

        Predicate OR1 = new OR(p1, p3);
        Predicate OR2 = new OR(p2, p3);
        Predicate OR3 = new OR(p2, p2);

		
		assertTrue(OR1.eval(testState));
		assertTrue(OR2.eval(testState));
		assertFalse(OR3.eval(testState));


	}
	
	/**
	 * This is a test that you have to write yourself. So you need to change the test!!
	 * Instead of the line Predicate p1 = new TrueGuard();, you should create the predicate:
	 * 
	 *    p1 = ((v1 = 0 AND NOT (v2 = true)) OR (v3 = "Running" OR (v2 == true))
	 *    
	 * Study how the predicates are constructed in the tests and study the classes. It is 
	 * much easier if you create multiple sub-predicates on multiple lines! And to make the
	 * test pass, you need to keep the order of the predicates. Look at the printout in the 
	 * console and compare it with my check. If you remove all ( and ) it should be equal.
	 * 
	 */
	public void test2_5_writingPredicates() {
		throw new NotImplementedException();

	}
	
	/**
	 * Now we will implement the actions
	 *
	 * Your task is to implement the Next action that takes a state and returns a new state. The Next action
     * takes a variable name and a new value as a constructor. This is simplified since we do not consider the domain
     * of a variable so all assignments are ok.
	 */
	public void test2_6_NextAction() {
		Action a1 = new Next(v1, 1);
		Action a2 = new Next(v2, true);


        State nextState = a1.next(testState);
        State s2 = a2.next(nextState);
		assertTrue(s2.get(v1).equals(1) && s2.get(v2).equals(true) && s2.get(v3).equals("Initial"));
	}
	
	/**
	 * We also has an assign action, which takes the value from another variable and assign it to the first,
     * i.e. state = State(v -> 1, z -> 4); as = Assign(v, z), as.newState(state) -> State(v -> 4, z -> 4)
	 */
	public void test2_7_AssignAction() {
		Action a1 = new Assign(v1, v2);
		
		State nextState = a1.next(testState);
		
		assertTrue(nextState.get(v1).equals(false) && nextState.get(v2).equals(false) && nextState.get(v3).equals("Initial"));
	}
	
	/**
	 * Finally we are ready to create an operation. Most of the operation is implemented.
	 * We create it by sending in a name, one guard predicate, and a list of actions
	 * 
	 * Implement the eval method to evaluate the guards
	 */
	public void test2_8_OperationEvaluate() {
		Predicate p1 = new EQ(v1, 0);
		Predicate p2 = new EQ(v1, 1);
		Action a1 = new Next(v1, 1);
		Action a3 = new Next(v1, 2);
		
		Operation o1 = new Operation("o1", p1, a1);
		Operation o2 = new Operation("o2", p2);
		
		// Just to show that it is easy to print thing for troubleshooting
		System.out.println("test2_8: " + o1.conditionAsString());
		System.out.println("test2_8: " + o2.conditionAsString());

		assertTrue(o1.eval(testState));
		assertFalse(o2.eval(testState));
	}
	
	/**
	 * Implement the execute method that takes the current state and returns an updated state.
     * Should fire an IllegalStateException if the operation is executed with a false guard
     * The order of the actions is important as in this test
	 */
	public void test2_9_OperationExecute() {
		Action a1 = new Next(v1, 1);
		Action a2 = new Next(v1, 2);
		Action a3 = new Next(v1, 3);
		Operation o1 = new Operation("o1", a1);
		Operation o2 = new Operation("o2", Arrays.asList(a1, a3, a2));
		Operation o3 = new Operation("o3", new EQ(v1, "FEL"), a1);

		State s1 = o1.execute(testState);
		State s2 = o2.execute(testState);
		
		assertTrue((s1.get(v1)).equals(1));
		assertTrue((s2.get(v1)).equals(2));

        boolean exceptionFired = false;
        try{
            o3.execute(testState);
        } catch (IllegalStateException e) {
            exceptionFired = true;
        }
        assertTrue(exceptionFired);
	}


    /**
     * It is important to update the state based on the list of actions
     * testState -a1-> s2 -a2-> s3 -a3-> s3 Each new action must be executed
     * based on the updated state
     */
    public void test2_10_OperationExecute2() {
        Action a1 = new NextInc(v1, 1);
        Action a2 = new NextInc(v1, 1);
        Action a3 = new NextInc(v1, 1);
        Operation o1 = new Operation("o1", Arrays.asList(a1, a2, a3));

        State s1 = o1.execute(testState);

        assertTrue((s1.get(v1)).equals(3));

    }

    /***
     * It is important to evaluate the operations only once before applying the
     * actions
     */
    public void test2_11_OperationExecution3() {
        Action a1 = new Next(v1, 1);
        Action a2 = new Next(v1, 2);
        Predicate p1 = new EQ(v1, 0);
        Operation o1 = new Operation("o1", p1, Arrays.asList(a1, a2));

        boolean exceptionFired = false;
        try {
            o1.execute(testState);
        } catch (IllegalStateException e) {
            exceptionFired = true;
        }
        assertFalse(exceptionFired);

    }


}
