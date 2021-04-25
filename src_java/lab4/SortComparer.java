import java.io.*;
import java.util.*;

/*
The SortComparer reads from files given from the command line and performs 4 sorts.
The sorts compared are heap, 2-way merge, 3-way merge and natural merge.
A summary of the sorts including the number of exchanges and time to execute the sorts
are then given as output as well as the sorted file from each sort in a separate file.

Note: professionally in industry, it is considered bad practice to write code that must be explained
with comments. Well-written code should not need comments to explain how it works. Fxns
and variables should now be clearly named to show their purpose. In large projects, this creates
issues with code maintenance as now changes must be made in even more places to stay consistent.
Commenting code however was more useful when programming languages had restrictions on 
fxn and variable names that required frequently cryptic shorthand.
*/

public class SortComparer
{
	protected int compares;
	protected int exchanges;
	protected long deltaTime;

	//main program driver
	public static void main (String [] args)
	{
		HeapSorter heapSorter = new HeapSorter();
		TwoWayMergeSorter twoWayMergeSorter = new TwoWayMergeSorter();
		ThreeWayMergeSorter threeWayMergeSorter = new ThreeWayMergeSorter();
		NaturalMergeSorter naturalMergeSorter = new NaturalMergeSorter();

		int[] sortedInputFile = null;
		String inputFilePath = null;

		for(int i = 0; i< args.length; i++)
		{
			inputFilePath = args[i];

			try(PrintWriter summaryOutput = new PrintWriter(new FileWriter("Summary.txt",true));
				PrintWriter heapSorterOutput = new PrintWriter(new FileWriter(inputFilePath + ".HeapSorted.txt",true));
				PrintWriter twoWayMergeSorterOutput = new PrintWriter(new FileWriter(inputFilePath + ".TwoWayMergeSorted.txt",true));
				PrintWriter threeWayMergeSorterOutput = new PrintWriter(new FileWriter(inputFilePath + ".ThreeWayMergeSorted.txt",true));
				PrintWriter naturalMergeSorterOutput = new PrintWriter(new FileWriter(inputFilePath + ".NaturalMergeSorted.txt",true))){

				///System.out.println(i + ". " + inputFilePath);
				summaryOutput.println(i + ". " + inputFilePath);

				sortedInputFile = heapSorter.performHeapSort(readfile(inputFilePath));
				heapSorterOutput.printf("Compares: %d\t\tExchanges: %d\n",heapSorter.getCompares(), heapSorter.getExchanges());
				heapSorterOutput.println("Sorted Data:");
				for(int data : sortedInputFile)
					heapSorterOutput.println(data);

				sortedInputFile = twoWayMergeSorter.perform2WayMergeSort(readfile(inputFilePath));
				twoWayMergeSorterOutput.printf("Compares: %d\t\tExchanges: %d\n",twoWayMergeSorter.getCompares(), twoWayMergeSorter.getExchanges());
				twoWayMergeSorterOutput.println("Sorted Data:");
				for(int data : sortedInputFile)
					twoWayMergeSorterOutput.println(data);

				sortedInputFile = threeWayMergeSorter.perform3WayMergeSort(readfile(inputFilePath));
				threeWayMergeSorterOutput.printf("Compares: %d\t\tExchanges: %d\n",threeWayMergeSorter.getCompares(), threeWayMergeSorter.getExchanges());
				threeWayMergeSorterOutput.println("Sorted Data:");
				for(int data : sortedInputFile)
					threeWayMergeSorterOutput.println(data);

				sortedInputFile = naturalMergeSorter.performNaturalMergeSort(readfile(inputFilePath));
				naturalMergeSorterOutput.printf("Compares: %d\t\tExchanges: %d\n",naturalMergeSorter.getCompares(), naturalMergeSorter.getExchanges());
				naturalMergeSorterOutput.println("Sorted Data:");
				for(int data : sortedInputFile)
					naturalMergeSorterOutput.println(data);

				///System.out.println("\tHeapSorter");
				summaryOutput.printf("\tHeapSorter - execution time(us): %.3f\n", heapSorter.getDeltaTime());
				///System.out.printf("\t\tCompares: %d\t\tExchanges: %d\n",heapSorter.getCompares(), heapSorter.getExchanges());
				summaryOutput.printf("\t\tCompares: %d\t\tExchanges: %d\n",heapSorter.getCompares(), heapSorter.getExchanges());
				///System.out.println("\tTwoWayMergeSorter");
				summaryOutput.printf("\tTwoWayMergeSorter - execution time(us): %.3f\n", twoWayMergeSorter.getDeltaTime());
				///System.out.printf("\t\tCompares: %d\t\tExchanges: %d\n",twoWayMergeSorter.getCompares(), twoWayMergeSorter.getExchanges());
				summaryOutput.printf("\t\tCompares: %d\t\tExchanges: %d\n",twoWayMergeSorter.getCompares(), twoWayMergeSorter.getExchanges());
				///System.out.println("\tThreeWayMergeSorter");
				summaryOutput.printf("\tThreeWayMergeSorter - execution time(us): %.3f\n", threeWayMergeSorter.getDeltaTime());
				///System.out.printf("\t\tCompares: %d\t\tExchanges: %d\n",threeWayMergeSorter.getCompares(), threeWayMergeSorter.getExchanges());
				summaryOutput.printf("\t\tCompares: %d\t\tExchanges: %d\n",threeWayMergeSorter.getCompares(), threeWayMergeSorter.getExchanges());
				///System.out.println("\tNaturalMergeSorter");
				summaryOutput.printf("\tNaturalMergeSorter - execution time(us): %.3f\n", naturalMergeSorter.getDeltaTime());
				///System.out.printf("\t\tCompares: %d\t\tExchanges: %d\n",naturalMergeSorter.getCompares(), naturalMergeSorter.getExchanges());
				summaryOutput.printf("\t\tCompares: %d\t\tExchanges: %d\n",naturalMergeSorter.getCompares(), naturalMergeSorter.getExchanges());
			}
			catch (IOException e){
				///System.out.println(e);
			}
		}
	}

	/*
	inputs - an input file in the form of an integer array
	precondtion - N/A
	process - shuffle the data contained in the array
	postcondition - input integer array has been shuffled
	outputs - N/A
	*/
	public static void fileRandomizer(int [] formattedInputFiles)
	{
		//NOT IMPLEMENTED
		//not needed since able to robustly read the input files
	}

	/*
	inputs - an input path to a file to be read
	precondtion - the file exists and has a list of numbersh
	process - read the file and return in the form of an integer array ignoring non-digits
	postcondition - N/A
	outputs - an integer array of the input file
	*/
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

		///for(int i : adaptedData)
			///System.out.println(i);

		return adaptedData;
	}
	
	/*
	inputs - a current inputnode to be processed and an output array
	precondtion - numbers are separated by a '@'
	process - fill adapted array from the given linked list
	postcondition - N/A
	outputs - N/A
	*/
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

	/*
	inputs - N/A
	precondtion - N/A
	process - N/A
	postcondition - N/A
	outputs - compares, the number of compares made by the last sort
	*/
	public int getCompares()
	{
		return compares;
	}

	/*
	inputs - N/A
	precondtion - N/A
	process - N/A
	postcondition - N/A
	outputs - exchanges, the number of exchanges made by the last sort
	*/
	public int getExchanges()
	{
		return exchanges;
	}

	/*
	inputs - N/A
	precondtion - N/A
	process - N/A
	postcondition - N/A
	outputs - deltatTime, the time delta from the last sort in microseconds (us)
	*/
	public float getDeltaTime()
	{
		return (float)deltaTime / 1000;
	}
}