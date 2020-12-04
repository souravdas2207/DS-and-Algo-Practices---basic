package searchingTechniques;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] inputArray = {20, -1, 64, 19, -19, 32, 7, 10};
		
		if(searchItem(inputArray, 10))
			System.out.println("Value is found");
		else
			System.out.println("Value is not found");
		
		System.out.println(new base.ArrayBaseUtils().printArray(inputArray));

	}
	
	public static boolean searchItem (int[] inputArray, int item) {
		
		inputArray = new sortingTechniques.InsertionSort().returnAscendingSortedArray(inputArray);
//		inputArray = new sortingTechniques.InsertionSort().returnDescendingSortedArray(inputArray);
		
//		System.out.println(new base.ArrayBaseUtils().printArray(inputArray));
		
		int start, mid, end;
		start = 0;
		end = inputArray.length;
		
		return searchItem(inputArray, item, start, end);
		
		
		/*while(start!=end) {
			mid = (start + end)/2;
			
			if(inputArray[mid] == item)
				return true;
			else {
				if(item > inputArray[mid]) {
//				if(item < inputArray[mid]) { // 
					start = mid+1;
				}
				else {
					end = mid;
				}
			}	
		}
		
		return false;*/
	}
		
	private static boolean searchItem(int[] sortedArray, int item, int start, int end) {
		
		int mid = (start + end)/2;
		
		System.out.println(sortedArray[mid]);
		
		if(start!=end) {
			if(sortedArray[mid] == item)
				return true;
			else {
				if(item > sortedArray[mid])
					return searchItem(sortedArray, item, mid+1, end);
				else
					return searchItem(sortedArray, item, start, mid);
			}
			
		}
		
		return false;
	}

}
