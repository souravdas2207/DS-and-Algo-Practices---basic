package sortingTechniques;

public class MergeSortPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inputArray = {9, -8, 7, -6, 5, -4, 3, -2, 1, 0};
		int[] sortedArray = new int[inputArray.length];
		
		System.out.println(new base.ArrayBaseUtils().printArray(inputArray));
		
		sortedArray = new MergeSortPractice().sort(inputArray);
		
		System.out.println("Sorted Array Returned : \n"+new base.ArrayBaseUtils().printArray(sortedArray));
		
//		new base.ArrayBaseUtils().printArray(sortedArray);
	}
	
	public int[] sort(int[] inputArray) {
		
		int start = 0, end = inputArray.length;
		
		splitter(inputArray, start, end);
		
		return inputArray;
	}
	
	private static void splitter(int[] inputArray, int start, int end) {
		if((end - start)==1) {
			System.out.format("\nreached a single partition array : start = %d end = %d\n", start, end);
			return;
		}
		else {
			System.out.format("\ncontinuing to reach a single partition array : start = %d end = %d\n", start, end);
		}
		
		int mid = (start + end)/2;
		
		splitter(inputArray, start, mid);
		splitter(inputArray, mid, end);
		merge(inputArray, start, mid, end);
		
		System.out.println("returning from splitter");
		System.out.println("Sorted Array Returned : \n"+new base.ArrayBaseUtils().printArray(inputArray));
	}
	
	private static void merge (int[] inputArray, int start, int mid, int end) {
		System.out.format("\nmerging partitions [start = %d to mid = %d] and [mid+1 = %d to end = %d]\n", start, mid, (mid+1), end);
		
//		if(inputArray[mid-1]<=inputArray[mid]) {
//			return;
//		}
		
		int[] tempSortedArray = new int[end-start+1];
		int tempSortedIndex = 0, i = start, j = mid;
		
		while(i<mid && j<end) {
//		while(tempSortedIndex < tempSortedArray.length) {
//			if(i<=mid && j<=end)
				tempSortedArray[tempSortedIndex++] = inputArray[i] <= inputArray[j]? inputArray[i++] : inputArray[j++];
			
//			tempSortedArray[tempSortedIndex++] = i<=mid || j<=end ? inputArray[i++] : inputArray[j++];
		}
		System.out.format("\ni=%d, j=%d", i, j);
		
		System.out.println("temp array after sorted merge : ");
		System.out.println(new base.ArrayBaseUtils().printArray(tempSortedArray));
		
		System.arraycopy(inputArray, i, inputArray, start + tempSortedIndex, mid-i);
		System.out.println(new base.ArrayBaseUtils().printArray(inputArray));
		
		System.arraycopy(tempSortedArray, 0, inputArray, start, tempSortedIndex);
		
//		System.arraycopy(src, srcPos, dest, destPos, length);
	}
}
