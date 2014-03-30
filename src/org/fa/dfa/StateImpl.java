package org.fa.dfa;

import org.fa.api.State;

import java.util.HashMap;
import java.util.Map;

public class StateImpl implements State {
    private final String stateId;
    private boolean accepted;
    private final Map<String, String> stateTransitionMap;

    public StateImpl(String stateId) {
        this.stateId = stateId;
        this.stateTransitionMap = new HashMap<String, String>();
        this.accepted = false;
    }

    @Override
    public String getStateId() {
        return stateId;
    }

    @Override
    public boolean isAccepted() {
        return accepted;
    }

    @Override
    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    @Override
    public void addStateTransition(String input, String stateId) {
        this.stateTransitionMap.put(input, stateId);
    }

    @Override
    public String getStateTransition(String input) {
        return this.stateTransitionMap.get(input);
    }
}
