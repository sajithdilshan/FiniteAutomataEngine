import org.fa.api.FiniteAutomata;
import org.fa.dfa.DFA;
import org.fa.exceptions.InvalidAutomata;

import java.io.*;

public class InputValidator {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the full file name which contains the DFA");
        String fileName = br.readLine();


        File dir = new File(".");

        File dfaFile = new File(dir.getCanonicalPath() + File.separator + "input" + File.separator + fileName);

        FiniteAutomata dfa = new DFA();
        try {
            dfa.initialize(dfaFile);
        } catch (InvalidAutomata e) {
            System.out.print(e.getMessage());
            System.exit(0);
        } catch (FileNotFoundException e) {
            System.out.println("File with the given name " + fileName + " doesn't exists in the input directory");
            System.exit(0);
        } catch (IOException e) {
            System.exit(0);
        }


        String input;
        System.out.println("Type the expression and press enter ");
        while ((input = br.readLine()) != null) {
            if (dfa.validateInput(input)) {
                System.out.println(input + " is a valid input string");
            } else {
                System.out.println(input + " is an invalid input string");
            }
            System.out.println("Type the expression and press enter ");
        }

    }
}
