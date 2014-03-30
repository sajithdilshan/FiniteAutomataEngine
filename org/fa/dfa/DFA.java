package org.fa.dfa;

import org.fa.api.FiniteAutomata;
import org.fa.api.State;
import org.fa.exceptions.InvalidAutomata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DFA implements FiniteAutomata {

    private static final String VALUE_SEPARATOR = ",";
    private static final String TRANS_SEPARATOR = ";";
    private static final String SEPARATOR = ":";

    private boolean initialized;
    private String startState;
    private ArrayList<String> acceptedStatesList;
    private Map<String, String> substitutesMap;
    private Map<String, State> stateMap;

    public DFA() {
        this.initialized = false;
        this.acceptedStatesList = new ArrayList<String>();
        this.substitutesMap = new HashMap<String, String>();
        this.stateMap = new HashMap<String, State>();
    }

    @Override
    public void initialize(String inputFileName) throws InvalidAutomata, IOException {
        /* reads the input from the file and adds it to a queue of Strings */
        final String filePath = (new File("")).getAbsolutePath() + File.separator + "input" + File.separator + inputFileName;
        System.out.println(filePath);
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        Queue<String> lines = new LinkedList<String>();
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }

        /* Sets the total Number of states */
        int totalNumberOfStates = Integer.valueOf(lines.poll());
        /* Sets the initial state */
        startState = lines.poll();
        /* Initializes the accepted states List */
        Collections.addAll(acceptedStatesList, lines.poll().split(VALUE_SEPARATOR));

        /* Initializes the substitutes */
        int numOfSubstitutes = Integer.valueOf(lines.poll());
        for (int i = 0; i < numOfSubstitutes; i++) {
            String substituteLine = lines.poll();
            String[] keyVal = substituteLine.split(SEPARATOR);
            String[] keys = keyVal[1].split(VALUE_SEPARATOR);
            for (String key : keys) {
                substitutesMap.put(key, keyVal[0]);
            }
        }

        if (lines.size() != totalNumberOfStates) {
            /* if the remaining number of lines doesn't match with the total number of states */
            throw new InvalidAutomata("Inadequate state transition information");
        }

        /* creates new states and add transition information*/
        while (!lines.isEmpty()) {
            String currentLine = lines.poll();
            String[] stateInfo = currentLine.split(SEPARATOR);
            /* creates a new state with the given state ID */
            State state = new StateImpl(stateInfo[0]);
            if (stateInfo.length == 2) { /* if the state has transitions */
                /* obtain the transitions list */
                String[] transList = stateInfo[1].split(VALUE_SEPARATOR);
                for (String transition : transList) {
                    String[] keyVal = transition.split(TRANS_SEPARATOR);
                    /* add the transition to the state */
                    state.addStateTransition(keyVal[0], keyVal[1]);
                }
            }
            /* put the initialized state into the map */
            stateMap.put(state.getStateId(), state);
        }

        /* mark the accepted states */
        for (String acceptedState : acceptedStatesList) {
            final State state = stateMap.get(acceptedState);
            if (state == null) {
                throw new InvalidAutomata("Accepted State : " + acceptedState + " doesn't exists");
            } else {
                state.setAccepted(true);
            }
        }
        this.initialized = true;
    }

    @Override
    public boolean validateInput(String input) throws IllegalStateException {

        if (!initialized) {
            throw new IllegalStateException("DFA hasn't been initialized");
        }

        State currentState = stateMap.get(startState);

        for (int i = 0; i <= input.length(); i++) {
            if (currentState == null) {
                /* if there are no valid transitions */
                return false;
            }

            if (input.length() == i) {
                /* reached the end of the input string */
                return currentState.isAccepted();
            }

            final String currentChar = String.valueOf(input.charAt(i));
            final String subsChar = substitutesMap.get(currentChar);
            String nextState;
            /* obtain the next state of the transition*/
            if (subsChar != null) {
                nextState = currentState.getStateTransition(subsChar);
            } else {
                nextState = currentState.getStateTransition(currentChar);
            }
            currentState = stateMap.get(nextState);
        }
        return false;
    }


}
