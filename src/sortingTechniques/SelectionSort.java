package sortingTechniques;

import base.ArrayBaseUtils;

public class SelectionSort extends ArrayBaseUtils{ // unstable sort
	
	private static ArrayBaseUtils arrayBaseUtils = new ArrayBaseUtils();

	public static void main(String[] args) {
		int[] array = { 20, -11, 35, -22, 15, 7 };
		
		System.out.println(arrayBaseUtils.printArray(array));

		sort(array);
	}
	
	public static void sort(int[] array) { // one loops goes opposite the other
		
		int max;
		
		for (int i = 0; i < array.length-1; i++) { // first loop goes for (n-1)th times
			
			max = i; // assuming value at i is the greatest
			
			for(int j = i+1; j < array.length; j++) { // second loop iterates (length - n) times for nth round // right to left shift
				
				if(array[j]<array[max]) // right to left shift
					max = j;
				
				
			}
			
			arrayBaseUtils.swap(array, max, i);
			
			System.out.println(arrayBaseUtils.printArray(array));
			
		}
		
//		for (int i = array.length - 1; i > 0; i--) { // first loop goes for nth times
//
//			for (int j = 0; j < i; j++) { // second loop iterates (length - n) times for nth round //
//															// left to right shift
//
//				if (array[j] > array[j + 1]) // right to left shift
//					swap(array, j, j + 1);
//			}
//
//		}
		
		System.out.println(arrayBaseUtils.printArray(array));
	}
	
}
