public class HeapSorter extends SortComparer
{
	HeapSorter()
	{
		compares = 0;
		exchanges = 0;
		deltaTime = 0;
	}

	public int[] performHeapSort(int[] inputFile)
	{
		fileRandomizer(inputFile);

		compares = 0;
		exchanges = 0;

		deltaTime = System.currentTimeMillis();
		heapSort(inputFile);
		deltaTime -= System.currentTimeMillis();

		return inputFile;
	}

	//All copied code below
	/*
	https://java2blog.com/heap-sort-in-java/
	*/
	private void buildheap(int []arr) { //Modified N. Foster
 
    /*
     * As last non leaf node will be at (arr.length-1)/2 
     * so we will start from this location for heapifying the elements
     * */
    for(int i=(arr.length-1)/2; i>=0; i--){
           heapify(arr,i,arr.length-1);
      }
   }
 
   private void heapify(int[] arr, int i,int size) { //Modified N. Foster
      int left = 2*i+1;
      int right = 2*i+2;
      int max;

      this.compares++; //Added N. Foster
      if(left <= size && arr[left] > arr[i]){
         max=left;
      } else {
         max=i;
      }
 
      this.compares++; //Added N. Foster
      if(right <= size && arr[right] > arr[max]) {
         max=right;
      }
      // If max is not current node, exchange it with max of left and right child
      if(max!=i) {
         exchange(arr,i, max);
         heapify(arr, max,size);
      }
   }
 
   private void exchange(int[] arr,int i, int j) { //Modified N. Foster
   		this.exchanges++; //added N. Foster
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t; 
   }
 
   private int[] heapSort(int[] arr) { //Modified N. Foster
 
      buildheap(arr);
      int sizeOfHeap=arr.length-1;
      for(int i=sizeOfHeap; i>0; i--) {
         exchange(arr,0, i);
         sizeOfHeap=sizeOfHeap-1;
         heapify(arr, 0,sizeOfHeap);
      }
      return arr;
   }
}