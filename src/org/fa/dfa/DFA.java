package org.fa.dfa;

import org.fa.api.FiniteAutomata;
import org.fa.exceptions.InvalidAutomata;

public class DFA implements FiniteAutomata {

    private boolean initialized;
    //todo add substitute map

    public DFA(){
        this.initialized = false;
    }

    @Override
    public void initialize(String automataFilePath) throws InvalidAutomata {

    }

    @Override
    public boolean validateInput(String input) throws IllegalStateException {
        return false;
    }


}
