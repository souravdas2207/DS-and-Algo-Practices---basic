package sortingTechniques;

public class CountingSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {7, 8, 4, 8, 2, 2, 3, 6, 4, 5};
		
//		the min and max value can be retrieved from an array directly
//		by entering the array into a binary search tree
//		following the left most and the right most leaf respectively
		
		sort(array, 2, 8);
		
		System.out.println(new base.ArrayBaseUtils().printArray(array));
	}
	
	private static void sort(int[] array, int min, int max) {
		int[] countingArray = new int[max - min +1];
		
		for (int i = 0; i < array.length; i++) {
			countingArray[array[i] - min] += 1;
		}
		
		System.out.println(new base.ArrayBaseUtils().printArray(countingArray));
		
		int j=0;
		for (int i = min; i <= max; i++) {
			while(countingArray[i - min]>0) {
				array[j++] = i;
				countingArray[i - min]--;
			}
		}
		
		System.out.println(new base.ArrayBaseUtils().printArray(countingArray));
	}

}
