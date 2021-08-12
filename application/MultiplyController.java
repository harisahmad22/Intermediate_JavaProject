
package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.BasicCalculations;

public class MultiplyController {

    @FXML
    private TextArea userInput1;

    @FXML
    private TextArea userInput2;

    @FXML
    private Label polynomial1Layout;

    @FXML
    private Label polynomial2Layout;
    
    @FXML
    private Label productLayout;

    @FXML
    private Button buttonSubmit;
    
    @FXML
    private Button buttonClear;
    
    @FXML
    private Button buttonBack;
    
    /**
	 * This method takes in two polynomials from the user and outputs them both in the proper format back to the user,
     * it also displays the two polynomials back to the user in the proper format as well as the multiplied polynomial      
     * @param event
     */
    @FXML
    void submit(ActionEvent event) {
    	int[] poly1 = new int[BasicCalculations.MAX_SIZE];
    	int[] poly2 = new int[BasicCalculations.MAX_SIZE];
    	int[] productPoly = new int[BasicCalculations.MAX_SIZE];

    	
    	// obtaining the user input and putting the input into an array split by a new line and a blank space
    	String polynomialValue = userInput1.getText();    	
    	String[] inputs = polynomialValue.split(" |\\\n");
    	int[] numberInputs = new int[inputs.length];
    	for (int index = 0; index < inputs.length; index++) 
    	{
    		numberInputs[index] = Integer.parseInt(inputs[index]);
    	}
    	
    	
    	// creating an array just for the coefficients(only the even number values)
		int[] coefficients = new int [(numberInputs.length)];
		for (int index = 0; index < inputs.length; index++) {
			if (index % 2 == 0) {
					coefficients[index] = numberInputs[index];
				}
			}
		
		// creating a new coefficient array without the 0 values that were obtained from the exponents
		// in the array
    	int targetIndex = 0;
    	for( int sourceIndex = 0;  sourceIndex < coefficients.length;  sourceIndex++ )
    	{
    	    if( coefficients[sourceIndex] != 0 )
    	        coefficients[targetIndex++] = coefficients[sourceIndex];
    	}
    	int[] newCoefficientsArray = new int[targetIndex];
    	System.arraycopy( coefficients, 0, newCoefficientsArray, 0, targetIndex );
    	
    	
    	
    	
    	// creating an array just for the exponents(only the odd number values)
    	int[] exponents = new int [(numberInputs.length)];
    	for (int index2 = 0; index2 < inputs.length; index2++) {
    		if (index2 % 2 == 1) {
    			exponents[index2] = numberInputs[index2];
    		}
    	}
    	
		// creating a new exponent array without the 0 values that were obtained from the coefficients
    	// in the array
    	targetIndex = 0;
    	for( int sourceIndex = 0;  sourceIndex < exponents.length;  sourceIndex++ )
    	{
    	    if( exponents[sourceIndex] != 0 )
    	        exponents[targetIndex++] = exponents[sourceIndex];
    	}
    	int[] newExponentsArray = new int[targetIndex];
    	System.arraycopy( exponents, 0, newExponentsArray, 0, targetIndex );
    	
    	int coefficient = 0;
    	int exponent = 0;
    	int index = 0;

    	// placing the coefficients and exponents into the polynomial array
    	while (index < newExponentsArray.length) {
    		coefficient = newCoefficientsArray[index];
    		exponent = newExponentsArray[index];

    		poly1[exponent] = coefficient;

    		index++;
    	}
    	
    	
    	
    	
    	
    	
    	// obtaining the user input and putting the input into an array split by a new line and a blank space
    	String polynomial2Value = userInput2.getText();    	
    	String[] inputs2 = polynomial2Value.split(" |\\\n");
    	int[] numberInputs2 = new int[inputs2.length];
    	for (int index2 = 0; index2 < inputs2.length; index2++) 
    	{
    		numberInputs2[index2] = Integer.parseInt(inputs2[index2]);
    	}
    	
    	
    	// creating an array just for the coefficients(only the even number values)
		int[] coefficients2 = new int [(numberInputs2.length)];
		for (int index2 = 0; index2 < inputs2.length; index2++) {
			if (index2 % 2 == 0) {
					coefficients2[index2] = numberInputs2[index2];
				}
			}
		
		// creating a new coefficient array without the 0 values that were obtained from the exponents
		// in the array
    	int targetIndex2 = 0;
    	for( int sourceIndex2 = 0;  sourceIndex2 < coefficients2.length;  sourceIndex2++ )
    	{
    	    if( coefficients2[sourceIndex2] != 0 )
    	        coefficients2[targetIndex2++] = coefficients2[sourceIndex2];
    	}
    	int[] newCoefficientsArray2 = new int[targetIndex2];
    	System.arraycopy( coefficients2, 0, newCoefficientsArray2, 0, targetIndex2 );
    	
    	
    	
    	
    	// creating an array just for the exponents(only the odd number values)
    	int[] exponents2 = new int [(numberInputs2.length)];
    	for (int index2 = 0; index2 < inputs2.length; index2++) {
    		if (index2 % 2 == 1) {
    			exponents2[index2] = numberInputs2[index2];
    		}
    	}
    	
		// creating a new exponent array without the 0 values that were obtained from the coefficients
    	// in the array
    	targetIndex2 = 0;
    	for( int sourceIndex2 = 0;  sourceIndex2 < exponents2.length;  sourceIndex2++ )
    	{
    	    if( exponents2[sourceIndex2] != 0 )
    	        exponents2[targetIndex2++] = exponents2[sourceIndex2];
    	}
    	int[] newExponentsArray2 = new int[targetIndex2];
    	System.arraycopy( exponents2, 0, newExponentsArray2, 0, targetIndex2 );
    	
    	int coefficient2 = 0;
    	int exponent2 = 0;
    	int index2 = 0;

    	// placing the coefficients and exponents into the polynomial array
    	while (index2 < newExponentsArray2.length) {
    		coefficient2 = newCoefficientsArray2[index2];
    		exponent2 = newExponentsArray2[index2];

    		poly2[exponent2] = coefficient2;

    		index2++;
    	}
    	
    	// calculation for multiplying the 2 polynomials to the product polynomial
		for (index2 = 0; index2 < BasicCalculations.MAX_SIZE; index2++) {
	        if (poly2 [index2] != 0) {
	            
	        	for (int index1 = 0; index1 < BasicCalculations.MAX_SIZE; index1++) {
	                if (poly1 [index1] != 0) {
	                        productPoly [index1 + index2] += (poly1[index1] * poly2[index2]);
	                }
	            }	
	        }
	    }
    	
    	String stringProductPolyFormat = null;
    	// the calculation for displaying the polynomial layout
    	int max_exponent = -1; 
		for (int index3 = (BasicCalculations.MAX_SIZE - 1); index3 >= 0; index3--) { 
		        if (productPoly[index3] != 0)
		        {
		            if (max_exponent < index3)
		            {
		                if (productPoly[index3] == -1)
		                {
		                    max_exponent = index3;
		                    System.out.print("-");
		                }
		                else if (productPoly[index3] == 1)
		                {
		                    max_exponent = index3;
		                }
		                else
		                {
		                    max_exponent = index3;
		                    stringProductPolyFormat = Integer.toString(productPoly[max_exponent]);
		                }
		            }
		            else if (productPoly[index3] == 1)
		            {
		            	stringProductPolyFormat = stringProductPolyFormat + (" + ");
		            }
		            else if (productPoly[index3] == -1)
		            {
		            	stringProductPolyFormat = stringProductPolyFormat + (" - ");
		            }
		            else if (productPoly[index3] > 0)
		            {
		            	stringProductPolyFormat = stringProductPolyFormat + (" + " + productPoly[index3]);
		            }
		            else if (productPoly[index3] < 0)
		            {
		            	stringProductPolyFormat = stringProductPolyFormat + (" - " + (productPoly[index3] * -1));
		            }
		            if (index3 > 1 && index3 < 21)
		            {
		            	stringProductPolyFormat = stringProductPolyFormat + ("x^" + index3);
		            }
		            if (index3 == 1)
		            {
		            	stringProductPolyFormat = stringProductPolyFormat + ("x");
		            }
		            if (index3 == 0 && productPoly[index3] == (-1))
		            {
		            	stringProductPolyFormat = Integer.toString(productPoly[index3] * -1);
		            }
		            if (index3 == 0 && productPoly[index3] == 1)
		            {
		            	stringProductPolyFormat = Integer.toString(productPoly[index3]);
		            }
		        }
		        else if (max_exponent < index3 && index3 == 0)
		        {
		        	stringProductPolyFormat = "0";
		        }
		    }	
    	
		String stringPoly2Format = null;
    	// the calculation for displaying the polynomial layout
    	max_exponent = -1; 
		for (int index3 = (BasicCalculations.MAX_SIZE - 1); index3 >= 0; index3--) { 
		        if (poly2[index3] != 0)
		        {
		            if (max_exponent < index3)
		            {
		                if (poly2[index3] == -1)
		                {
		                    max_exponent = index3;
		                    System.out.print("-");
		                }
		                else if (poly2[index3] == 1)
		                {
		                    max_exponent = index3;
		                }
		                else
		                {
		                    max_exponent = index3;
		                    stringPoly2Format = Integer.toString(poly2[max_exponent]);
		                }
		            }
		            else if (poly2[index3] == 1)
		            {
		            	stringPoly2Format = stringPoly2Format + (" + ");
		            }
		            else if (poly2[index3] == -1)
		            {
		            	stringPoly2Format = stringPoly2Format + (" - ");
		            }
		            else if (poly2[index3] > 0)
		            {
		            	stringPoly2Format = stringPoly2Format + (" + " + poly2[index3]);
		            }
		            else if (poly2[index3] < 0)
		            {
		            	stringPoly2Format = stringPoly2Format + (" - " + (poly2[index3] * -1));
		            }
		            if (index3 > 1 && index3 < 21)
		            {
		            	stringPoly2Format = stringPoly2Format + ("x^" + index3);
		            }
		            if (index3 == 1)
		            {
		            	stringPoly2Format = stringPoly2Format + ("x");
		            }
		            if (index3 == 0 && poly2[index3] == (-1))
		            {
		            	stringPoly2Format = Integer.toString(poly2[index3] * -1);
		            }
		            if (index3 == 0 && poly2[index3] == 1)
		            {
		            	stringPoly2Format = Integer.toString(poly2[index3]);
		            }
		        }
		        else if (max_exponent < index3 && index3 == 0)
		        {
		        	stringPoly2Format = "0";
		        }
		    }	
		
		String stringPoly1Format = null;
    	// the calculation for displaying the polynomial layout
    	max_exponent = -1; 
		for (int index3 = (BasicCalculations.MAX_SIZE - 1); index3 >= 0; index3--) { 
		        if (poly1[index3] != 0)
		        {
		            if (max_exponent < index3)
		            {
		                if (poly1[index3] == -1)
		                {
		                    max_exponent = index3;
		                    System.out.print("-");
		                }
		                else if (poly1[index3] == 1)
		                {
		                    max_exponent = index3;
		                }
		                else
		                {
		                    max_exponent = index3;
		                    stringPoly1Format = Integer.toString(poly1[max_exponent]);
		                }
		            }
		            else if (poly1[index3] == 1)
		            {
		            	stringPoly1Format = stringPoly1Format + (" + ");
		            }
		            else if (poly1[index3] == -1)
		            {
		            	stringPoly1Format = stringPoly1Format + (" - ");
		            }
		            else if (poly1[index3] > 0)
		            {
		            	stringPoly1Format = stringPoly1Format + (" + " + poly1[index3]);
		            }
		            else if (poly1[index3] < 0)
		            {
		            	stringPoly1Format = stringPoly1Format + (" - " + (poly1[index3] * -1));
		            }
		            if (index3 > 1 && index3 < 21)
		            {
		            	stringPoly1Format = stringPoly1Format + ("x^" + index3);
		            }
		            if (index3 == 1)
		            {
		            	stringPoly1Format = stringPoly1Format + ("x");
		            }
		            if (index3 == 0 && poly1[index3] == (-1))
		            {
		            	stringPoly1Format = Integer.toString(poly1[index3] * -1);
		            }
		            if (index3 == 0 && poly1[index3] == 1)
		            {
		            	stringPoly1Format = Integer.toString(poly1[index3]);
		            }
		        }
		        else if (max_exponent < index3 && index3 == 0)
		        {
		        	stringPoly1Format = "0";
		        }
		    }	
		
		// setting the text for the label to show the multiplied polynomial layout
		productLayout.setText(stringProductPolyFormat);
		
		// setting the text for the label to show the first inputed polynomial layout
		polynomial1Layout.setText(stringPoly1Format);
		
		// setting the text for the label to show the second inputed polynomial layout
		polynomial2Layout.setText(stringPoly2Format);
    }
    
    /**
     * This method clears all user input in the textAreaa
     * @param event
     */
    @FXML
    void clear(ActionEvent event) {
    	userInput1.clear();
    	userInput2.clear();
    }
    
    /**
     * This method closes the current window and takes the user back to the setupView screen (menu screen)
     * @param event
     */
    @FXML
    void back(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
		
		try {
			Stage stage = (Stage) buttonBack.getScene().getWindow();
	    	stage.close();
			
			VBox root = loader.load(new FileInputStream("view/SetupView.fxml"));
			Stage EvaluateStage = new Stage();
			EvaluateStage.setScene(new Scene(root, 600, 475));
			EvaluateStage.show();

		} catch (FileNotFoundException e) {
			System.out.println("Can't open the FXML file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Problem reading FXML file");
			e.printStackTrace();
		}
    }

}

