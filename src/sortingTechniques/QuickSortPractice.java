package sortingTechniques;

public class QuickSortPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {0, 9, 1, 8, 2, 7, 3, 6, 4, 5};
		
		sort(array, 0, array.length);
		
		System.out.println(new base.ArrayBaseUtils().printArray(array));
	}
	
	private static void sort(int[] array, int start, int end) {
		
		if((end - start) < 2)
			return;
		
		int pivotIndex = partition(array, start, end);
		
		sort(array, start, pivotIndex);
		sort(array, pivotIndex+1, end);
		
	}
	
	private static int partition(int[] array, int start, int end) {
		
		int pivot = array[start];
		
		int i = start, j = end;
		
		while(j>i) {
			
//			looking for index from Right to Left with element < pivot
			while(j>i && array[--j] >= pivot);
//			to assign value at j found to be less than pivot, from Right at index i
			
			if(j>i)
				array[i] = array[j];
			
//			value at index j is duplicated at i
//			in the next while loop, j is utilized to insert value at i which is greater than pivot
			
//			looking for index from Left to Right with element > pivot
			while(j>i && array[++i] <= pivot);
			
//			to assign value at i found to be greater than pivot from Left at index j
			if(j>i)
				array[j] = array[i];
			
		}
		
//		at the end of the loop, i is the pivot position 
//		where the pivot element must be inserted
		
		array[i] = pivot;
		
		return i;
	}

}
