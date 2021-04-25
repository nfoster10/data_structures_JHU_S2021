public class NaturalMergeSorter extends SortComparer
{
	private int[] b;

	NaturalMergeSorter()
	{
		compares = 0;
		exchanges = 0;
	}

	public int[] performNaturalMergeSort(int[] inputFile)
	{
		fileRandomizer(inputFile);

		compares = 0;
		exchanges = 0;

		//naturalMergeSort(inputFile);
		sort(inputFile);

		return inputFile;
	}






	 public static void sort(Comparable[] a) {
    aux = new Comparable[a.length];
    sort(a, 0, a.length - 1);
  }

  public static boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i += 1) {
      if (a[i - 1].compareTo(a[i]) < 0) {
        return false;
      }
    }
    return true;
  }

  private static void sort(Comparable[] a, int lo, int hi) {
    int i = lo;
    int j = 0;
    int mid = 0;
    int az = 0;

    while (true) {
      i = 0;
      System.out.println("outter");
      while (i < a.length) {
        System.out.println("inner 1");
        if (i == a.length - 1) {
          break;
        } else if (a[i].compareTo(a[i + 1]) < 0) {
          break;
        }
        i++;
      }

      j = i + 1;

      while (j < a.length) {
        System.out.println("inner 2");
        if (j == a.length - 1) {
          break;
        } else if (a[j].compareTo(a[j + 1]) < 0) {
          break;
        }
        j++;
      }
      mid = lo + (j - lo) / 2;
      Merge(a, lo, mid, j);
      lo = 0;

      if (isSorted(a)) {
        break;
      }
    }
  }

  public static void Merge(Comparable[] a, int lo, int mid, int hi) {
    int i = lo;
    int j = mid + 1;

    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }

    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > hi) {
        a[k] = aux[i++];
      } else if (aux[i].compareTo(aux[j]) < 0) {
        a[k] = aux[j++];
      } else {
        a[k] = aux[i++];
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