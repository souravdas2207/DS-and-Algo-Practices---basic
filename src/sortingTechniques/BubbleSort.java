package sortingTechniques;

import base.ArrayBaseUtils;

public class BubbleSort extends ArrayBaseUtils{ // stable sorting

	private static ArrayBaseUtils arrayBaseUtils =  new ArrayBaseUtils();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {20, 35, -11, 7, 15, -22};
		
		sort(array);
	}

	public static void sort(int[] array) { // one loops goes opposite the other
		
		for (int i = 0; i < array.length-1; i++) { // first loop goes for nth times
			
			for(int j = array.length-1; j > i; j--) { // second loop iterates (length - n) times for nth round // right to left shift
				
				if(array[j]<array[j-1]) // right to left shift
					arrayBaseUtils.swap(array,j,j-1);
				
				System.out.println(arrayBaseUtils.printArray(array));
			}
			
			System.out.println("\n"/*+arrayBaseUtils.printArray(array)*/);
			
		}
		
//		for (int i = array.length - 1; i > 0; i--) { // first loop goes for nth times
//
//			for (int j = 0; j < i; j++) { // second loop iterates (length - n) times for nth round //
//															// right to left shift
//
//				if (array[j] > array[j + 1]) // right to left shift
//					arrayBaseUtils.swap(array, j, j + 1);
//			}
//			
//			System.out.println(arrayBaseUtils.printArray(array));
//
//		}
		
		System.out.println(arrayBaseUtils.printArray(array));
	}
	
}
