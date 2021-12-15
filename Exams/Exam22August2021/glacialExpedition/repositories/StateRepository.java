package Exams.Exam22August2021.glacialExpedition.repositories;

import Exams.Exam22August2021.glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StateRepository implements Repository<State> {
    private List<State> states;

    public StateRepository() {
        this.states = new ArrayList<>();
    }

    @Override
    public Collection<State> getCollection() {
        return Collections.unmodifiableList(states);
    }

    @Override
    public void add(State state) {
        states.add(state);
    }

    @Override
    public boolean remove(State state) {
        return states.remove(state);
    }

    @Override
    public State byName(String name) {
        for (int i = 0; i < states.size(); i++) {
            if (states.get(i).getName().equals(name)) {
                return states.get(i);
            }
        }
        return null;
    }
}
