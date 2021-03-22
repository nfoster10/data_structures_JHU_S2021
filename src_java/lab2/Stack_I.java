/*
The stack class 
*/
public interface Stack_I
{
	/*
		input - none
		precondition - the stack is not empty
		process - remove the top of the stack and return to caller
		postcondition - stack length reduced by 1
		output - top of stack
	*/
	Object pop();

	/*
		input - none
		precondition - the stack is not empty
		process - return top of stack to caller
		postcondition - none
		output - top of stack
	*/
	Object peak();

	/*
		input - object to be placed at top of stack
		precondition - none
		process - new object placed at top of stack and increase stack length by 1
		postcondition - stack length increased by 1
		output - true if stack length increased by 1 or false if not increased
	*/
	boolean push(Object inputObject);

	/*
		input - none
		precondition -n none
		process - check if stacklength is greater than 0
		postcondition - none
		output - true if stack is empty, false otherwise
	*/
	boolean isEmpty();

	/**/
	int getLength();
}