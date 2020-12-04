package sortingTechniques;

public class CountingSortPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {19, 17, 5, 11, 6, 10, 9};
		int min = 5, max = 19;
		
		sort(array, min, max);
	}
	
	private static void sort(int[] array, int min, int max) {
		
		int[] count = new int[max - min + 1];
		int i;
		
		for (i = 0; i < array.length; i++) {
			count[array[i] - min]++;
		}
		
		System.out.println("Count array before in place sorting : \n"+new base.ArrayBaseUtils().printArray(count));
		
		int j=0;
/*		// needs re-work
		for (i = 0; i < array.length; i++) {
			
			while(count[array[i] - min]>0) {
				array[j++] = array[i];
				count[array[i] - min]--;
			}
				
		}
*/		
		for (i = min; i <= max; i++) {
			
			while(count[i - min]>0) {
				array[j++] = i;
				count[i - min]--;
			}
		}
		
		System.out.println(new base.ArrayBaseUtils().printArray(array));
	}

}
