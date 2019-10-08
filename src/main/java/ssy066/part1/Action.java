package ssy066.part1;

import ssy066.part1.Predicate;

import java.util.Map;

public interface Action {
	State next(State s);
}
