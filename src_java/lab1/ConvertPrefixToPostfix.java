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

		while(true)
		{
			try{
				System.out.printf("\n\nEnter path to input prefix equation list or type a prefix equation or q to quit: ");
				if((prefixEqListPath = consoleInput.nextLine().trim()).equals("q"))
					return;

				inputFile = new File(prefixEqListPath);

				prefixEqList =  new BufferedReader(new FileReader(inputFile));
				System.out.printf("\n\nFile found.\n");

				convertFile(prefixEqList);
			}
			catch(FileNotFoundException e0) {
				System.out.printf("\n\tFile not found! Treat as input equation.");
				convertEquation(prefixEqListPath);
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
		try{
			while ((inputPrefixEq = prefixEqList.readLine()) != null)
				//&& inputPrefixEq.length() > 2)
			{
				convertEquation(inputPrefixEq.trim());
			}
		}
		catch (IOException e)
		{
			System.out.println(e);
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
		StringBuilder outputPostfix = new StringBuilder();
		//StringBuilder used since String cannot be altered

		if(converter.prefixToPostfix(inputPrefixEq, outputPostfix))
		{
			System.out.println("\ninput: " + inputPrefixEq);
			System.out.println("output: " + outputPostfix);
		}
		else
		{	
			System.out.println("\ninput: >" + inputPrefixEq + "<");
			System.out.println("output: invalid equation");
		}
	}
}