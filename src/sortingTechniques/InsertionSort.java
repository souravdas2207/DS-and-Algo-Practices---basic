package sortingTechniques;

import base.ArrayBaseUtils;

public class InsertionSort extends ArrayBaseUtils{ // stable sort
	
	private static ArrayBaseUtils arrayBaseUtils = new ArrayBaseUtils();

	public static void main(String[] args) {
		int[] array = { 20, 35, -11, 7, 15, -22 };

//		sort(array);
		
		array = new InsertionSort().returnAscendingSortedArray(array);
		
		System.out.println(arrayBaseUtils.printArray(array));
		
		array = new InsertionSort().returnDescendingSortedArray(array);
		
		System.out.println(arrayBaseUtils.printArray(array));
	}
	
	/*public static void sort(int[] array) {
		
		int i, firstUnsortedIndex, elementToBeInserted;
		
		for(firstUnsortedIndex=1; firstUnsortedIndex<array.length; firstUnsortedIndex++) {
			
			elementToBeInserted = array[firstUnsortedIndex];
			
			for (i=firstUnsortedIndex; i>0 && array[i-1]>elementToBeInserted; i--) {
				array[i] = array[i-1];
			}
			
			array[i] = elementToBeInserted;
			
		}
		
		System.out.println(arrayBaseUtils.printArray(array));
		
	}*/
	
	public static void sort(int[] array) {
		
		int i, j, max;
		
		for (i=1; i<array.length; i++) {
			
			max = array[i];
			
			for(j=i; j>0; j--) {
				if(max<array[j-1])
					array[j] = array[j-1];
				else 
					break;
			}
			
			array[j]=max;
			
			System.out.println(arrayBaseUtils.printArray(array));
		}
		
		System.out.println(arrayBaseUtils.printArray(array));
		
	}
	
	public int[] returnAscendingSortedArray(int[] array) {
		
		int unsortedIndex, j, max;
		
		// outer loops runs from index 1 assuming 0 index is sorted.
		for(unsortedIndex=1; unsortedIndex<array.length; unsortedIndex++) {
			
			// assuming the value at the unsorted index as the max value 
			// in the range [unsorted] to [0]
			// hence storing the value in a variable 'max'
			max = array[unsortedIndex]; 
			
			// inner loop runs for the above mentioned range
			// and checks for if position unsortedIndex -1 (already sorted/assumed to be sorted) > unsortedIndex (max)  
			for (j=unsortedIndex; j>0; j--) {
				
				// checking whether value at unsorted index is maximum as true
				if(array[j-1]>max) {
//					max = array[j-1];
					
					// inserting the greater value at the unsorted position to sort
					// and creating slot false max value as assumed to be inserted
					array[j] = array[j-1]; 
				}
				else
					break; // when value at position j is less than max,
				// we have found the position to insert supposed max value
			}
			
			array[j] = max; // inserting supposed max value at position j
		}
		
		return array;
	}
	
	public int[] returnDescendingSortedArray(int[] array) {
		int min, unsortedIndex, j;
		
		for (unsortedIndex = array.length-2; unsortedIndex >= 0; unsortedIndex--) {
			min = array[unsortedIndex];
			
			for (j = unsortedIndex; j < array.length-1; j++) {
				if(array[j+1]>min) {
					array[j] = array[j+1];
				}
				else
					break;
			}
			
			array[j] = min;
		}
		
		return array;
	}
}
