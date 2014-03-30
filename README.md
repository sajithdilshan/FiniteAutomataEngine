#Finite Automata Engine
____________________________

###How to define a new Deterministic Finite Automata

* Sample DFA is available in input/dfa1.txt

* First line of the file should contain the number of total states in the DFA

* 2nd line should contain the start state of the DFA

* 3rd line should contain a comma separated list of accepted states

* 4th line should contain the number of substitutions

* next n lines contains the substitutions
substitutions should be in the form of
<character which is used as substitute>:<comma separated list of characters which should be substituted>
E.g: d:1,2,3,4,5,6,7,8,9,0 means that 0-9 digits are substitutes by the letter 'd'

* next n lines contains the states with their transitions as follows
<state id>:<comma separated list of transitions>
the transition should be in the form of
<input;next state>
E.g:  s3:d;s3,l;s4 means that state with the id 's3' has two transitions. Upon receiving 'd',
current state will transit to the state 's3' and upon receiving 'l', current state will transit to
the state 's4'

* After defining the new DFA put that file in the 'input' directory and execute the 'InputValidator.java' file

###How to run the FA engine

* After defining a new DFA and placing it within the 'input' directory, execute 'InputValidator.java' file

* Give the name of the newly created DFA file ( the one which was places within the 'input' directory)

* Enter the expression which needs to be validated against the DFA
