package org.fa.api;

import org.fa.exceptions.InvalidAutomata;

public interface FiniteAutomata {

    public void initialize(String automataFilePath) throws InvalidAutomata;

    public boolean validateInput(String input) throws IllegalStateException;
}
