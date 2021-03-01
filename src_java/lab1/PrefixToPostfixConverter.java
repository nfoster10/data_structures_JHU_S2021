public class PrefixToPostfixConverter
{
	private static final String [] operators 
		= {"-", "+", "/", "*", "$"}; 
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
		Stack symbolStack = new Stack(inputEquation.length());
		Stack operatorStack = new Stack(inputEquation.length()/2 + 1);
		//char inputChar;
		String inputChar;
		//Character pop1;
		String pop1;
		//Character pop2;
		String pop2;

		for (int i = inputEquation.length() - 1; i >= 0; i--)
		{
			inputChar = Character.toString(inputEquation.charAt(i));

			if(isOperator(inputChar))
			{
				pop1 = (String) symbolStack.pop();
				pop2 = (String) symbolStack.pop();

				symbolStack.push(String.format("%s%s%s",pop1, pop2, inputChar));	
			}
			else
			{
				symbolStack.push(inputChar);
			}
		}
		outputEquation.append(symbolStack.pop());	

		return success;
	}


	/*
	input
	precondition
	process
	postcondition
	output
	*/
	private static boolean isOperator(String inputChar)
	{
		boolean inputIsOperator = false;
		for (String operator : operators)
			if (inputChar.equals(operator))
				inputIsOperator = true;

		return inputIsOperator;
	}
}


			/*
			if (isOperator(inputChar))
			{
				if(outputEquation.length() == 0)
				{
					pop1 = (Character) symbolStack.pop();
					pop2 = (Character) symbolstack.pop();

					outputEquation.append(String.format("%c%c%c",pop1.charValue(), pop2.charValue(), inputChar));
				}
				else if (outputEquation.charAt(inputEquation.length() - i))
				{//TODO: operator from input is higher order than last out
					outputEquation.insert(0, pop1.charValue());
					outputEquation.append(inputChar);
				}
				else
				{//TODO: operator form input is lower order
					operatorStack.push(inputChar);
				}
			}
			else
			{
				//TODO: add check for valid letter
				symbolStack.push(inputChar);
			}*/
			/*if (isOperator(inputChar))
			{
				if(symbolStack.isEmpty())
				{
					//operator reached but no operands
					success = false;
					break;
				}
				else
				{
					pop1 = (Character) symbolStack.pop();
					
					if(outputEquation.length() == 0)
					{
						if(symbolStack.isEmpty())
						{
							//operator reached and no operand on stack or outuput
							success = false;
							break;
						}
						else
						{
							//first operator so must pop a second time
							pop2 = (Character) symbolStack.pop();
							outputEquation.append(String.format("%c%c%c",pop1.charValue(), pop2.charValue(), inputChar));
						}
					}
					else //use output as operand
					{
						outputEquation.insert(0, pop1.charValue());
						outputEquation.append(inputChar);
					}
					
				}
			}
			else
				symbolStack.push(inputChar);*/

			/*if (isOperator(inputChar))
			{
				if (symbolStack.isEmpty())
				{	
					success = false;
					break;
				}
				else
				{	
					//System.out.println("AAA");
					pop1 = (Character) symbolStack.pop();
				}

				if (symbolStack.isEmpty())
				{
					outputEquation.insert(0,pop1.charValue());
					outputEquation.append(String.format("%c",inputChar));
					//break;
				}
				else
				{
					pop2 = (Character) symbolStack.pop();
					//System.out.println(pop1);
					outputEquation.append(String.format("%c%c%c",pop2.charValue(),pop1.charValue(),inputChar));
				}
			}
			else
			{
				//System.out.println("BBB");
				symbolStack.push(inputChar);
			}*/