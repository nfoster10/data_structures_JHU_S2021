import java.io.*;
import java.util.*;

public class PolynomialEvaluator
{
	private static final int [] X = {0,1,2}; 
	private static final int [] Y = {1,2,1};
	private static final int [] Z = {2,3,0};

	public static void main(String [] args)
	{
		File inputFile = null;
		BufferedReader polynomialListReader = null;

		try{
			inputFile = new File(args[0]);

			polynomialListReader = new BufferedReader(new FileReader(inputFile));

			evaluate(polynomialListReader);
		}
		catch(FileNotFoundException e){
			///System.out.printf("\n\tFile not found!");
		}
	}

	private static void evaluate(BufferedReader polynomialListReader)
	{
		LinkedList inputPolynomial = new LinkedList();
		char newNodeData;
		try{
			while ((newNodeData = (char) polynomialListReader.read()) != -1)
			{
				if (newNodeData != '\n' && newNodeData != 13 && newNodeData != 65535)
				{
					if(newNodeData != ' ' && newNodeData != '\t') //remove white space
					{
						inputPolynomial.insert(new Character(newNodeData), -1);
						///System.out.println(inputPrefixEq.peak() + "-"+((int)newNode));
					}
				}
				else if (inputPrefixEq.isEmpty() == false)
				{
					///System.out.println("attempt convert");
					evaluateHelper(inputPrefixEq);
					
					inputPolynomial = new LinkedList();
				}	
				if(newNode == 65535) break;	
			}
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}

	private static void evaluateHelper(LinkedList inputPolynomial)
	{
		PolynomialCalculator calculator = new PolynomialCalculator(X,Y,Z);

		try (PrintWriter dataOuput = new PrintWriter(new FileWriter("output.txt", true)))
		{
			dataOutput.println("\ninput: " + inputPrefixEq);

			int [] polynomialValueList = calculator.process(inputPolynomial);

			for (int polynomialValue : polynomialValueList)
			{
				if(polynomialValue != -1)
				{
					dataOutput.println("output: " + polynomialValue);
				}
				else
				{
					dataOutput.println("output: invalid equation - error " + polynomialValue);
				}
			}
		}
		catch (IOException e){
			System.out.println(e);
		}
	}
}