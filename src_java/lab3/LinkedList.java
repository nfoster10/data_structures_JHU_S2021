public class LinkedList
{
	public ListNode head;
	public ListNode tail;

	LinkedList()
	{
		head = null;
		tail = null;
	}

	public void insert(Object newNodeData, int index)
	{
		ListNode newNode = new ListNode(newNodeData);
		if(index < 0 || this.isEmpty())
		{
			if(this.isEmpty())
			{
				head = tail = newNode;
				newNode.next = null;
			}
			else
			{
				tail.next = newNode;
				tail = newNode;
				tail.next = null;
			}
		}
		else if (index > 0)
		{
			ListNode movingNode = head;
			for (int i = 0; i < index - 1; i++)
				movingNode = movingNode.next();
			///TODO: update movingNode

		}
		else ///TODO: update head node only
		{

		}


	}

	public void delete(int index)
	{

	}

	public boolean isEmpty()
	{
		return head == null;
		///TODO: see fxn name
	}
}