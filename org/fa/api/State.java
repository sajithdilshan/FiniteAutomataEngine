package org.fa.api;

/**
 * Represents a State of the Finite Automata
 */
public interface State {

    /**
     * @return the unique ID of the state
     */
    public String getStateId();

    /**
     * @return True if the state is an accepted state and False otherwise
     */
    public boolean isAccepted();

    /**
     * set if the current state is an accepted state or not
     *
     * @param accepted True if the state is an accepted state and False otherwise
     */
    public void setAccepted(boolean accepted);

    /**
     * Add a transition from this state to another state
     *
     * @param input   input character which enables the state transition
     * @param stateId Id of the next state
     */
    public void addStateTransition(String input, String stateId);

    /**
     * @param input A character which induce the state transition
     * @return the ID of the state if a transition is found, and null otherwise
     */
    public String getStateTransition(String input);
}
