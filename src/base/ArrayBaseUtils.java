package base;

public class ArrayBaseUtils {
	
	public String printArray(int[] array) {
		String result = "";
		
		int index = 0;
		
		while(index < array.length) {
			
			if(index == 0 )
				result = result + "[" + String.valueOf(array[index]) + ", ";
			else if(index == array.length-1)
				result = result + String.valueOf(array[index]) + "]";
			else
				result = result + String.valueOf(array[index]) + ", ";
			
			index++;
		}
		
		return result;
	}
	
	public void swap(int[] array,int i ,int j) {
		if(i == j)
			return;
		
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
