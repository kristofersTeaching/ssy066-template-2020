package ssy066.part1;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

// Your imports if needed


/**
 * Welcome to part 1 of the programming project in the SSY066 course.
 *
 * In this part we will start building our data structures that will be used
 * throughout the project. The task is to write code that makes the unit tests
 * in this file to pass (and to compile). To run the test, either right-click on
 * the this file in the package explorer and pick run as and then JUnit test, or
 * click on the green play above. The result of the test is shown in the JUnit
 * window (expand the test in that window to see all tests). If you can not see
 * the JUnit window, open it via Window menu / Show view / other ...
 * And then java / JUnit in the popup window.
 *
 * Your code should be located in src/main/java/part1/.
 * So you should not change this file except if you need to import classes above
 * or if the test description state it.
 *
 * Always check http://docs.oracle.com/javase/8/docs/api/ when you have questions about types
 *
 * The unit test are a piece of code that specifies what your code should do. In this
 * file, usually I define some objects that I use to call your methods. Then I'm
 * checking if these methods return the correct things by checking if a boolean
 * expression hold. For example if a method should return 1 I will check that by
 * assertTrue(answer == 1). If it should not be equal to 1 i will write assertFalse(answer == 1).
 *
 * So by reading through the test carefully, the test specify the functionality of your code.
 *
 * Also remember that you
 * can comment out some of the assertTrue / assertFalse lines to easier pin point what
 * makes the test fail. You can also double-click on the test in the JUnit window.
 *
 * Solve each test in order!
 *
 */
public class Test1_States extends TestCase {

	
	/**
	 * First we need a class that represent a state. Your task is to implement the
     * constructor of the State class in State.java (located in part1). Think about
     * what the class represents and what the test below is sending to the constructor.
     *
	 *
	 */
	public void test1_1_createAState() {

		// Creating a link between a variable  and a value. This is done with a structure called Map.
		// Here the map is created and filled.
		Map<String, Object> stateMap = new HashMap<String, Object>();
		stateMap.put("v1", 0); stateMap.put("v2", "atHome");
		State state = new State(stateMap);
		State compareState = new State(stateMap);
        System.out.println(state);


		assertTrue(state != null);
		assertTrue(state.equals(compareState));

	}

    /**
     * In this test you should implement the method public Object get(String var).
     * The method should return the value of a specific variable. If the variable
     * name is not part of the state, you should throw an NoSuchElementException.
     * The method inState can help here.
     *
     * Remember to look at the java api and how to access a Map
     *
     *
     */
    public void test1_2_getFromState() {
        Map<String, Object> stateMap = new HashMap<String, Object>();
        stateMap.put("v1", 0); stateMap.put("v2", "atHome");
        State state = new State(stateMap);

        Object ans1 = state.get("v1");
        Object ans2 = state.get("v2");

        assertTrue(ans1.equals(0));
        assertTrue(ans2.equals("atHome"));

        // Here we also test that we get an exception when a variable not in the state is tried.
        boolean exceptionFired = false;
        try{
            state.get("FinnsInte");
        } catch (java.util.NoSuchElementException e) {
            exceptionFired = true;
        }
        assertTrue(exceptionFired);
    }


    /**
     * Often when people implement classes in java they forget that everything is pointers. So
     * if i have a variable v and assign it to another variable: z = v. Then if I change v, then also
     * z sometimes changes (there are exceptions). Especially when the variable is for example a map.
     * Strings, ints and primitive types are usually immutable and does not need to be copied.
     *
     * In our case, we do not want the state to change after it has been created. This is because we
     * want to save states and not having multiple states pointing to the same Map. We want our
     * classes to immutable (http://en.wikipedia.org/wiki/Immutable_object).
     *
     * In this test, I test if your implementation of the state is immutable.
     *
     *
     */
    public void test1_3_ImmutableState() {

        Map<String, Object> stateMap = new HashMap<String, Object>();
        stateMap.put("v1", 0); stateMap.put("v2", "atHome");
        State state = new State(stateMap);

        // Checking immutability. If i'm able to change the state by changing stateMap
        // something whent wrong
        stateMap.put("v1", 4);
        assertTrue(state.get("v1").equals(0)); // should not be equal to 4

    }


	
	
	/**
	 * Now it is time to implement the newState methods. Let start with public State newState(String var, Object value)
     * The method should not change the current state, but return a new state. Remember that when a state is
     * constructed it should never change. If a variable not in the state is used, throw the exception
	 */
	public void test1_4_updateState() {

        Map<String, Object> stateMap = new HashMap<String, Object>();
        stateMap.put("v1", 0); stateMap.put("v2", "atHome");
        State state = new State(stateMap);

        State nextState1 = state.newState("v1", 1);
        State nextState2 = state.newState("v2", "inSchool");

        assertTrue(nextState1.get("v1").equals(1));
        assertTrue(nextState1.get("v2").equals("atHome"));

        assertTrue(nextState2.get("v2").equals("inSchool"));
        assertTrue(nextState2.get("v1").equals(0));

        // The old state should not be updated!
        assertTrue(state.get("v1").equals(0));
        assertTrue(state.get("v2").equals("atHome"));

		assertFalse(nextState1.equals(state));

        boolean exceptionFired = false;
        try{
            state.newState("FinnsInte", 0);
        } catch (java.util.NoSuchElementException e) {
            exceptionFired = true;
        }
        assertTrue(exceptionFired);


	}
	
	/**
	 * The same as above except here we will send in multiple values that should be updated
	 */
	public void test1_5_updateState2() {
        Map<String, Object> stateMap = new HashMap<String, Object>();
        stateMap.put("v1", 0); stateMap.put("v2", "atHome"); stateMap.put("v3", false);
        State state = new State(stateMap);

        Map<String, Object> newMap = new HashMap<String, Object>();
        newMap.put("v1", 1); newMap.put("v3", true);

        State next = state.newState(newMap);

        assertTrue(next.get("v1").equals(1));
        assertTrue(next.get("v2").equals("atHome"));
        assertTrue(next.get("v3").equals(true));

        assertTrue(state.get("v1").equals(0));
        assertTrue(state.get("v2").equals("atHome"));
        assertTrue(state.get("v3").equals(false));

        boolean exceptionFired = false;
        try{
            Map<String, Object> bad = new HashMap<String, Object>();
            bad.put("v1", 10); bad.put("v4", true);
            state.newState(bad);
        } catch (java.util.NoSuchElementException e) {
            exceptionFired = true;
        }
        assertTrue(exceptionFired);

	}


}
