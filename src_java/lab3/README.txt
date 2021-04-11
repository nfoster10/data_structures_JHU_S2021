Files
	PolynomialEvaluator.java
		contains the main function
			main function shall read command line for input file into a double linked list and pass the linked list to a PolynomialCalculator with each character being a node
		contains a constant array of values for xyz - these can be hard coded
	PolynomialCalculator.java
		an instance of a PolynomialCalculator shall store a set of values of xyz passed to the constructor
		take an input double linked list and apply stored variable values
		-1 is returned for any invalid inputs
			invalid inputs include a character besides xyz
		a method to convert a list of characters into a:
			5x2y2z3+2x1y0z4+1x0y2z1+1x0y0z1
			pass list header to helper fxn
		helper fxn to evaluate
			for each set of values
				if the input node is null
					return 0
				if the input node is a coeficient - is a number and next is x
					return inputNode.data.parseInt * recusriveHelpterFxn(inputNode.next) 
				if the input node is x
					return xvalue^inputNode.next.data.parseInt * recursiveHelpterFxn(inputNode.next.next)
				if the input node is y
					return yvalue^inputNode.next.data.parseInt * recursiveHelpterFxn(inputNode.next.next
				if the input node is z
					return zvalue^inputNode.next.data.parseInt + recursiveHelpterFxn(inputNode.next.next
				if the input node is '+'
					return recursiveHelperFxn(inputNode.next)
				if the input node is '-'
					return -1 * recursiveHelperFxn(inputNode.next)
				else
					return -1

			TODO^ add ? : to deal with returning errors

	LinkedList.java
	LinkedList_I.java
		defines a linked list
		an instance stall store the following pointers
			a public pointer to the list head
			a public pointer to the list tail
		a method to insert/add onto the list
		a method to the delete from the list by index
		a method to delete from the list by key
	PolynomialNode
		an instance shall store the following parameters
			a pointer to the next node
			a character
