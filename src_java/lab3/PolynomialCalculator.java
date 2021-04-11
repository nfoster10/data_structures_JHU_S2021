public class PolynomialCalculator
{
	private int [][] xyz;

	PolynomialCalculator(int [] x, int [] y, int [] z)
	{
		xyz = new int[x.length][3];

		for (int i = 0; i < x.length; i++)
		{
			xyz[i][0] = x[i];
			xyz[i][1] = y[i];
			xyz[i][2] = z[i];
		}
	}

	public int [] process(LinkedList inputPolynomial)
	{
		int [] output = new int[xyz.length];

		for (int i = 0; i < xyz.length; i++)
		{
			output[i] = this.processHelper(inputPolynomial.head, 
				xyz[i][0], xyz[i][1], xyz[i][0]);
		}
	}

	private int processHelper(ListNode inputNode, int x, int y, int z)
	{
		if(inputNode == null)
		{
			return 0;
		}
		else if (Character.isDigit(inputNode.data) & 
			inputNode.next != null &&
			inputNode.next.data.equals(new Characater('x')))
		{
			return ((Character) inputNode.data).charValue().parseInt() * 
				processHelper(inputNode.next, x,y,z);
		}
		else if (((Character)inputNode.data).equals(new Character('x')))
		{
			return Math.pow(x,((Character) inputNode.next.data).charValue().parseInt()) * 
				processHelper(inputNode.next.next, x,y,z);
		}
		else if (((Character)inputNode.data).equals(new Character('y')))
		{
			return Math.pow(y,((Character) inputNode.next.data).charValue().parseInt()) * 
				processHelper(inputNode.next.next, x,y,z);	
		}
		else if (((Character)inputNode.data).equals(new Character('z')))
		{
			return Math.pow(z,((Character) inputNode.next.data).charValue().parseInt()) + 
				processHelper(inputNode.next.next, x,y,z);		
		}
		else if (((Character)inputNode.data).equals(new Character('+')))
		{
			return processHelper(inputNode.next, x,y,z);
		}
		else if (((Character)inputNode.data).equals(new Character('-')))
		{
			return -1 * processHelper(inputNode.next, x,y,z);
		}
		else
			return -1;

		///TODO: deal with -1 error returns
	}

}