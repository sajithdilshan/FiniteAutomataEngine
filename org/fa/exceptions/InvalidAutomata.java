package org.fa.exceptions;

/**
 * This exception is thrown when the definition of the Finite Automata is
 * invalid.
 */
public class InvalidAutomata extends Exception {

    public InvalidAutomata(String message) {
        super(message);
    }

}
