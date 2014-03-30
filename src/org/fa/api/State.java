package org.fa.api;

public interface State {

    public String getStateId();

    public boolean isAccepted();

    public void setAccepted(boolean accepted);

    public void addStateTransition(String input, String stateId);

    public String getStateTransition(String input);
}
