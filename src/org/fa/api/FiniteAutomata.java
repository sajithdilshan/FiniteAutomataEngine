package org.fa.api;

import org.fa.exceptions.InvalidAutomata;

import java.io.File;
import java.io.IOException;

public interface FiniteAutomata {

    public void initialize(File inputFile) throws InvalidAutomata, IOException;

    public boolean validateInput(String input) throws IllegalStateException;
}
