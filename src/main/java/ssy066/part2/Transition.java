package ssy066.part2;

import ssy066.part1.*;

/**
 * Use this as class as the return type in your graph class. You do not need to store this internally
 * in your graph, but can create it at every request.
 *
 * (A note, you can actually use it also as internal representation in the graph, but it may not be very efficient. Or
 * maybe it is... You have to decide :) ).
 */
public class Transition {
    public final String label;
    public final State tail; // The transition is going out from the tail
    public final State head; // The transition coming to the head
    public final Integer cost; // Will be used in test 4


    public Transition(String label, State tail, State head, Integer cost) {
        this.tail = tail;
        this.head = head;
        this.label = label;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return label +" <"+ tail + head +cost+">";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transition that = (Transition) o;

        if (!head.equals(that.head)) return false;
        if (!label.equals(that.label)) return false;
        if (!tail.equals(that.tail)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = label.hashCode();
        result = 31 * result + tail.hashCode();
        result = 31 * result + head.hashCode();
        return result;
    }
}
