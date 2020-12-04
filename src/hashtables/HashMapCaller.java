package hashtables;

public class HashMapCaller {

	public static void main(String[] args) {
		
		SimpleHashMap hashMap = new SimpleHashMap();
		
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
		
		System.out.println(hashMap.put(employee1.getName(), employee1));
		System.out.println(hashMap.put(employee2.getName(), employee2));
		System.out.println(hashMap.put(employee3.getName(), employee3));
		System.out.println(hashMap.put(employee4.getName(), employee4));
		System.out.println(hashMap.put(employee5.getName(), employee5));
		System.out.println(hashMap.put(employee6.getName(), employee6));
		System.out.println(hashMap.put(employee7.getName(), employee7));
		System.out.println(hashMap.put(employee8.getName(), employee8));
		System.out.println(hashMap.put(employee9.getName(), employee9));
		System.out.println(hashMap.put(employee10.getName(), employee10));
		
		hashMap.printAll();
		
//		employee6.setId(107);
		System.out.println(hashMap.put(employee6.getName(), new Employee(employee6.getName(),107)));
		
		hashMap.printAll();
		
		System.out.println("\n\nSearching for employee with key : "+employee4.getName());
		System.out.println(hashMap.get(employee4.getName()));
		
		System.out.println("\n\nSearching for employee with key : "+employee11.getName());
		System.out.println(hashMap.get(employee11.getName()));
		
		System.out.println("\n\nDeleting employee with key : "+employee6.getName());
		System.out.println(hashMap.delete(employee6.getName()));
		
		System.out.println("\n\nDeleting employee with key : "+employee3.getName());
		System.out.println(hashMap.delete(employee3.getName()));
		
		System.out.println("\n\nDeleting employee with key : "+employee11.getName());
		System.out.println(hashMap.delete(employee11.getName()));
		
		System.out.println(hashMap.put(employee11.getName(), employee11));
		
		hashMap.printAll();
		
	}

}
