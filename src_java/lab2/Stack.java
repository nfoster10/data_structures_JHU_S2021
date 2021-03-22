public class Stack implements Stack_I
{
	private int length;
	private Object [] stack;

	/*
		input - none
		precondition - none
		process - construct Stack of default size and 0 length
		postcondition - empty Stack created
		output - new Stack
	*/
	Stack()
	{
		this.length = 0;
		this.stack = new Object[30];
	}

	/*
		input - stack size
		precondition - none
		process - construct Stack of input stack size and length 0
		postcondition - empty Stack created
		output - new Stack
	*/
	Stack(int stackSize)
	{
		this.length = 0;
		this.stack = new Object[stackSize];
	}

	public Object pop()
	{
		length--;
		return this.stack[this.length];
	}

	public Object peak()
	{
		return this.stack[this.length - 1];
	}

	public boolean push(Object inputObject)
	{
		this.stack[this.length] = inputObject;
		this.length++;
		return (length > 0);
	}

	public boolean isEmpty()
	{
		return !(length > 0);
	}

	public int getLength()
	{
		return this.length;
	}

	public String toString()
	{
		String stackString = "";
		for(int i = 0; i < length; i++)
		{
			stackString = stackString + stack[i];
			///System.out.println(stackString);
		}

		return stackString;
	}
}