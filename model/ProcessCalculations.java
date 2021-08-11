package model;
/**
 * 
 * @author Haris Ahmad
 *
 */


public class ProcessCalculations {
    private int[] poly1 = new int[BasicCalculations.MAX_SIZE];    // the first polynomial array
    private int[] poly2 = new int[BasicCalculations.MAX_SIZE];    // the second polynomial array
	
    private int x = 0;                			// the value for the unknowns in a polynomial
    private int polynomial1Value = 0;     		// the final value of the evaluated polynomial
    
    private double[] rootsInfo;					// the array containing the number of roots info
	private int numRealRoots;					// how many real roots are in the polynomial
	
	/********************************************************************************
	Name:     process_evaluate
	
	Purpose:  To output all the prompts and handle the decisions if the input from
	          the user is 'e'.
	
	Details:  Displays what prompt you chose and then asks the user to enter a
	          valid polynomial. The function then calls the functions readPoly and
	          printPoly and if the inputed polynomial follows program guidelines
	          the success statement will equate to true and the user will
	          receive the evaluated polynomial value.
	
	Input Parameters:  None.
	
	Returns:  Nothing.
	********************************************************************************/
	public void process_evaluate()
	{   
	    System.out.println("You chose evaluate");
	    System.out.println("Please input a polynomial with the highest exponent being less "
	    		+ "than or equal to 20.");
	    
	    BasicCalculations basics = new BasicCalculations();
	    basics.readPoly (poly1);
	    basics.printPoly (poly1);

        System.out.print("Enter value for the unknown: ");
        EssentialCalculations evaluate = new EssentialCalculations();
	    evaluate.evaluate (poly1, x, polynomial1Value);
	        
	    return;
	}

	
	/********************************************************************************
	Name:     process_differentiate
	
	Purpose:  To output all the appropriate prompts and handle the decisions if the
	          choice selected by the user is 'd'.
	
	Details:  Uses decisions to determine whether the user input is valid,
	 		  and then outputs the users chosen polynomial if the read was successful 
	 		  using the readPoly and printPoly commands. After that, this function 
	 		  calls the differentiate function and then calls print again to output 
	 		  the final differentiated polynomial.
	
	Input Parameters:  None.
	
	Returns:  Nothing.
	********************************************************************************/
	public void process_differentiate()
	{
	    int[] diff_poly = new int [BasicCalculations.MAX_SIZE];   // the differentiated polynomial array

	    System.out.println("You chose differentiate");
	    System.out.println("Please input a polynomial with the highest exponent being less than "
	    		+ "or equal to 20.");
	    
	    BasicCalculations basics = new BasicCalculations();
	    EssentialCalculations essentials = new EssentialCalculations();
	    
	    basics.readPoly (poly1);
	    basics.printPoly (poly1);

        basics.clearPoly (diff_poly);

        System.out.print("Differentiated polynomial equals: ");

	    essentials.differentiate (poly1, diff_poly);
	    basics.printPoly (diff_poly);
	    
	    return;
	}

	
	/********************************************************************************
	Name:     process_addition
	
	Purpose:  To output all the appropriate prompts and handle the decisions if the
	          choice selected by the user is 'a'.
	
	Details:  Uses decisions to determine if the success statement returned from the
	          readPoly evaluates to true. If it is then the program prints out the
	          two polynomials, followed by a line of "=" signs, followed by the
	          sum of the two polynomials.
	
	Input Parameters:  None.
	
	Returns:  Nothing.
	********************************************************************************/
	public void process_addition()
	{
	    int[] polySum = new int [BasicCalculations.MAX_SIZE];     /* the polynomial's sum resulting from the
	                                    		   addition of the first and second arrays */

	    System.out.println("You chose add");
	    System.out.println("Please input a polynomial with the highest exponent being less than "
	    		+ "or equal to 20.");

	    EssentialCalculations essentials = new EssentialCalculations();
	    BasicCalculations basics = new BasicCalculations();

	    basics.readPoly (poly1);
	    System.out.println("Please input a another polynomial with the highest exponent being less "
	    		+ "than or equal to 20.");
	    basics.readPoly (poly2);
	    System.out.println();
	    basics.printPoly (poly1);
	    System.out.println("[+] ");
	    basics.printPoly (poly2);
	    System.out.println("==============================");

	    essentials.sumPoly (poly1, poly2, polySum);
	    basics.printPoly (polySum);

	    return;
	}
	
	
	/********************************************************************************
	Name:     process_multiply
	
	Purpose:  To output all the appropriate prompts and handle the decisions if the
	          choice entered by the user is 'm'.
	
	Details:  This function calls clearPoly to clear the contents of the first
	          polynomial array, the second polynomial array, and then the final
	          product's polynomial array. It then prints a prompt and if the read
	          is successful for the first polynomial array, it will output the
	          read option for the second polynomial array. If the read for that is
	          also successful the program will print out the product of the
	          two polynomials multiplication. If at any point a read is
	          unsuccessful the program will print out the appropriate error message.
	
	Input Parameters:  None.
	
	Returns:  Nothing.
	********************************************************************************/
	public void process_multiply()
	{
	    int[] product = new int[BasicCalculations.MAX_SIZE];    // the array for the product after multiplication

	    EssentialCalculations essentials = new EssentialCalculations();
	    BasicCalculations basics = new BasicCalculations();

	    basics.clearPoly (poly1);
	    basics.clearPoly (poly2);
	    basics.clearPoly (product);

	    System.out.println("You chose multiply");
	    System.out.println("Please input a polynomial with the highest exponent being less than "
	    		+ "or equal to 20.");
	    basics.readPoly (poly1);

	    System.out.println("Please input a another polynomial with the highest exponent being less "
	    		+ "than or equal to 20.");
	    basics.readPoly (poly2);
	    
	    System.out.println();
	    essentials.multiplyPolys (poly1, poly2, product);
	    
	    System.out.println("Performing multiplication on the polynomials");
	    basics.printPoly (poly1);
	    
	    System.out.print("[*] ");
	    basics.printPoly (poly2);
	    
	    System.out.println("==============================");
	    basics.printPoly (product);

	    return;
	}
	
	
	/********************************************************************************
	Name:     process_roots
	
	Purpose:  To output the appropriate prompts and handle the decisions if the
	          user's choice is 'r'.
	
	Details:  The function reads the polynomial by calling readPoly and then prints
	          out the displayed polynomial using printPoly. The rootsPoly method
	          is then called to determine if the polynomial has 1, 2, or no real
	          roots. It does so by using decision statements and if rootsFound is
	          equal to false, the program will print out the appropriate error
	          message.
	
	Input Parameters:  None.
	
	Returns:  Nothing.
	********************************************************************************/
	public void process_roots()
	{
	    EssentialCalculations essentials = new EssentialCalculations();
	    BasicCalculations basics = new BasicCalculations();
	    
	    System.out.println("You chose roots");
	    System.out.println("Please input a polynomial with the highest exponent being less than "
	    		+ "or equal to 20.");
	    
	    basics.readPoly (poly1);

	    System.out.println();
	    System.out.print("The polynomial ");

	    basics.printPoly (poly1);

	    System.out.println("has: ");

	    rootsInfo = essentials.rootsPoly(poly1);
	    
	    numRealRoots = (int)rootsInfo[0];
	
	    		
	    if (numRealRoots == 1)
	    {
	        System.out.println("Value of x1 = " + rootsInfo[1]);
	        System.out.println("There are " + numRealRoots + " roots in this polynomial");
	    }
	    else if (numRealRoots == 2)
	    {
	        System.out.println("Value of x1 = " + rootsInfo[1]);
	        System.out.println("Value of x2 = " + rootsInfo[2]);
	        System.out.println("There are " + numRealRoots + "roots in this polynomial");
	    }
	    else if (numRealRoots == 0)
	    {
	        System.out.println("No real roots found");
	    }
	    else
	    {
	        System.out.println("Error - The polynomial entered is neither linear nor quadratic");
	    }

	    return;
	}
	
	
	// -----------------------------------------------------
	// getter and setter methods (process)
	// -----------------------------------------------------
	
	public int getNumRealRoots() {
		return numRealRoots;
	}


	public void setNumRealRoots(int numRealRoots) {
		this.numRealRoots = numRealRoots;
	}


	public double[] getRootsInfo() {
		return rootsInfo;
	}


	public void setRootsInfo(double[] rootsInfo) {
		this.rootsInfo = rootsInfo;
	}


	public int[] getPoly1() {
		return poly1;
	}


	public void setPoly1(int[] poly1) {
		this.poly1 = poly1;
	}


	int[] getPoly2() {
		return poly2;
	}


	void setPoly2(int[] poly2) {
		this.poly2 = poly2;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getPolynomial1Value() {
		return polynomial1Value;
	}


	public void setPolynomial1Value(int polynomial1Value) {
		this.polynomial1Value = polynomial1Value;
	}
}
