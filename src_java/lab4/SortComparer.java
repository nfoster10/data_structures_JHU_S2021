import java.io.*;
import java.util.*;

public class SortComparer
{
	protected int compares;
	protected int exchanges;
	protected long deltaTime;

	public static void main (String [] args)
	{
		///Object [] formattedInputFiles = new Object[args.length];
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


	public static void fileRandomizer(int [] formattedInputFiles)
	{
		//some random and sorted files are provided
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

		///for(int i : adaptedData)
			///System.out.println(i);

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

	public int getCompares()
	{
		return compares;
	}
	public int getExchanges()
	{
		return exchanges;
	}

	public float getDeltaTime()
	{
		return (float)deltaTime / 1000;
	}
}