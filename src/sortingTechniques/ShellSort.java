package sortingTechniques;

import base.ArrayBaseUtils;

public class ShellSort {
	
	private static ArrayBaseUtils arrayBaseUtils = new ArrayBaseUtils();

	public static void main(String[] args) {
		int[] array = { 20, 35, -11, 7, 15, -22, -75, 11, 23, -115, -11, 1 };
		
		System.out.println(arrayBaseUtils.printArray(array)+"\n\n");
		
		sort(array);
	}

	public static void sort(int[] array) {
		
		int i, j, elementToBeInserted, gap;
		
		for(gap=array.length/2; gap>0; gap/=2) {
			
			for(i=gap; i<array.length; i++) {
				
				elementToBeInserted = array[i];
				j=i;
				while(j>=gap && array[j-gap]>elementToBeInserted) {
					array[j]=array[j-gap];
					j-=gap;
				}
				
				array[j]=elementToBeInserted;
				
				System.out.println(arrayBaseUtils.printArray(array));
			}
			
			System.out.println("\n");
			
		}
		
		System.out.println("\n"+arrayBaseUtils.printArray(array));
		
	}
}
