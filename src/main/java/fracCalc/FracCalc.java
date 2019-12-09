/**
 * @author Mr. Rasmussen
 */
package fracCalc;

import java.util.*;

public class FracCalc {
	public static void main(String[] args) {
		// takes input from the user using a scanner
		Scanner sc = new Scanner(System.in);
		// prompts the user for input
		System.out.println("Enter an expression with space separating operands and operator: (eg : 1_2/3 + 2_3/4)");
		System.out.println("Type quit to end");
		String input = sc.nextLine();
		// can take in input multiple times until user enters the word QUIT
		while (!input.equals("QUIT")) {
			String result = produceAnswer(input);
			System.out.println(result);
			input = sc.nextLine();
		}

	}

	public static String produceAnswer(String input) {
		/*
		 * ------------------------- Everything related to both of the first fractions -------------------------
		 */
		String finalFraction = "";
		// declares strings wholeNuminFraction1, numeratorOfFraction1, and
		// denominatorOfFraction1
		// finding the first space by seeing where the first occurrence of the space is
		// used, uses input.indexOf which is used to get the integer value
		int firstSpace = input.indexOf(' ');
		// finding the first space by seeing where the last occurrence of the space is
		// used, uses input.indexOf which is used to get the integer value
		int lastSpace = input.lastIndexOf(' ');
		// finding what the first fraction is, returns a part of the string which is the
		// 1st fraction
		String fraction1 = input.substring(0, firstSpace);
		// finding what the operator is, returns a part of the string which is the
		// operator
		String operator = input.substring(firstSpace + 1, lastSpace);
		//System.out.println(operator);
		// extra credit
		if (operator.equals("+")||operator.equals("-")||operator.equals("*")||operator.equals("/")) {
		} else {
			return ("ERROR: Input is in an invalid format.");
		}
		/* ------------------------- Everything regarding the first fraction of user's input*/
		// declaring the whole number in the first fraction
		String wholeNumInFraction1;
		// declaring the numerator of the first fraction
		String numeratorOfFraction1;
		// declaring the denominator of the first fraction
		String denominatorOfFraction1;
		// seeing where the whole number is in the fraction
		int wholeNumberIndexInFraction1 = fraction1.indexOf("_");
		// seeing where the / is in the first fraction
		int indexOfSlashInFraction1 = fraction1.indexOf("/");
		// used if the index is not -1
		if (wholeNumberIndexInFraction1 != -1) {
			// if the index is -1, the whole number of fraction 1 is from the beginning of
			// the string to the _, as declared in wholeNumberIndexInFraction1
			wholeNumInFraction1 = fraction1.substring(0, wholeNumberIndexInFraction1);
			// and if there is no _, then that means there is not a whole number
		} else if (indexOfSlashInFraction1 == -1) {
			// whole number is now fraction 1
			wholeNumInFraction1 = fraction1;
		} else {
			// whole number is 0
			wholeNumInFraction1 = "0";
		}
		// if the index is -1, that means there is no slash
		if (indexOfSlashInFraction1 != -1) {
			// returns the part of the string from the _ but added 1 to where the / is
			// found, which is the numerator of the first fraction
			numeratorOfFraction1 = fraction1.substring(wholeNumberIndexInFraction1 + 1, indexOfSlashInFraction1);
			// returns the part of the string from / is found + 1, which is the denominator
			// of the first fraction
			denominatorOfFraction1 = fraction1.substring(indexOfSlashInFraction1 + 1);
			// however if the index of the slash is not -1
		} else {
			// the numerator of fraction 1 is 0
			numeratorOfFraction1 = "0";
			// the denominator of fraction 1 is 1
			denominatorOfFraction1 = "1";
		}
		/* ------------------------- Simplifying the first fractions numerator and denominator ------------------------- */
		// saying that the simplified numerator of fraction 1 is the value of its whole
		// number of the first fraction times the value of its denominator plus the
		// value of its fraction
		// used Integer.parseInt to convert the string to an integer, so operations like
		// multiplication and addition could be done
		int simplifiedNumeratorFraction1 = (Integer.parseInt(wholeNumInFraction1)
				* Integer.parseInt(denominatorOfFraction1)) + Integer.parseInt(numeratorOfFraction1);
		// used if the whole number in fraction 1 is 0
		if (Integer.parseInt(wholeNumInFraction1) < 0) {
			/*
			 * takes the absolute value of the simplified numerator like before (line 88 to
			 * 89) so the computer does not get confused with negative values and then
			 * multiplies by negative 1, to get the negative number back again
			 */
			simplifiedNumeratorFraction1 = ((Math.abs(Integer.parseInt(wholeNumInFraction1))
					* Integer.parseInt(denominatorOfFraction1)) + Integer.parseInt(numeratorOfFraction1)) * -1;
		}
		// the denominator would still be the same when simplifying
		int simplifiedDenominatorFraction1 = (Integer.parseInt(denominatorOfFraction1));
		/* ------------------------- Everything regarding the second fraction of the* input -------------------------*/
		String secondfraction = input.substring(lastSpace + 1, input.length());
		// whole number in second fraction
		String wholeNumInFraction2;
		// numerator in second fraction
		String numeratorOfFraction2;
		// denominator in second fraction
		String denominatorOfFraction2;
		// seeing where the whole number is in the second fraction using index of the
		// underscore
		int wholeNumInFraction2Index = secondfraction.indexOf("_");
		// seeing where the slash is in the second fraction using index of the slash
		int indexOfSlashInFraction2 = secondfraction.indexOf("/");
		// labeling if second fraction has a whole number
		if (wholeNumInFraction2Index != -1) {
			// then the whole number in fraction 2 is from the beginning of the input to
			// where the _ is
			wholeNumInFraction2 = secondfraction.substring(0, wholeNumInFraction2Index);
			// if there is not a slash
		} else if (indexOfSlashInFraction2 == -1) {
			// the whole number in fraction 2 is the second fraction
			wholeNumInFraction2 = secondfraction;
		} else {
			// whole number is 0
			wholeNumInFraction2 = "0";
		}
		// if there is no slash
		if (indexOfSlashInFraction2 != -1) {
			// the numerator of the second fraction is from the index of the _ + 1 to the
			// index of the /
			numeratorOfFraction2 = secondfraction.substring(wholeNumInFraction2Index + 1, indexOfSlashInFraction2);
			// the denominator of the second fraction is from the index of the / + 1 to the
			// end of the input
			denominatorOfFraction2 = secondfraction.substring(indexOfSlashInFraction2 + 1);
		} else {
			// numerator is 0
			numeratorOfFraction2 = "0";
			// denominator is 1
			denominatorOfFraction2 = "1";
		}
		/* ------------------------- Simplifying the second fractions numerator and denominator -------------------------*/
		// saying that the simplified numerator of fraction 1 is the value of its whole
		// number of the first fraction times the value of its denominator plus the
		// value of its fraction
		// used Integer.parseInt to convert the string to an integer, so operations like
		// multiplication and addition could be done
		int simplifiedNumeratorFraction2 = (Integer.parseInt(wholeNumInFraction2)
				* Integer.parseInt(denominatorOfFraction2)) + Integer.parseInt(numeratorOfFraction2);
		// used if whole number is less than 0
		if (Integer.parseInt(wholeNumInFraction2) < 0) {
			//// saying that the simplified numerator of fraction 1 is the value of its
			//// whole number of the first fraction times the value of its denominator plus
			//// the value of its fraction
			// used Integer.parseInt to convert the string to an integer, so operations like
			//// multiplication and addition could be done, then multiplies by -1 so
			//// computer does not get confused
			simplifiedNumeratorFraction2 = ((Math.abs(Integer.parseInt(wholeNumInFraction2))
					* Integer.parseInt(denominatorOfFraction2)) + Integer.parseInt(numeratorOfFraction2)) * -1;
		}
		// extra credit
		if (simplifiedDenominatorFraction1 == 0) {
			return ("ERROR: Cannot divide by zero.");
		}
		if (denominatorOfFraction2.equals("0")) {
			return ("ERROR: Cannot divide by zero.");
		}
		int simplifiedDenominatorFraction2 = (Integer.parseInt(denominatorOfFraction2));
		/*------------------------- Addition -------------------------*/
		// is called when operation sign is found
		if (operator.equals("+")) {
			// if the denominators are not equal to each other
			if (simplifiedDenominatorFraction1 != simplifiedDenominatorFraction2) {
				int originalsimplifiedDenominatorFraction1 = simplifiedDenominatorFraction1;
				// then you need to multiply the first fraction denominator by the second
				// fraction denominator
				simplifiedDenominatorFraction1 = (simplifiedDenominatorFraction1 * simplifiedDenominatorFraction2);
				// then you need to multiply the first fraction numerator by the second fraction
				// denominator
				simplifiedNumeratorFraction1 = (simplifiedNumeratorFraction1 * simplifiedDenominatorFraction2);
				// then you need to multiply the second fraction denominator by the first
				// fraction denominator
				simplifiedDenominatorFraction2 = (simplifiedDenominatorFraction2
						* originalsimplifiedDenominatorFraction1);
				// then you need to multiply the second fraction numerator by the first fraction
				// denominator
				simplifiedNumeratorFraction2 = (simplifiedNumeratorFraction2 * originalsimplifiedDenominatorFraction1);
			}
			// this is used to set a total for both the numerators and the denominators
			int simplifyTotalNumerator = simplifiedNumeratorFraction1 + simplifiedNumeratorFraction2;
			int simplifyTotalDenominator = simplifiedDenominatorFraction1;
			// takes the greatest common divisor for both the numerator and the denominator
			int gcd2 = gcd(simplifyTotalNumerator, simplifyTotalDenominator);
			// if the simplified total denominator divided by the greatest common is greater
			// than 1 then
			if ((simplifyTotalDenominator / gcd2) > 1)
				// the final fraction is the simplified total numerator and the simplified total
				// denominator divided by the greatest common denominator
				finalFraction = (simplifyTotalNumerator / gcd2) + "/" + (simplifyTotalDenominator / gcd2);
			else
				finalFraction = Integer.toString(simplifyTotalNumerator / gcd2);
		}
		/* ------------------------- Subtraction -------------------------*/
		// is called when the operator is a subtraction sign, or else it will not be
		// called
		if (operator.equals("-")) {
			// if the denominators are not equal to each other
			if (simplifiedDenominatorFraction1 != simplifiedDenominatorFraction2) {
				int originalsimplifiedDenominatorFraction1 = simplifiedDenominatorFraction1;
				// then you need to multiply the first fraction denominator by the second
				simplifiedDenominatorFraction1 = (simplifiedDenominatorFraction1 * simplifiedDenominatorFraction2);
				// then you need to multiply the first fraction numerator by the second fraction
				simplifiedNumeratorFraction1 = (simplifiedNumeratorFraction1 * simplifiedDenominatorFraction2);
				// then you need to multiply the second fraction denominator by the first
				simplifiedDenominatorFraction2 = (simplifiedDenominatorFraction2
						* originalsimplifiedDenominatorFraction1);
				// then you need to multiply the second fraction numerator by the first fraction
				simplifiedNumeratorFraction2 = (simplifiedNumeratorFraction2 * originalsimplifiedDenominatorFraction1);
			}
			// setting a total so you can subtract the 2 fractions
			int simplifyTotalNumerator = simplifiedNumeratorFraction1 - simplifiedNumeratorFraction2;
			int simplifyTotalDenominator = simplifiedDenominatorFraction1;
			// if your simplify total numerator or your simplify total denominator is 0
			if (simplifyTotalNumerator == 0 || simplifyTotalDenominator == 0) {
				// then your final fraction is 0
				finalFraction = "0";
			} else {
				// multiply gcd with simplify total numerator and denominator
				int gcd2 = gcd(simplifyTotalNumerator, simplifyTotalDenominator);
				// if the simplified total denominator divided by the gcd is greater than 1
				if ((simplifyTotalDenominator / gcd2) > 1)
					//
					finalFraction = (simplifyTotalNumerator / gcd2) + "/" + (simplifyTotalDenominator / gcd2);
				else
					finalFraction = Integer.toString(simplifyTotalNumerator / gcd2);
			}
		}
	    /*-------------------------------------- Multiplication --------------------------------------*/

		//this statement is called when the operator is a multiplication sign, or else it will not be called
		// called only when the multiplication sign is found
		if (operator.equals("*")) {
			// if the simplified everything in the fraction is not a 0
			if (simplifiedNumeratorFraction1 != 0 && simplifiedDenominatorFraction1 != 0
					&& simplifiedNumeratorFraction2 != 0 && simplifiedDenominatorFraction2 != 0) {
				// then total numerator is the first simplified fractions numerator multiplied
				// by the second simplified fraction numerator
				int simplifyTotalNumerator = (simplifiedNumeratorFraction1 * simplifiedNumeratorFraction2);
				// then total denominator is the first simplified fractions denominator
				// multiplied by the second simplified fraction denominator
				int simplifyTotalDenominator = (simplifiedDenominatorFraction1 * simplifiedDenominatorFraction2);
				// uses gcd
				int gcd2 = gcd(simplifyTotalNumerator, simplifyTotalDenominator);
				// if simplify total numerator divided by gcd is bigger than 1
				if ((simplifyTotalDenominator / gcd2) > 1)
					// final fraction is the simplified total numerator divided by the gcd and then
					// a division sign is added and then a simplified total denominator divided by
					// the gcd is then added
					finalFraction = (simplifyTotalNumerator / gcd2) + "/" + (simplifyTotalDenominator / gcd2);
				else
					// final fraction is simplify total numeurator divided by gcd
					finalFraction = Integer.toString(simplifyTotalNumerator / gcd2);
			} else {
				// final fraction is 0
				finalFraction = "0";
			}
		}
		/*-------------------------------------- Division --------------------------------------*/
		 //this statement is called when the operator is a division sign, or else it will not be called
		if (operator.equals("/")) {
			// this is used when the first and second fraction numerator & denominator is
			// not 0
			if (simplifiedNumeratorFraction1 != 0 && simplifiedDenominatorFraction1 != 0
					&& simplifiedNumeratorFraction2 != 0 && simplifiedDenominatorFraction2 != 0) {
				/*
				 * calculates the simplify total numerator of the two fractions by multiplying
				 * the numerator of the first fraction and the denominator of the second
				 * fraction because when fractions are flipped the new numerator of both of the
				 * fractions is the denominator of the first fraction multiplied the denominator
				 * of that second fraction. Basically, the second fraction is flipped and
				 * multiplied by that first fraction. This occurs in all cases
				 */
				int simplifyTotalNumerator = (simplifiedNumeratorFraction1 * simplifiedDenominatorFraction2);
				/*
				 * calculates the simplify total denominator of the two fractions by multiplying
				 * the numerator of the second fraction and the denominator of the first
				 * fraction because when fractions are flipped the new denominator of both of
				 * the fractions is the denominator of the first fraction multiplied by the
				 * numerator of that second fraction. Basically, the second fraction is flipped
				 * and multiplied by that first fraction. This occurs in all cases
				 */
				int simplifyTotalDenominator = (simplifiedNumeratorFraction2 * simplifiedDenominatorFraction1);
				// gcd of simplify total numerator and simplify total denominator is multiplied
				int gcd2 = gcd(simplifyTotalNumerator, simplifyTotalDenominator);
				// if simplify total denominator is less than 0 and simplified total numerator
				// is greater than 0
				if (simplifyTotalDenominator < 0 && simplifyTotalNumerator > 0) {
					// simplify total numerator is the simplify total numerator times -1
					simplifyTotalNumerator = simplifyTotalNumerator * -1;
					// simplify total denominator is the simplify total denominator times -1
					simplifyTotalDenominator = simplifyTotalDenominator * -1;
				}
				// if simplify total denominator and total numerator is less than 0
				if (simplifyTotalDenominator < 0 && simplifyTotalNumerator < 0) {
					// simplify total numerator is the simplify total numerator times -1
					simplifyTotalNumerator = simplifyTotalNumerator * -1;
					// simplify total denominator is the simplify total denominator times -1
					simplifyTotalDenominator = simplifyTotalDenominator * -1;
				}
				// if the absolute value of the simplify total denominator and greatest common
				// denominator is greater than 1
				if ((Math.abs(simplifyTotalDenominator) / gcd2) > 1)
					// then the final fraction would be the simplified total numerator divided by
					// the g plus a slash mark to indicate the fraction
					// and then put the simplify total denominator divided by the greatest common
					// denominator after the slash mark
					finalFraction = (simplifyTotalNumerator / gcd2) + "/" + (simplifyTotalDenominator / gcd2);
				else
					finalFraction = Integer.toString(simplifyTotalNumerator / gcd2);

			} else {
				// final fraction is 0
				finalFraction = "0";
			}
		}

		finalFraction = convertToMixedFractions(finalFraction);
		// System.out.println(" result: " + finalFraction);
		return finalFraction;

	}
	/* -------- Used for finding greatest common denominator-------- */
	// takes in finalFractionNumerator and finalFractionDenominator as input
	public static int gcd(int finalFractionNumerator, int finalFractionDenominator) {
		// takes absolute value of the numerator
		finalFractionNumerator = Math.abs(finalFractionNumerator);
		// takes absolute value of the denominator
		finalFractionDenominator = Math.abs(finalFractionDenominator);
		// returns maximum of numerator and denominator
		int mod = Math.max(finalFractionNumerator, finalFractionDenominator)
				// returns minimum of numerator and denominator
				// takes mod of the max and the min
				% Math.min(finalFractionNumerator, finalFractionDenominator);
		// while mod is greater than 0
		while (mod > 0) {
			// numerator takes minimum of final numerator and fraction denominator
			finalFractionNumerator = Math.min(finalFractionNumerator, finalFractionDenominator);
			finalFractionDenominator = mod;
			// mod takes the max of the two parameters, and the min of the two parameters, then mod's it 
			mod = Math.max(finalFractionNumerator, finalFractionDenominator)
					% Math.min(finalFractionNumerator, finalFractionDenominator);
		}
		// returns the minimum
		return Math.min(finalFractionNumerator, finalFractionDenominator);
		
	}
	/*-------------------------------------- Convert to mixed fractions method --------------------------------------
	* this method is used to convert a simplified fraction which has a final numerator over final denominator into a mixed fraction
	* a mixed number has this format 6_1/2 (6 is the first part = whole number)(1 is the second part = remainder)(2 is the third part = denominator) 
	*/ public static String convertToMixedFractions(String finalFraction) {
		// this is used when there is no fraction, meaning that the fraction is a whole
		// number and cannot be converted into a mixed fraction
		if (finalFraction.indexOf("/") == -1) {
			return finalFraction;
		}
		// this is used to find the numerator of the final fraction when it is
		// simplified
		int finalFractionNumerator = Integer.parseInt(finalFraction.substring(0, finalFraction.indexOf("/")));
		// this is used to find the denominator of the final fraction when it is
		// simplified
		int finalFractionDenominator = Integer.parseInt(finalFraction.substring(finalFraction.indexOf("/") + 1));
		// this if statement is used to say that if both of the final fraction numerator
		// and denominator has a negative value, then they cancel out, thus I used the
		// Math.abs method from the math class
		if (finalFractionNumerator < 0 && finalFractionDenominator < 0) {
			finalFractionDenominator = Math.abs(finalFractionDenominator);
			finalFractionNumerator = Math.abs(finalFractionNumerator);
		}
		// here, we call the values needed from the finalFraction class
		String finalFraction2 = finalFraction;
		// this is used when the numerator is greater than the denominator, thus, being
		// used when a mixed number is necessary
		if (Math.abs(finalFractionNumerator) > Math.abs(finalFractionDenominator)) {
			// whole number is basically found when the numerator is divided by denominator
			// which is the first part of mixed number
			int wholeNumber = finalFractionNumerator / finalFractionDenominator;
			// remainder is the second part of a mixed number, the remainder is your new
			// numerator after the whole number is calculated
			int remainder = Math.abs(finalFractionNumerator % finalFractionDenominator);
			if (remainder > 0) {
				// uses the same denominator because the denominator would be the same in any
				// case after finding the whole number and remainder
				finalFraction2 = wholeNumber + "_" + remainder + "/" + finalFractionDenominator;
			} else {
				finalFraction2 = Integer.toString(wholeNumber);
			}
		} else {
			return finalFraction2;
		}
		return finalFraction2;
	}
}