package lists;

public class LinkedListDemo {

	public static void main(String[] args) {
		
		Employee employee1 = new Employee("Sourav", 1);
		Employee employee2 = new Employee("Deepak", 2);
		Employee employee3 = new Employee("Abhilash", 3);
		
		EmployeeLinkedList employeeLinkedList = new EmployeeLinkedList();
		
		employeeLinkedList.addToFront(employee1);
		employeeLinkedList.addToFront(employee2);
		employeeLinkedList.addToFront(employee3);
		
		System.out.println("\n\n\nThe list is below");
		
		employeeLinkedList.printList();
		
		System.out.println("\n\nRemoved Node : "+employeeLinkedList.remove());
		
		System.out.println("\n\nThe list after removal");
		employeeLinkedList.printList();
		
	}

}
