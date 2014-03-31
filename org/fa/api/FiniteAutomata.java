package org.fa.api;

import org.fa.exceptions.InvalidAutomata;

import java.io.IOException;

/**
 * Defines the Finite Automata(FA). All the Finite Automata engine
 * implementations must implement this class
 */
public interface FiniteAutomata {

    /**
     * Performs the initialization of the FA. Basically the implementation of
     * this method must read the FA definition from the given inputFileName
     * and construct the FA.
     *
     * @param inputFileName Name of the file which contains the
     *                      definition of the FA. This file MUST reside
     *                      within the 'input' directory.
     * @throws InvalidAutomata when the definition of the FA is invalid
     * @throws IOException     when reading the definition from the file fails
     */
    public void initialize(String inputFileName) throws InvalidAutomata, IOException;

    public boolean validateInput(String input) throws IllegalStateException;
}
