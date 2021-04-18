import java.io.*;
import java.util.*;

public class SortComparer
{
	public static void main (String [] args)
	{
		for (String inputFilePath : args)
		{
			readfile(inputFilePath);
		}
	}

	private static int[] readfile(String inputFilePath)
	{
		File inputFile = null;
		BufferedReader inputFileReader = null;
		int numInts = 0;

		LinkedList rawData = new LinkedList();
		char newNodeData;

		try{
			inputFile = new File(inputFilePath);

			inputFileReader = new BufferedReader(new FileReader(inputFile));


			try{
				while ((newNodeData = (char) inputFileReader.read()) != -1)
				{
					if (newNodeData != '\n' && newNodeData != 13 && newNodeData != 65535
						&& newNodeData != ' ' && newNodeData != '\t')
					{
						if(Character.isDigit(newNodeData))
							rawData.insert(Character.valueOf(newNodeData), -1);
					}
					else if (rawData.isEmpty() == false)
					{
						//this separates each number by @ if white space encountered
						if(!((Character)rawData.tail.data).equals(Character.valueOf('@')))
						{
							rawData.insert(Character.valueOf('@'), -1);
							numInts++;
						}
					}
					//this assumes end of the file reached
					//and there are extra spaces and doesnt return -1
					if(newNodeData == 65535) break;	
				}
			}
			catch (IOException e){
				///System.out.println(e);
			}
		}
		catch(FileNotFoundException e){
			///System.out.printf("\n\tFile not found!");
		}

		int[] adaptedData = new int[numInts];

		///System.out.println(rawData);

		convertLinkedListToIntArray(rawData.head, adaptedData);

		for(int i : adaptedData)
			System.out.println(i);

		return adaptedData;
	}

	private static void convertLinkedListToIntArray(ListNode inputNode, int[] adaptedData)
	{
		int data = 0;
		int currerntInt = 0;

		while(inputNode != null)
		{
			while(!((Character)inputNode.data).equals(Character.valueOf('@')))
			{
				data = 10*data + (Character.getNumericValue(((Character) inputNode.data).charValue()));
				///System.out.print("\t" + Character.getNumericValue(((Character) inputNode.data).charValue()) + " " + data);
				inputNode = inputNode.next;
			}
			///System.out.println();
			adaptedData[currerntInt] = data;
			data = 0;
			currerntInt++;
			inputNode = inputNode.next;
		}
	}
}