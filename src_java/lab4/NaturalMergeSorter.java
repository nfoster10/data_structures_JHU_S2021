public class NaturalMergeSorter extends SortComparer
{
	private int[] b;
	private Comparable[] aux;

	NaturalMergeSorter()
	{
		compares = 0;
		exchanges = 0;
		deltaTime = 0;
	}

	public int[] performNaturalMergeSort(int[] inputFile)
	{
		fileRandomizer(inputFile);

		compares = 0;
		exchanges = 0;

		Integer[] inputFileAsInteger = new Integer[inputFile.length];
		for(int i = 0; i < inputFile.length; i++)
			inputFileAsInteger[i] = Integer.valueOf(inputFile[i]);

		this.deltaTime = System.currentTimeMillis();
		sort(inputFileAsInteger);
		this.deltaTime -= System.currentTimeMillis();

		for(int i = 0; i < inputFile.length; i++)
			inputFile[i] = inputFileAsInteger[i].intValue();

		return inputFile;
	}

	//code below from:
	/*
	https://stackoverflow.com/questions/37243200/java-natural-merge-sort-implementation
	*/


    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        int i;
        int j;
        int k;
        while (true) {                  // merge pass
            i = 0;
            while(true) {               // find, merge pair of runs
                j = i;                  // find left run
                while (++j < a.length) {
                	this.compares++; //Added N. Foster
                    if (a[j-1].compareTo(a[j]) > 0)
                        break;
                }
                this.compares++; //Added N. Foster
                if(j == a.length){      // if only one run left
                	this.compares++; //Added N. Foster
                    if(i == 0)          //   if done return
                        return;
                    else                //   else end of merge pass
                        break;
                }
                k = j;                  // find right run
                while (++k < a.length) {
                	this.compares++; //Added N. Foster
                    if (a[k-1].compareTo(a[k]) > 0){
                        break;
                    }
                }
                Merge(a, i, j, k);      // merge runs
                i = k;
                this.compares++; //Added N. Foster
                if(i == a.length)       // if end of merge pass, break
                    break;
            }
        }
    }

    // merge left and right runs
    // ll = start of left run
    // rr = start of right run == end of left run
    // ee = end of right run
    public void Merge(Comparable[] a, int ll, int rr, int ee) {
        int i = ll;
        int j = rr;
        int k;
        for (k = ll; k < ee; k++)
            aux[k] = a[k];
        k = ll;
        while(true){
            // if left element <= right element
            this.compares++; //Added N. Foster
            if (aux[i].compareTo(aux[j]) <= 0) {
            	this.exchanges++; //Added N. Foster
                a[k++] = aux[i++];      // copy left element
                this.compares++; //Added N. Foster
                if(i == rr){            // if end of left run
                    while(j < ee)       //   copy rest of right run
                        a[k++] = aux[j++];
                return;                 //   and return
                }
            } else {
            	this.exchanges++; //Added N. Foster
                a[k++] = aux[j++];      // copy right element
                this.compares++; //Added N. Foster
                if(j == ee){            // if end of right run
                    while(i < rr){      //   copy rest of left run
                        a[k++] = aux[i++];
                    }
                return;                 //   and return
                }
            }
        }
    }



	//everything below from:
	/*
	http://www.home.hs-karlsruhe.de/~pach0003/informatik_1/aufgaben/en/doc/src-html/de/hska/java/exercises/sorting/NaturalMergeSort.html#line.31
	*//*
	  private void  naturalMergeSort(int [] a) {
                    int left = 0;
                    int right = a.length - 1;
                    boolean sorted = false;
                    int l = 0;
                    int r = right;
                    
                    do {
                            sorted = true;
                            left = 0;
                            
                            while (left < right) {
                                    l = left;
                                    while (l < right &&  a[l] <= a[l + 1]) {
                                            l++;
                                    }
                                    r = l + 1;
                                    while (r == right - 1 || r < right && a[r] <= a[r + 1]) {
                                            r++;
                                    }
                                    if (r <= right) {
                                            merge(a, left, l, r);
                                            sorted = false;
                                    }
                                    left = r + 1;
                            }
                    } while (! sorted);
                    
            }
    
            /**
             * Merges the sorted sequence
             *  a[links]...a[mitte] with a[mitte+1]..a[rechts]
             *  into a sorted sequence
             *  a[links] .. a[rechts].
             *//*
        private void merge(int[] a, int left, int middle, int right) {
            int l = left;
            int r = middle + 1;
    
            for (int i = left; i <= right; i++) {
                if (r > right || (l <= middle && a[l] <= a[r])) {
                    b[i] = a[l++];
                } else if (l > middle || (r <= right && a[r] <= a[l])) {
                    b[i] = a[r++];
                }
            }
    
            for (int i = left; i <= right; i++) {
                a[i] = b[i];
            }
        }*/
}