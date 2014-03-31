import org.fa.api.FiniteAutomata;
import org.fa.dfa.DFA;
import org.fa.exceptions.InvalidAutomata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputValidator {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        /* obtain the file name which contains the definition of the DFA */
        System.out.println("Enter the full file name which contains the DFA");
        String fileName = br.readLine();

        FiniteAutomata dfa = new DFA();
        try {
            dfa.initialize(fileName);
        } catch (InvalidAutomata e) {
            System.out.print(e.getMessage());
            System.exit(0);
        } catch (FileNotFoundException e) {
            System.out.println("File with the given name " + fileName
                    + " doesn't exists in the input directory");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("I/O Error occurred while reading from file "
                    + fileName);
            System.exit(0);
        }


        String input;
        System.out.println("Type the expression and press enter ");
        while ((input = br.readLine()) != null) {
            if (dfa.validateInput(input)) {
                System.out.println(input + " is a valid expression\n");
            } else {
                System.out.println(input + " is an invalid expression\n");
            }
            System.out.println("Type the expression and press enter ");
        }

    }
}
