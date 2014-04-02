import org.fa.api.FiniteAutomata;
import org.fa.dfa.DFA;

import java.io.IOException;

public class InputValidator {

    public static void main(String[] args) throws IOException {
        FiniteAutomata dfa = new DFA();
        ((DFA) dfa).execute();
    }
}
