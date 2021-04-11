import java.io.*;
import java.util.*;

public class PolynomialEvaluator
{
	public static void main(String [] args)
	{
		File inputFile = null;
		BufferedReader polynomialListReader = null;

		try{
			inputFile = new File(args[0]);

			polynomialListReader = new BufferedReader(new FileReader(inputFile));

			evaluate(polynomialListReader);
		}
		catch(FileNotFoundException){
			///System.out.printf("\n\tFile not found!");
		}
	}

	private static void evaluate(BufferedReader polynomialListReader)
	{
		
	}
}