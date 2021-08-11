package model;
/**
 * 
 * @author Salman Ahmed
 *
 */
import java.util.Scanner;

public class EssentialCalculations {
	
	private double storage = 0;
	
	private int new_exponent;
	private int bring_down;
	
	private double root_1 = 0;
	private double root_2 = 0;
	private int num_RealRoots = 0;
	private double [] roots_info = new double[3];
		
	/********************************************************************************
	Name:     evaluate
	Purpose:  To calculate the overall value of the polynomial by substituting a
	          value for the unknown.
	Details:  For every value in the index (all exponent values from 0-20), the array
	          at that specific value multiplies itself by the unknown to the power of
	          the index at that given position.
	Input Parameters:
	          int [] poly
	          int x,
	              poly1Value
	              
	Returns:  Nothing.
	********************************************************************************/
	public void evaluate(int[] poly1, int x, int poly1Value) {		
		Scanner key_board = new Scanner(System.in);
		
		if (key_board.hasNextLine()) {
			x = Integer.parseInt(key_board.nextLine());
		}
	
		for (int index = (BasicCalculations.MAX_SIZE - 1); index >= 0; index--) {
			setStorage(getStorage() + poly1[index] * Math.pow(x, index));
			poly1Value = (int)getStorage();
		}		
		
		System.out.println("The polynomial evaluates to: " + poly1Value);
		return;
	}
	
	
	/********************************************************************************
	Name:     differentiate
	Purpose:  To differentiate a polynomial.
	Details:  Brings down the polynomials index value for each value in the index and
	          multiplies it by the polynomials value at that specific index. It then
	          takes the index value (exponent) and subtracts 1. The function repeats
	          this process in a loop until all index values are covered between 0-20.
	Input Parameters:
	          int [] polynomial,
	              [] diff_poly
	Returns:  Nothing.
	********************************************************************************/
	public void differentiate(int[] polynomial, int[] diff_poly) {
		
		for (int index = (BasicCalculations.MAX_SIZE - 1); index >= 0; index--) {
			setBring_down((polynomial[index] * index));
			
			if (index > 0) {
			setNew_exponent((index - 1));
			diff_poly[getNew_exponent()] = getBring_down();
			}
		}
		return;
	}
	
	
	/********************************************************************************
	Name:     sumPoly
	Purpose:  To add two polynomials together and provide their sum.
	Details:  The index (exponent) decreases from 20 until it reaches zero and
	          every time it does so the polynomial array values for the two arrays
	          are added up and placed into an array containing their sums.
	Input Parameters:
	          int  [] poly1,
	               [] poly2,
	               [] polySum
	Returns:  Nothing.
	********************************************************************************/
	public void sumPoly(int[] poly1, int[] poly2, int[] polySum) {
		for (int index = (BasicCalculations.MAX_SIZE - 1); index >= 0; index--) {
			polySum[index] = poly1[index] + poly2[index]; 
		}
		
		return;
	}
	
	
	/********************************************************************************
	Name:     multiplyPolys
	Purpose:  To multiply two polynomials together and provide their product
	Details:  The function has two indexes and they both increment upwards by 1 from
	          0 to 20. As long as the added values of the two indexes are less than
	          or equal to 20, the product at the sum of those two added indexes is
	          calculated. If the combined indexes are greater than 20 then the
	          product is not calculated.
	Input Parameters:
	          int[] poly1,
	                poly2,
	                product
	
	Returns:  Nothing.
	********************************************************************************/
	public boolean multiplyPolys(int[] poly1, int[] poly2, int[] product) {
		boolean productFound = true;
		
		BasicCalculations newCalculation = new BasicCalculations();
		newCalculation.clearPoly(product);
				
		for (int index2 = 0; index2 < BasicCalculations.MAX_SIZE && productFound == true; index2++) {
	        if (poly2 [index2] != 0) {
	            
	        	for (int index1 = 0; index1 < BasicCalculations.MAX_SIZE && productFound == true; index1++) {
	                if (poly1 [index1] != 0) {
	                    if ((index1 + index2) >= 21 || (index1 + index2) <= -1) {	
	                        productFound = false;
	                    }
	                    else {
	                        productFound = true;
	                        product [index1 + index2] += (poly1[index1] * poly2[index2]);
	                    }
	                }
	            }
	        }
	    }
		
	    return productFound;
	}
	
	
	/********************************************************************************
	Name:     rootsPoly
	Purpose:  To calculate the root or roots of a polynomial if there are any
	Details:  Calculates the root(s) of a polynomial if there are any using
	          nested if statements to determine the differential value.
	          There are also two different sets of polynomial arrays, one is for
	          if the user inputed a quadratic polynomial and one is for if the user
	          inputed a linear polynomial.
	Input Parameters:
	          int[] polynomial ,
	Returns:  Nothing.
	********************************************************************************/
	public double[] rootsPoly(int[] polynomial) {
		
		int max_index = -1;
		double a_quad = polynomial[2];
		double b_quad = polynomial[1];
		double c_quad = polynomial[0];
		double a_linear = polynomial[1];
		double b_linear = polynomial[0];
		
		double d = 0;
		
	    d = (Math.pow(b_quad,2) - (4 * a_quad * c_quad));

	    for (int index = (BasicCalculations.MAX_SIZE - 1); index >= 0; index--) {
	        if (max_index < index && polynomial[index] != 0) {
	            max_index = index;
	        }
	    }
	    
	    if (max_index == 1) {
	        root_1 = (b_linear * -1) / a_linear;
	        num_RealRoots = 1;
	    }
	    else if (max_index == 2) {
	        if (d > 0) {
	            root_1 = (((-b_quad) + Math.sqrt(d)) / (2 * a_quad));
	            root_2 = (((-b_quad) - Math.sqrt(d)) / (2 * a_quad));
	            num_RealRoots = 2;
	        }
	        else if (d == 0) {
	            root_1 = ((-b_quad) / (2 * a_quad));
	            num_RealRoots = 1;
	        }
	        else if (d < 0) {
	            num_RealRoots = 0;
	        }
	        else {
	        	num_RealRoots = -1;
	        }
	    }
	    roots_info[0] = num_RealRoots;
	    if (num_RealRoots > 0) {
	    	if (num_RealRoots == 1) {
	    		roots_info[1] = root_1;
	    	}
	    	if (num_RealRoots == 2) {
	    		roots_info[1] = root_1;
	    		roots_info[2] = root_2;
	    	}
	    		
	    }
	    	
	    return roots_info;
	}

	
	// -----------------------------------------------------
	// getter and setter methods (essential)
	// -----------------------------------------------------

	public double getStorage() {
		return storage;
	}

	public void setStorage(double storage) {
		this.storage = storage;
	}
	
	public double [] getRoots_info() {
		return roots_info;
	}


	public void setRoots_info(double [] roots_info) {
		this.roots_info = roots_info;
	}


	public double getRoot_1() {
		return root_1;
	}


	public void setRoot_1(double root_1) {
		this.root_1 = root_1;
	}


	public double getRoot_2() {
		return root_2;
	}


	public void setRoot_2(double root_2) {
		this.root_2 = root_2;
	}


	public int getNum_RealRoots() {
		return num_RealRoots;
	}


	public void setNum_RealRoots(int num_RealRoots) {
		this.num_RealRoots = num_RealRoots;
	}


	public int getNew_exponent() {
		return new_exponent;
	}


	public void setNew_exponent(int new_exponent) {
		this.new_exponent = new_exponent;
	}


	public int getBring_down() {
		return bring_down;
	}


	public void setBring_down(int bring_down) {
		this.bring_down = bring_down;
	}
}