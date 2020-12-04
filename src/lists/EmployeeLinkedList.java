package lists;

public class EmployeeLinkedList {
	
	public EmployeeNode head;
	public static int counter=0;
	
	public void addToFront(Employee employee) {
		EmployeeNode node = new EmployeeNode(employee);
		node.setNext(head);
		System.out.println("node.next : "+node.next);
		
		head = node;
		
		System.out.println(head.getEmployee().name+"\n"+"End of entry into list, size : "+(++counter)+"\n\n");
	}
	
	public EmployeeNode remove() {
		if(isEmpty())
			return null;
		
		EmployeeNode removedNode = head;
		
		head = head.getNext();
		removedNode.setNext(null);
		
		counter--;
		
		return removedNode;
	}
	
	public int getSize() {
		return counter;
	}
	
	public boolean isEmpty() {
		return head == null;
	}

	public void printList() {
		EmployeeNode current = head;
		
		while(current!=null) {
			System.out.println(current);
			current = current.getNext();
		}
	}	

}
