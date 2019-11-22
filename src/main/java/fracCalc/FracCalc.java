/**
 * @author Mr. Rasmussen
 */
package fracCalc;

import java.util.*;
import java.util.ArrayList;

import net.sf.saxon.functions.Substring;

public class FracCalc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an expression with space separating operands and operator: (eg : 1_2/3 + 2_3/4)");
		System.out.println("Type quit to end");
		String input = sc.nextLine();
		while (!input.equals("quit")) {
			String result = produceAnswer(input);
			System.out.println("Result = " + result);
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
		int firstSpace = input.indexOf(' ');
		int lastSpace = input.lastIndexOf(' ');
		String substr1 = input.substring(0, firstSpace);
		String substr2 = input.substring(firstSpace + 1, lastSpace);
		String substr3 = input.substring(lastSpace + 1, input.length());
		//assigned names
		String wholeNum;
		String num;
		String den;
		int wholeNumIndex= substr3.indexOf("_");
		int fracIndex = substr3.indexOf("/");
		
		if(wholeNumIndex!=-1) {
			wholeNum= substr3.substring(0, wholeNumIndex);
		}else if (fracIndex == -1) {
			wholeNum=substr3;
		}else {
			wholeNum="0";
		}
		if (fracIndex !=-1) {
			num = substr3.substring(wholeNumIndex + 1, fracIndex);
			den = substr3.substring(fracIndex +1);
			
		}else {
			num = "0";
			den = "1";
		}
//		if(Integer.parseInt(num) >= Integer.parseInt(den)) {
//			int num3 = Integer.parseInt(num)%Integer.parseInt(den);
//			int num2 = Integer.parseInt(num);
//			num2 /= Integer.parseInt(den);
//			wholeNum = num2 +"";
//			num = num3 + "";
//		}
		String substrthree = "whole:"+wholeNum+" numerator:"+num+" denominator:"+den;
		return substrthree;
}
}