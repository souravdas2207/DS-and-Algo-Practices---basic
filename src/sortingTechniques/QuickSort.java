package sortingTechniques;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inputArray = {0, -1, 2, -3, 4, -5, 6, -7, 8, -9} ;
		
		sort(inputArray, 0, inputArray.length);
		
		System.out.println(new base.ArrayBaseUtils().printArray(inputArray));
	}
	
	private static void sort(int[] inputArray, int start, int end) {
		
		if((end - start) < 2)
			return;
		
		int pivotIndex = partition(inputArray, start, end);
		
		sort(inputArray, start, pivotIndex);
		sort(inputArray, pivotIndex+1, end);
		
	}
	
	private static int partition(int[] inputArray, int start, int end) {
		
		int i = start, j = end;
		System.out.println();
		int pivot = inputArray[start];
		
		System.out.format("Pivot = %d\n", pivot);
		while(j>i) {
			
/*			inputArray[i] = inputArray[--j] <= pivot && i<j ? inputArray[j] : inputArray[i];
			System.out.println("Left to right\n"+new base.ArrayBaseUtils().printArray(inputArray));
			System.out.format("i = %d, j = %d\n", i, j);
			
			inputArray[j] = inputArray[++i] >= pivot && i<j ? inputArray[i] : inputArray[j];
			System.out.println("Right to left\n"+new base.ArrayBaseUtils().printArray(inputArray));
			System.out.format("i = %d, j = %d\n", i, j);
*/			
			
			while(j>i && inputArray[--j] >= pivot);
			if(j>i)
				inputArray[i] = inputArray[j];
			System.out.println("Left to right\n"+new base.ArrayBaseUtils().printArray(inputArray));
			System.out.format("i = %d, j = %d\n", i, j);
			
			while(j>i && inputArray[++i] <= pivot);
			if(j>i)
				inputArray[j] = inputArray[i];
			System.out.println("Right to left\n"+new base.ArrayBaseUtils().printArray(inputArray));
			System.out.format("i = %d, j = %d\n", i, j);
			
		}
		
		inputArray[i] = pivot;
		System.out.println("\nEnd of while\nFinal pivot replacement\n"+new base.ArrayBaseUtils().printArray(inputArray));
		System.out.format("i = %d, j = %d\n", i, j);
		
		return i;
	}

}
