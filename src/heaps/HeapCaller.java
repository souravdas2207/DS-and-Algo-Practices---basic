package heaps;

import java.util.Scanner;

public class HeapCaller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HeapBinaryTree heapBinaryTree = new HeapBinaryTree(20);
		
		int[] array = {21, 16, 1, 5, 4, 8, 12, 10, 7, 19};
		
		/*
		char input;
		boolean flag = true;
		
		Scanner sc = new Scanner(System.in);
		while(flag)
			switch(sc.next().) {
				
			}
		*/
		
		for(int i : array)
			heapBinaryTree.add(i);
		
		heapBinaryTree.printHeap();
		System.out.println("Size : "+heapBinaryTree.getSize());
		
		for (int i = 0; i < array.length; i++) {
			System.out.println("\n");
			System.out.println("Value peeked from heap : "+heapBinaryTree.peek());
			heapBinaryTree.printHeap();
			System.out.println("Size : "+heapBinaryTree.getSize());
		}
		
	}
	
	
	
	public void printMenu() {
		System.out.println("Select an option : \n");
		System.out.format("%2d. Add an element\n",1);
		System.out.format("%2d. Peek an element\n",2);
		System.out.format("%2d. Peek all elements\n",3);
		System.out.print("Your selection : ");
	}

}
