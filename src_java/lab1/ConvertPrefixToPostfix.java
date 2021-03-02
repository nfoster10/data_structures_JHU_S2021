/*
ConvertPrefixToPostix takes either a file or an equation from the user 
and attempts to convert it to a postfix equation. if successful, it prints
the original and converted equation. If not successful, an error message 
and the original equation are printed. This contains the main function 
and preps user input for processing by PrefixToPostfixConverter.
*/

import java.io.*;
import java.util.*;

public class ConvertPrefixToPostfix
{
	public static void main(String [] args)
	{
		Scanner consoleInput = new Scanner(System.in); 
		File inputFile = null;
		BufferedReader prefixEqList = null;
		String prefixEqListPath = args[0];


		try{
			inputFile = new File(prefixEqListPath);

			prefixEqList =  new BufferedReader(new FileReader(inputFile));
			///System.out.printf("\n\nFile found.\n");

			convertFile(prefixEqList);
		}
		catch(FileNotFoundException e0) {
			///System.out.printf("\n\tFile not found!");
		}
	}


	/*
	input - a list of prefix equations separated by new lines delimiters
	precondition - the file exists
	process - break the file down into separate lines for conversion
	postcondition - none
	output - none
	*/
	private static void convertFile(BufferedReader prefixEqList)
	{
		Stack inputPrefixEq = new Stack();
		char newNode;
		try{
			while ((newNode = (char) prefixEqList.read()) != -1)
			{
				
				if (newNode != '\n' && newNode != 13 && newNode != 65535)
				{
					if(newNode != ' ' && newNode != '\t') //remove white space
					{
						inputPrefixEq.push(Character.toString(newNode));
						///System.out.println(inputPrefixEq.peak() + "-"+((int)newNode));
					}
				}
				else if (inputPrefixEq.isEmpty() == false)
				{
					///System.out.println("attempt convert");
					convertEquation(inputPrefixEq);
					
					inputPrefixEq = new Stack();
				}	
				if(newNode == 65535) break;	
			}
			
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}

	/*
	input - a single prefix equation
	precondition - none
	process - convert input equation and print result
	postcondition - result printed
	output - none
	*/
	private static void convertEquation(Stack inputPrefixEq)
	{
		PrefixToPostfixConverter converter = new PrefixToPostfixConverter();
		Stack outputPostfix = new Stack();

		try(PrintWriter dataOutput = new PrintWriter(new FileWriter("output.txt", true)))
		{
			dataOutput.println("\ninput: " + inputPrefixEq);

			if(converter.prefixToPostfix(inputPrefixEq, outputPostfix))
			{
				///System.out.println("\ninput: " + inputPrefixEq);
				///System.out.println("output: " + outputPostfix.peak());
				///dataOutput.println("\ninput: " + inputPrefixEq);
				dataOutput.println("output: " + outputPostfix.peak());
			}
			else
			{	
				///System.out.println("\ninput: >" + inputPrefixEq + "<");
				///System.out.println("output: invalid equation");
				///dataOutput.println("\ninput: >" + inputPrefixEq + "<");
				dataOutput.println("output: invalid equation");
			}
		}
		catch (IOException e){
			System.out.println(e);
		}
	}
}