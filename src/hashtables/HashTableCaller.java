package hashtables;

public class HashTableCaller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
//		SimpleHashTable hashtable = new SimpleHashTable();
		
		SimpleHashTableWithLinearProbing hashtable = new SimpleHashTableWithLinearProbing();
		
		hashtable.put(employee1.getName(), employee1);
		hashtable.put(employee2.getName(), employee2);
		hashtable.put(employee3.getName(), employee3);
		hashtable.put(employee4.getName(), employee4);
		hashtable.put(employee5.getName(), employee5);
		hashtable.put(employee6.getName(), employee6);
		
		System.out.println("Printing all the elements in the hashtable : ");
		hashtable.printAll();
		
		employee6.setId(107);
		System.out.println(hashtable.put(employee6.getName(), employee6));
		hashtable.put(employee7.getName(), employee7);
		hashtable.put(employee8.getName(), employee8);
		hashtable.put(employee9.getName(), employee9);
		hashtable.put(employee10.getName(), employee10);
		hashtable.put(employee11.getName(), employee11);
		
		System.out.println("Printing all the elements in the hashtable (post update): ");
		hashtable.printAll();
		
//		System.out.println("\n\nPriting as per the get calls on the hashtable : ");
//		System.out.println(hashtable.get(employee4.getName()));
//		System.out.println(hashtable.get(employee6.getName()));
//		System.out.println(hashtable.get(employee1.getName()));
//		
//		System.out.println("\n\nDeleted Employee : "+hashtable.delete("Zamruth Md"));
//		System.out.println("Printing all the elements in the hashtable after delete : ");
//		hashtable.printAll();
//		
//		System.out.println("\n\nDeleted Employee : "+hashtable.delete("Annanya Misra"));
//		System.out.println("Printing all the elements in the hashtable after delete : ");
//		hashtable.printAll();
//		
//		System.out.println("\n\nDeleted Employee : "+hashtable.delete("Raghavi Parthasarthi"));
//		System.out.println("Printing all the elements in the hashtable after delete : ");
//		hashtable.printAll();
		
	}

}
