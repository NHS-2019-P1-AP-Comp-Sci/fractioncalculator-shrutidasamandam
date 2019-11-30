/**
 * @author Mr. Rasmussen
 */
package fracCalc;

import java.util.*;

import net.sf.saxon.functions.Substring;

public class FracCalc {
	public static void main(String[] args) {
		// Take Input
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an expression with space separating operands and operator: (eg : 1_2/3 + 2_3/4)");
		System.out.println("Type quit to end");
		String input = sc.nextLine();
		while (!input.equals("QUIT")) {
			String result = produceAnswer(input);
			System.out.println(result);
			input = sc.nextLine();
		}

	}

	// TODO: Read the input from the user and call produceAnswer with an equation
	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	// e.g. input ==> "1/2 + 3/4"
	// e.g. return ==> "1_1/4"
	public static String produceAnswer(String input) {
		String finalFraction = "";
		// declared strings
		String wholeNumInFraction1;
		String numeratorOfFraction1;
		String denominatorOfFraction1;
		// How to find your first fraction
		int firstSpace = input.indexOf(' ');
		int lastSpace = input.lastIndexOf(' ');
		// first fraction
		String fraction1 = input.substring(0, firstSpace);
		// operator
		String operator = input.substring(firstSpace + 1, lastSpace);
		// second fraction
		String fraction2 = input.substring(lastSpace + 1, input.length());
		
		int wholeNumberIndexInFraction1 = fraction1.indexOf("_");
		int indexOfSlashInFraction1 = fraction1.indexOf("/");

		if (wholeNumberIndexInFraction1 != -1) {
			wholeNumInFraction1 = fraction1.substring(0, wholeNumberIndexInFraction1);
		} else if (indexOfSlashInFraction1 == -1) {
			wholeNumInFraction1 = fraction1;
		} else {
			wholeNumInFraction1 = "0";
		}
		if (indexOfSlashInFraction1 != -1) {
			numeratorOfFraction1 = fraction1.substring(wholeNumberIndexInFraction1 + 1, indexOfSlashInFraction1);
			denominatorOfFraction1 = fraction1.substring(indexOfSlashInFraction1 + 1);

		} else {
			numeratorOfFraction1 = "0";
			denominatorOfFraction1 = "1";
		}
		
//		if (Integer.parseInt(numeratorOfFraction1) >= Integer.parseInt(denominatorOfFraction1)) {
//			int newNumerator = Integer.parseInt(numeratorOfFraction1) % Integer.parseInt(denominatorOfFraction1);
//			int parsedNumerator = Integer.parseInt(numeratorOfFraction1);
//			parsedNumerator /= Integer.parseInt(denominatorOfFraction1);
//			wholeNumInFraction1 = parsedNumerator + "";
//			numeratorOfFraction1 = newNumerator + "";
//		}
		int simplifiedNumeratorFraction1 = (Integer.parseInt(wholeNumInFraction1) * Integer.parseInt(denominatorOfFraction1)) + Integer.parseInt(numeratorOfFraction1);
		int simplifiedDenominatorFraction1 = (Integer.parseInt(denominatorOfFraction1));
//		System.out.println("wholeNumInFraction1:" + wholeNumInFraction1 + " numeratorOfFraction1:" + numeratorOfFraction1 + " denominatorOfFraction1:" + denominatorOfFraction1 + " simplifiedNumeratorFraction1: " + simplifiedNumeratorFraction1 + " simplifiedDenominatorFraction1: " + simplifiedDenominatorFraction1);
		
		
		// beginning of how to find the second fraction
		String secondfraction = input.substring(lastSpace + 1, input.length());
		// assigned values of second fraction
		String wholeNumInFraction2;
		String numeratorOfFraction2;
		String denominatorOfFraction2;
		int wholeNumInFraction2Index = secondfraction.indexOf("_");
		int indexOfSlashInFraction2 = secondfraction.indexOf("/");
		// labeling if second fraction has a whole number
		if (wholeNumInFraction2Index != -1) {
			wholeNumInFraction2 = secondfraction.substring(0, wholeNumInFraction2Index);
		} else if (indexOfSlashInFraction2 == -1) {
			wholeNumInFraction2 = secondfraction;
		} else {
			wholeNumInFraction2 = "0";
		}
		if (indexOfSlashInFraction2 != -1) {
			numeratorOfFraction2 = secondfraction.substring(wholeNumInFraction2Index + 1, indexOfSlashInFraction2);
			denominatorOfFraction2 = secondfraction.substring(indexOfSlashInFraction2 + 1);
		} else {
			numeratorOfFraction2 = "0";
			denominatorOfFraction2 = "1";
		}
//		// second fraction having numerator or not
//		if (Integer.parseInt(numeratorOfFraction2) >= Integer.parseInt(denominatorOfFraction2)) {
//			int newNumerator = Integer.parseInt(numeratorOfFraction2) % Integer.parseInt(denominatorOfFraction2);
//			int newNumerator2 = Integer.parseInt(numeratorOfFraction2);
//			newNumerator2 /= Integer.parseInt(denominatorOfFraction2);
//			wholeNumInFraction2 = newNumerator + "";
//			numeratorOfFraction2 = newNumerator2 + "";
//
//		}
		int simplifiedNumeratorFraction2 = (Integer.parseInt(wholeNumInFraction2) * Integer.parseInt(denominatorOfFraction2)) + Integer.parseInt(numeratorOfFraction2);
		int simplifiedDenominatorFraction2 = (Integer.parseInt(denominatorOfFraction2));
//		System.out.println("wholeNumInFraction2:" + wholeNumInFraction2 + " numeratorOfFraction2:" + numeratorOfFraction2 + " denominatorOfFraction2:" + denominatorOfFraction2 + " simplifiedNumeratorFraction2: " + simplifiedNumeratorFraction2 + " simplifiedDenominatorFraction2: " + simplifiedDenominatorFraction2);

		// adding method
		
		//this line is used to find if there is an addition sign in the operation
		if (operator.equals("+")) {
		//if the denominators are not equal to each other
			if (simplifiedDenominatorFraction1 != simplifiedDenominatorFraction2) {
				int originalsimplifiedDenominatorFraction1=simplifiedDenominatorFraction1;
				int originalsimplifiedNumeratorFraction1=simplifiedNumeratorFraction1;
		//then you need to multiply the first fraction denominator by the second fraction denominator 		
				simplifiedDenominatorFraction1 = (simplifiedDenominatorFraction1 * simplifiedDenominatorFraction2);
		//then you need to multiply the first fraction numerator by the second fraction denominator
				simplifiedNumeratorFraction1 = (simplifiedNumeratorFraction1 * simplifiedDenominatorFraction2);
		//then you need to multiply the second fraction denominator by the first fraction denominator 		
				simplifiedDenominatorFraction2 = (simplifiedDenominatorFraction2 * originalsimplifiedDenominatorFraction1);
		//then you need to multiply the second fraction numerator by the first fraction denominator 		
				simplifiedNumeratorFraction2 = (simplifiedNumeratorFraction2 * originalsimplifiedDenominatorFraction1);	
//				System.out.println("simplifiedDenominatorFraction1:" + simplifiedDenominatorFraction1 + " simplifiedNumeratorFraction1:" + simplifiedNumeratorFraction1 + " simplifiedDenominatorFraction2:"+ simplifiedDenominatorFraction2 + " simplifiedNumeratorFraction2: " + simplifiedNumeratorFraction2);
			} 				
			// this is used to set a total for both the numerators and the denominators
			int simplifyTotalNumerator = simplifiedNumeratorFraction1 + simplifiedNumeratorFraction2;
			int simplifyTotalDenominator = simplifiedDenominatorFraction1;
//			System.out.println("added total is: " + simplifyTotalNumerator + "/" + simplifyTotalDenominator);
			finalFraction = simplifyTotalNumerator + "/" + simplifyTotalDenominator;
		}
		// subtracting method
		if (operator.equals("-")) {
			//if the denominators are not equal to each other
			if (simplifiedDenominatorFraction1 != simplifiedDenominatorFraction2) {
				int originalsimplifiedDenominatorFraction1=simplifiedDenominatorFraction1;
				int originalsimplifiedNumeratorFraction1=simplifiedNumeratorFraction1;
				//then you need to multiply the first fraction denominator by the second fraction denominator 		
				simplifiedDenominatorFraction1 = (simplifiedDenominatorFraction1 * simplifiedDenominatorFraction2);
				//then you need to multiply the first fraction numerator by the second fraction denominator
				simplifiedNumeratorFraction1 = (simplifiedNumeratorFraction1 * simplifiedDenominatorFraction2);
				//then you need to multiply the second fraction denominator by the first fraction denominator 		
				simplifiedDenominatorFraction2 = (simplifiedDenominatorFraction2 * originalsimplifiedDenominatorFraction1);
				//then you need to multiply the second fraction numerator by the first fraction denominator 		
				simplifiedNumeratorFraction2 = (simplifiedNumeratorFraction2 * originalsimplifiedDenominatorFraction1);	
			} 				
			//setting a total so you can subtract the 2 fractions
			int simplifyTotalNumerator = simplifiedNumeratorFraction1 - simplifiedNumeratorFraction2;
			int simplifyTotalDenominator = simplifiedDenominatorFraction1;
//			System.out.println("subtracted total is: " + simplifyTotalNumerator + "/" + simplifyTotalDenominator);	
			finalFraction = simplifyTotalNumerator + "/" + simplifyTotalDenominator;
		} 				
		// multiply method
		if (operator.equals("*")) { 		
			int simplifyTotalNumerator = (simplifiedNumeratorFraction1 * simplifiedNumeratorFraction2);
			int simplifyTotalDenominator= (simplifiedDenominatorFraction1 * simplifiedDenominatorFraction2);
//			System.out.println("multiplied total is " + simplifyTotalNumerator +"/" + simplifyTotalDenominator);
			finalFraction = simplifyTotalNumerator + "/" + simplifyTotalDenominator;

		}
		// division method
		if (operator.equals("/")) { 	
			int simplifyTotalNumerator = (simplifiedNumeratorFraction1 * simplifiedDenominatorFraction1);
			int simplifyTotalDenominator= (simplifiedDenominatorFraction1 * simplifiedNumeratorFraction2);
//		System.out.println("division total is " + simplifyTotalNumerator +"/" + simplifyTotalDenominator);
			finalFraction = simplifyTotalNumerator + "/" + simplifyTotalDenominator;
		}
		return finalFraction;
}
}