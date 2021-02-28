//holds the main fxn

import java.io.*;
import java.util.*;

public class ConvertPrefixToPostfix
{


	public static void main(String [] args)
	{
		Scanner consoleInput = new Scanner(System.in); 
		File inputFile = null;
		BufferedReader prefixEqList = null;
		String prefixEqListPath = null;

		while(true) //prompt for file path until file found
		{
			try{
				System.out.printf("\n\nEnter path to input prefix equation list or type a prefix equation: ");
				prefixEqListPath = consoleInput.nextLine().trim();

				inputFile = new File(prefixEqListPath);

				prefixEqList =  new BufferedReader(new FileReader(inputFile));
				System.out.printf("\n\nFile found.\n");

				convertFile(prefixEqList);
				//does loop continue? yes
			}
			catch(FileNotFoundException e0) {
				System.out.printf("\n\tFile not found!");
				convertEquation(prefixEqListPath);
				//does loop continue? yes
			}
		}

	}


	/*
	input
	precondition
	process
	postcondition
	output
	*/
	private static void convertFile(BufferedReader prefixEqList)
	{
		String inputPrefixEq = null;

		while ((inputPrefixEq = prefixEqList.readLine().trim()) != null)
		{
			convertEquation(inputPrefixEq);
		}
	}

	/*
	input
	precondition
	process
	postcondition
	output
	*/
	private static void convertEquation(String inputPrefixEq)
	{
		PrefixToPostfixConverter converter = new PrefixToPostfixConverter();
		String outputPostfix = new String();

		if(converter.prefixToPostfix(inputPrefixEq, outputPostfix))
		{
			System.out.println("\ninput: " + inputPrefixEq);
			System.out.println("\noutput: " + outputPostfix);
		}
		else
		{	
			System.out.println("\ninput: invalid equation");
			System.out.println("\noutput: " + inputPrefixEq);
		}
	}
}