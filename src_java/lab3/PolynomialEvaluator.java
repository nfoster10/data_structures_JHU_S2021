import java.io.*;
import java.util.*;

public class PolynomialEvaluator
{
	private static final int [] X = {0,1,2}; 
	private static final int [] Y = {1,2,1};
	private static final int [] Z = {2,3,0};
	private static final int numberOfPolynomialEquations_max = 4;

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
		int numberOfPolynomialEquations = 0;
		double [][] abcd = new double [numberOfPolynomialEquations_max][X.length];
		LinkedList [] inputPolynomials = new LinkedList[numberOfPolynomialEquations_max];

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
				else if (inputPolynomial.isEmpty() == false)
				{
					///System.out.println("attempt convert");
					abcd[numberOfPolynomialEquations] = evaluateHelper(inputPolynomial);
					inputPolynomials[numberOfPolynomialEquations] = inputPolynomial;

					numberOfPolynomialEquations++;
					inputPolynomial = new LinkedList();
				}	
				if(newNodeData == 65535) break;	
			}
		}
		catch (IOException e)
		{
			///System.out.println(e);
		}
		
		///for (int i = 0; i < inputPolynomials.length; i++)
		///{
		///	System.out.printf("%c = %s =", ((int)'A' + i), inputPolynomials[i].toString());
		///	for (int j = 0; j < X.length; j++)
		///	{
		///		System.out.printf(" %.2f ", abcd[i][j]);
		///	}
		///	System.out.println();
		///}

		int a = 0;
		int b = 1;
		int c = 2;
		int d = 3;

		try (PrintWriter dataOutput = new PrintWriter(new FileWriter("output.txt", true)))
		{
			for (int i = 0; i < X.length; i++)
			{
				dataOutput.printf("Where:\n");
				for (int j = 0; j < inputPolynomials.length; j++)
				{
					dataOutput.printf("%c = %s = %.2f", ((int)'A' + j), inputPolynomials[j].toString() , abcd[j][i]);
					dataOutput.println();
				}

				dataOutput.printf("For x= %d; y= %d; z= %d;\n", X[i], Y[i], Z[i]);
				dataOutput.printf("\tA + B = %f\n", ((double) abcd[a][i] + abcd[b][i]));
				dataOutput.printf("\tA + C = %f\n", ((double) abcd[a][i] + abcd[c][i]));
				dataOutput.printf("\tA + D = %f\n", ((double) abcd[a][i] + abcd[d][i]));
				dataOutput.printf("\tB + C = %f\n", ((double) abcd[b][i] + abcd[c][i]));
				dataOutput.printf("\tB + D = %f\n", ((double) abcd[b][i] + abcd[d][i]));
				dataOutput.printf("\tC + D = %f\n", ((double) abcd[c][i] + abcd[d][i]));
				dataOutput.printf("\tB - A = %f\n", ((double) abcd[b][i] - abcd[a][i]));
				dataOutput.printf("\tB - D = %f\n", ((double) abcd[b][i] - abcd[d][i]));
				dataOutput.printf("\tA * B = %f\n", ((double) abcd[a][i] * abcd[b][i]));
				dataOutput.printf("\tA * C = %f\n", ((double) abcd[a][i] * abcd[c][i]));
				dataOutput.printf("\tA * D = %f\n", ((double) abcd[a][i] * abcd[d][i]));
				dataOutput.printf("\tB * A = %f\n", ((double) abcd[b][i] * abcd[a][i]));
				dataOutput.printf("\tB * C = %f\n", ((double) abcd[b][i] * abcd[c][i]));
				dataOutput.printf("\tB * D = %f\n", ((double) abcd[b][i] * abcd[d][i]));
				dataOutput.printf("\tC * D = %f\n", ((double) abcd[c][i] * abcd[d][i]));
			}
		}
		catch (IOException e){
			///System.out.println(e);
		}
	}

	private static double [] evaluateHelper(LinkedList inputPolynomial)
	{
		PolynomialCalculator calculator = new PolynomialCalculator(X,Y,Z);
		double [] polynomialValueList = null;

		///System.out.println("\ninput: " + inputPolynomial);

		polynomialValueList = calculator.process(inputPolynomial);

		///for (double polynomialValue : polynomialValueList)
		///{
			///if(polynomialValue != -1)
			///{
				///System.out.println("output: " + polynomialValue);
			///}
			///else
			///{
				///System.out.println("output: invalid equation - error " + polynomialValue);
			///}
		///}

		return polynomialValueList;
	}
}