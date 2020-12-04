package doublyLinkedList;

public class LinkedListCaller {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SimpleDoublyLinkedList linkedList = new SimpleDoublyLinkedList();
		
		Employee employee1 = new Employee("Sourav Das", 101);
		Employee employee2 = new Employee("Deepak Chakurkar", 102);
		Employee employee3 = new Employee("Abhilash Bhattacharya", 103);
		Employee employee4 = new Employee("Zamruth Md", 104);
		Employee employee5 = new Employee("Chittaranjan Ghosh", 105);
		Employee employee6 = new Employee("Raghavi Parthasarthi", 106);
		Employee employee7 = new Employee("Samarth Patel", 108);
		Employee employee8 = new Employee("Abhayam Yadav", 109);
		Employee employee9 = new Employee("Ananya Misra", 109);
		Employee employee10 = new Employee("Sweety Sarkar", 110);
		Employee employee11 = new Employee("Monali Sathapaty", 111);
		
		linkedList.printAll();
		
		linkedList.add(employee1);
		linkedList.add(employee2);
		
		linkedList.printAll();
		
		linkedList.add(employee3);
		
		linkedList.printAll();
		
		System.out.println("Size of LinkedList : "+linkedList.size());
		
		linkedList.put(employee4, 0);
		linkedList.put(employee5, linkedList.size()-1);
		
		linkedList.printAll();
		
		System.out.println("Size of LinkedList : "+linkedList.size());
		
		// throws ArrayIndexOutOfBoundException for a bad index
//		linkedList.put(employee6, linkedList.size());
		
		linkedList.put(employee6, 2);
		
		linkedList.printAll();
		
		System.out.println("Size of LinkedList : "+linkedList.size());
		
		System.out.println("Fetching value : "+linkedList.get(0));
		System.out.println("Fetching value : "+linkedList.get(linkedList.size()-1));
		System.out.println("Fetching value : "+linkedList.get(2));
		
//		linkedList.delete(0);
//		linkedList.delete(linkedList.size()-1);
//		linkedList.printAll();
//		System.out.println("Size of LinkedList : "+linkedList.size());
//		
//		linkedList.delete(1);
//		linkedList.printAll();
//		System.out.println("Size of LinkedList : "+linkedList.size());
		
		/*System.out.println("\n\nDeleting all till empty");
		while(linkedList.size()-1 >= 0) {
			
			// using index (behaves like stack pop - LIFO)
//			linkedList.delete(linkedList.size()-1);
			
			// using object (behave like stack pop - LIFO)
//			linkedList.delete(linkedList.get(linkedList.size()-1));
			
			linkedList.printAll();
			System.out.println("Size of LinkedList : "+linkedList.size());
		}*/
		
//		linkedList.delete(linkedList.get(linkedList.size()/2));
//		linkedList.printAll();
//		
//		linkedList.delete(linkedList.get(0));
//		linkedList.printAll();
//		
//		linkedList.delete(linkedList.get(linkedList.size()-1));
//		linkedList.printAll();
		
	}

}
