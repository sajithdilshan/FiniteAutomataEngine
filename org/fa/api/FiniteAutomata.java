package org.fa.api;

import org.fa.exceptions.InvalidAutomata;

import java.io.IOException;

public interface FiniteAutomata {

    public void initialize(String inputFile) throws InvalidAutomata, IOException;

    public boolean validateInput(String input) throws IllegalStateException;
}
