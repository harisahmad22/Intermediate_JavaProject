package application;
/********************************************************************************
 * @author Haris Ahmad
 * @author Salman Ahmed
 * @author Namra Aslam
Purpose:
  To calculate a polynomial operation from 5 given choices. Those choices being:
  evaluate, differentiate, addition, multiply, and root(s). A sixth option is
  also listed as 'q' on the menu but it does not perform a specific operation
  and it exits the user from the program. If a choice that is not listed on the
  menu is selected, the user will be prompted to select another choice.
Details:
  Input - The user will be prompted with a menu that lists the various possible
          polynomial operations. Based on the character that the user selected,
          a specific operation will be performed.
              - Input for "evaluate" operation:
                  ~ The program takes in a user inputed character 'e'.
                  ~ It then takes in a single polynomial based on user inputs
                    in the form of coefficient ' ' exponent and it will stop
                    gathering input when the user enters "CTRL-D".
              - Input for "differentiate" operation:
                  ~ The program takes in a user inputed character 'd'.
                  ~ It then takes in a single polynomial based on user inputs
                    in the form of coefficient ' ' exponent and it will stop
                    gathering input when the user enters "CTRL-D".
              - Input for "addition" operation:
                  ~ The program takes in a user inputed character 'a'.
                  ~ It then takes in two polynomials based on user inputs
                    in the form of coefficient ' ' exponent and it will stop
                    gathering input when the user enters "CTRL-D".
              - Input for "multiply" operation:
                  ~ The program takes in a user inputed character 'm'.
                  ~ It then takes in two polynomials based on user inputs
                    in the form of coefficient ' ' exponent and it will stop
                    gathering input when the user enters "CTRL-D".
              - Input for "root(s)" operation:
                  ~ The program takes in a user inputed character 'r'.
                  ~
  Output - The user will be prompted with a menu that lists the various possible
           polynomial operations. Based on the character that the user selected,
           a specific operation will be performed.
              - Output for 'e':
                  ~ The polynomial printed out in the form:
                    "number"; "x^", or "x", or nothing; and then the exponent.
                  ~  The final evaluated value of the polynomial.
              - Output for 'd':
                  ~ The polynomial printed out in the form:
                    "number"; "x^", or "x", or nothing; and then the exponent.
                  ~ The polynomial after it has been differentiated in the same
                    form listed above.
              - Output for 'a':
                  ~ The first polynomial printed out in the form:
                    "number"; "x^", or "x", or nothing; and then the exponent.
                  ~ The second polynomial printed out in the form:
                    "number"; "x^", or "x", or nothing; and then the exponent.
                  ~ The final polynomial.
********************************************************************************/

import java.util.Scanner;

import model.ProcessCalculations;

public class TextApp {

	public static void prompt() {
		System.out.println("Welcome to the polynomial calculator, what would you like to do: ");
		System.out.println("	e - evaluate a polynomial");
		System.out.println("	d - differentiate a polynomial");
		System.out.println("	a - add two polynomials");
		System.out.println("	m - multiply two polynomials");
		System.out.println("	r - find the root(s) of a quadratic polynomial");
		System.out.println("	q - quit");
		System.out.println();
		
		System.out.println("An example of user input is: '3 2' '2 1' '1 0'");
		System.out.println("Which as a polynomial would look like: 3x^2 + 2x^1 + 1");
		System.out.println();
		System.out.println("Please input your choice: ");
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		prompt();
		char choice = input.nextLine().charAt(0);

		
		while (choice != 'q')
	    {
			
	        switch (choice)
	        {
	        case 'e':
	        	ProcessCalculations e = new ProcessCalculations();
	            e.process_evaluate ();

	            break;

	        case 'd':
	        	ProcessCalculations d = new ProcessCalculations();
	            d.process_differentiate ();

	            break;

	        case 'a':
	        	ProcessCalculations a = new ProcessCalculations();
	            a.process_addition ();

	            break;

	        case 'm':
	        	ProcessCalculations m = new ProcessCalculations();
	            m.process_multiply ();

	            break;

	        case 'r':
	        	ProcessCalculations r = new ProcessCalculations();
	            r.process_roots ();

	            break;

	        default:
	            System.out.println("You chose an invalid option, please select a valid entry - ");
	            break;
	        }
			System.out.println();
			System.out.println();
			System.out.println();

	        System.out.println("Enter another choice. ");
	        prompt();
			

	        choice = input.nextLine().charAt(0);
	}
	
	switch (choice) {
	case 'q':
		System.out.println();
		System.out.println("***  Exiting program  ***");
		return;
	}
	
	return;
	}
}
		
