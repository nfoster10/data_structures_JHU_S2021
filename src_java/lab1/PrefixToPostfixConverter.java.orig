public class PrefixToPostfixConverter
{
	private static final char [] operators 
		= {'-', '+', '/', '*', '$'}; 
	/*
	input
	precondition
	process
	postcondition
	output
	*/
	public boolean prefixToPostfix(String inputEquation, StringBuilder outputEquation)
	{
		boolean success = true;
		Stack alpha = new Stack(inputEquation.length());
		char inputChar;
		Character pop1;
		Character pop2;

		for (int i = inputEquation.length() - 1; i >= 0; i--)
		{
			inputChar = inputEquation.charAt(i);
			if (isOperator(inputChar))
			{
				if (alpha.isEmpty())
				{	
					success = false;
					break;
				}
				else
				{	
					//System.out.println("AAA");
					pop1 = (Character) alpha.pop();
				}

				if (alpha.isEmpty())
				{
					outputEquation.insert(0,pop1.charValue());
					outputEquation.append(String.format("%c",inputChar));
					//break;
				}
				else
				{
					pop2 = (Character) alpha.pop();
					//System.out.println(pop1);
					outputEquation.append(String.format("%c%c%c",pop2.charValue(),pop1.charValue(),inputChar));
				}
			}
			else
			{
				//System.out.println("BBB");
				alpha.push(inputChar);
			}
		}	

		return success;
	}


	/*
	input
	precondition
	process
	postcondition
	output
	*/
	private static boolean isOperator(char inputChar)
	{
		boolean inputIsOperator = false;
		for (char operator : operators)
			if (inputChar == operator)
				inputIsOperator = true;

		return inputIsOperator;
	}
}