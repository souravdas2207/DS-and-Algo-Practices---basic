package heaps;

import base.ArrayBaseUtils;

public class HeapBinaryTree {
	
	private int[] heapArray;
	private int size = 0;
	
	public HeapBinaryTree(int capacity) {
		heapArray = new int[capacity];
	}
	
	public void add(int num) {
		
		System.out.println("adding : "+num);
		
		if(size == 0) {
			heapArray[size++] = num;
			return;
		}
		
		heapArray[size] = num;
		if(!isHeapified()) 
			heapifyAbove();
		
		size++;
	}
	
	private boolean isHeapified() {
		int i = size;
		
		return heapArray[(i-1)/2] < heapArray[i];
	}
	
	private void heapifyAbove() {
		int temp = heapArray[size], fixedIndex = size;
		
		while(fixedIndex > 0) {
			if(temp < heapArray[(fixedIndex-1)/2]) {
				heapArray[fixedIndex] = heapArray[(fixedIndex-1)/2];
				fixedIndex = (fixedIndex-1)/2;
			}
			else if(temp >= heapArray[(fixedIndex-1)/2]) {
				heapArray[fixedIndex] = temp;
				return;
			}
		}
		
		heapArray[fixedIndex] = temp;
		
	}
	
	private void fixHeapBelow(int fixIndex) {
		// the replacement value set is traveling down the heapArray
		
		// checking fixIndex is a leaf node
		if((fixIndex*2 + 1) >= size)
			return;
		
		// replacement value saved 
		int temp = heapArray[fixIndex];
		
		// fixIndex has only one leaf node i.e. fixIndex is parent of last element in the heapArray
		if((fixIndex*2 + 1) == (size-1)) {
			
			if(heapArray[fixIndex] > heapArray[size-1]) {
				heapArray[fixIndex] = heapArray[fixIndex*2 + 1];
				heapArray[fixIndex*2 + 1] = temp;
			}
			return;
		}
		
		// fixIndex has two children and choosing a replacement value for fixIndex
		if(heapArray[fixIndex] > heapArray[fixIndex*2 + 1] || heapArray[fixIndex] > heapArray[fixIndex*2 + 2]) {
			// choosing the lesser value of the two children
			
			// left child is chosen as replacement at fixIndex
			if(heapArray[fixIndex*2 + 1] < heapArray[fixIndex*2 + 2]) {
				
				heapArray[fixIndex] = heapArray[fixIndex*2 + 1];
				heapArray[fixIndex*2 + 1] = temp;
				fixIndex = fixIndex*2 + 1;
				fixHeapBelow(fixIndex); // calling recursively with updated fixIndex
			}
			// right child is chosen as replacement at fixIndex
			else {
				
				heapArray[fixIndex] = heapArray[fixIndex*2 + 2];
				heapArray[fixIndex*2 + 2] = temp;
				fixIndex = fixIndex*2 + 2;
				fixHeapBelow(fixIndex); // calling recursively with updated fixIndex
			}
		}
			
	}
	
	public int peek() {
		int peek = heapArray[0];
		
		// replacing the peeked value with replacement value i.e. heapArray[size-1]
		heapArray[0] = heapArray[size-1];
		heapArray[size-1] = 0;
		size--;
		
		// fixing the heapArray below by passing the fixIndex as 0
		fixHeapBelow(0);
		
		return peek;
	}
	
	public void printHeap() {
		base.ArrayBaseUtils arrayBaseUtils = new ArrayBaseUtils();
		System.out.println(arrayBaseUtils.printArray(heapArray));
	}

	public int getSize() {
		return size;
	}
	
	public void heapSort(int[] array) {
		
	}

}
