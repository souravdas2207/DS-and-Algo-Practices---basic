package sortingTechniques;

import base.ArrayBaseUtils;

public class MergeSort {

	private static ArrayBaseUtils arrayBaseUtils = new ArrayBaseUtils();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {9, -8, 7, -6, 5, -4, 3, -2, 1, 0}; 
//			{ 20, 35, -11, 7, 15, -22, -75, 11, 23, -115, -11, 1 };
		
		System.out.println(arrayBaseUtils.printArray(array));

		sort(array, 0, array.length);
	}
	
	public static void sort(int[] array, int start, int end) {
		
		if(end - start < 2) { // checking if a single element array
			System.out.println("Reached smallest partition :: start="+start+" end="+end);
			return;
		}
		
		int mid = (start + end)/2;
		
		System.out.println("\n"+"inside sort"
		+"\nstart="+start+" mid="+mid+" end="+end);
		
		sort(array, start, mid); // left half of the array
		sort(array, mid, end); // right half of the array
		merge(array, start, mid, end); // merging the partitions
		
		System.out.println(arrayBaseUtils.printArray(array));
	}
	
	public static void merge(int[] array, int start, int mid, int end) {
		
		System.out.println("\n"+"inside merge (before)\n"
				+arrayBaseUtils.printArray(array)
				+"start="+start+" mid="+mid+" end="+end);
		
		if(array[mid-1]<=array[mid]) {
			System.out.println("Already Sorted :: [mid-1], [mid] : "+array[mid-1]+", "+array[mid]);
			
			return;
		}
		// only for console purpose to understand the working
		else {
			System.out.println("Requires Sorting :: [mid-1], [mid] : "+array[mid-1]+", "+array[mid]);
		}
		
		System.out.println("inside merge\n"
		+arrayBaseUtils.printArray(array)
		+"\nstart="+start+" mid="+mid+" end="+end);
		
		int i=start, j=mid, tempIndex=0;
		int[] temp = new int[end - start];
		
		// merge operation in progress
		while(i<mid && j<end) {
			temp[tempIndex++] = array[i] <= array[j] ? array[i++] : array[j++];
		}
		
		System.arraycopy(array, i, array, start+tempIndex, mid-i); // merging the unsorted left partition elements into the temp array
		System.out.println("Main Array = "+arrayBaseUtils.printArray(array));
		System.out.println("Temp Array = "+arrayBaseUtils.printArray(temp));
		System.arraycopy(temp, 0, array, start, tempIndex); // copying  temp to array 
//		System.arraycopy(src, srcPos, dest, destPos, length);
		
	}

}
