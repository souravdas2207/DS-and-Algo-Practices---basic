package doublyLinkedList;

public class SimpleDoublyLinkedList {
	private Node currentNode = null;
	private Node head = null;
	private Node lastSearchedIndexElement = null;
	private static int listSize = 0;
	private static int lastSearchedIndex = 0;
	
	
	public Employee get(int index) {
		ArrayIndexOutOfBoundsException e = new ArrayIndexOutOfBoundsException("Bad index :: index : "+index);
		setCurrentNodeToTail();
		if(index < 0 || index >= listSize)
			throw e;
		if(index == 0)
			return head.getEmployee();
		else if(index == listSize-1) 
			return currentNode.getEmployee();
		else {
			currentNode = head;
			do {
				currentNode = currentNode.getTail();
				index--;
			}while(index > 0);
		}
		return currentNode.getEmployee();
	}
	
	public void put(Employee employee, int index) {
		ArrayIndexOutOfBoundsException e = new ArrayIndexOutOfBoundsException("Bad Index :: index : "+index);
		if(index < 0 || index >= listSize)
			throw e;
		
		if(index == 0) {
			currentNode = head;
			Node newNode = new Node();
			newNode.setEmployee(employee);
			newNode.setTail(currentNode);
			currentNode.setHead(newNode);
			head = newNode;
			setCurrentNodeToTail();
		}
		if(index == listSize-1) {
			setCurrentNodeToTail();
			Node newNode = new Node();
			newNode.setEmployee(employee);
			currentNode.setTail(newNode);
			newNode.setHead(currentNode);
		}
		if(index > 0 && index < listSize-1) {
			currentNode = head;
			
			do {

				if(index-1 == 0) {
					Node newNode = new Node();
					newNode.setEmployee(employee);
					newNode.setHead(currentNode);
					newNode.setTail(currentNode.getTail());
					currentNode.setTail(newNode);
				}
				currentNode = currentNode.getTail();
				index--;
			}while(index > 0);
		}
		
		listSize++;
	}
	
	public void add(Employee employee) {
		if(head == null) {
			currentNode = new Node();
			currentNode.setEmployee(employee);
			head = currentNode;
		}
		else {
			setCurrentNodeToTail();
			Node newNode = new Node();
			newNode.setEmployee(employee);
			currentNode.setTail(newNode);
			newNode.setHead(currentNode);
			currentNode = currentNode.getTail();
		}
		
		listSize++;
	} 
	
	public boolean delete(int index) {
		ArrayIndexOutOfBoundsException e = new ArrayIndexOutOfBoundsException("Bad index :: index : "+index);
		if(index < 0 || index >= listSize)
			throw e;
		
		if(index == 0) {
			head = head.getTail();
			if(listSize>1)
				head.setHead(null);
		}
		else if(index == listSize-1) {
			setCurrentNodeToTail();
			currentNode = currentNode.getHead();
			currentNode.setTail(null);
		}
		else {
			currentNode = head;
			do {
				if(index-1 == 0) 
					currentNode.setTail(currentNode.getTail().getTail());
				else
					currentNode = currentNode.getTail();
				index--;
			}while(index > 0);
		}
		
		listSize--;
		return true;
	}
	
	public boolean delete(Employee employee) {
		NullPointerException e = new NullPointerException("Bad element :: element : "+employee);
		if(employee == null)
			throw e;
		
		setCurrentNodeToTail();
		
		if(head.getEmployee().equals(employee)) {
			head = head.getTail();
			if(listSize>1)
				head.setHead(null);
			listSize--;
			return true;
		}
		if(currentNode.getEmployee().equals(employee)){
			currentNode = currentNode.getHead();
			currentNode.setTail(null);
			listSize--;
			return true;
		}
		if(true) {
			currentNode = head;
			do {
				if(currentNode.getTail().getEmployee().equals(employee)) {
					currentNode.setTail(currentNode.getTail().getTail());
					listSize--;
					return true;
				}
				else
					currentNode = currentNode.getTail();
			}while(currentNode.getTail().getTail()!=null);
		}
		
		
		return false;
	}
	
	public int size() {
		return listSize;
	}
	
	public void printAll() {
		System.out.println("****");
		if(listSize == 0)
			System.out.println("List is empty");
		else {
			currentNode = head;
			while(true) {
				System.out.println(currentNode.getEmployee());
				if(currentNode.getTail()!=null)
					currentNode = currentNode.getTail();
				else
					break;
			}
		}
	}
	
	private void setCurrentNodeToTail(){
//		while((currentNode = currentNode.getTail()) != null);
		while((currentNode = currentNode.getTail()!=null?currentNode.getTail():currentNode).getTail() != null);
	}
}
