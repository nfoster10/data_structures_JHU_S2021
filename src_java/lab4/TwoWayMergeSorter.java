public class TwoWayMergeSorter extends SortComparer
{
	TwoWayMergeSorter()
	{
		compares = 0;
		exchanges = 0;
		deltaTime = 0;
	}

	public int[] perform2WayMergeSort(int[] inputFile)
	{
		fileRandomizer(inputFile);

		compares = 0;
		exchanges = 0;

		deltaTime = System.currentTimeMillis();
		sort(inputFile, 0, inputFile.length - 1);
		deltaTime -= System.currentTimeMillis();

		return inputFile;
	}

	/*
	below from:
	https://www.geeksforgeeks.org/merge-sort/
	*/

	/* Java program for Merge Sort */

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    private void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
        	this.compares++; //Added N. Foster
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
                this.exchanges++; //Added N. Foster
            }
            else {
                arr[k] = R[j];
                j++;
                this.exchanges++; //Added N. Foster
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    private void sort(int arr[], int l, int r)
    {
    	this.compares++;
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}