package singlyLinkedList;

public class SimpleSinglyLinkedList {
	
	private Node currentNode = null;
	private Node head = null;
//	static int currentIndex = -1;
	private static int listSize = 0;
	
	public Employee get(int index) {
		
		// throwing handled exception for a bad index insertion operation
		ArrayIndexOutOfBoundsException e = new ArrayIndexOutOfBoundsException(
				"Bad index for insertion into list. index : " + index);
		if (index < 0 || index > listSize - 1)
			throw e;
		
		Node tempNode;
		
		// checking if first element in list
		if(index == 0)
			return head.getEmployee();
		// checking if last element in list
		else if(index == listSize-1)
			return currentNode.getEmployee();
		// the element is elsewhere in the middle
		else {
			currentNode = head;
			
			do {
				// to start pointing from index = 1 and onwards
				currentNode = currentNode.getTail();
				
				// using the index to decrement to zero
				// and preventing currentNode to point to last element
				index--;
			}while(index > 0);
		}
		
		tempNode = currentNode;
		setCurrentNodeToTail();
		
		return tempNode.getEmployee();
	}
	
	public void add(Employee employee) {
		
		// checking if the list is empty
		if(currentNode == null) {
			currentNode = new Node();
			currentNode.setEmployee(employee);
//			currentIndex++;
			head = currentNode;
		}
		// adding to the end of the list
		else {
			setCurrentNodeToTail();
			
			Node newNode = new Node();
			// assigning object to newNode employee
			newNode.setEmployee(employee);
			// assigning existing tail node's tail to newNode
			currentNode.setTail(newNode);
			// assigning newNode to currentNode ie tail node
			currentNode = currentNode.getTail();
		}
		
		listSize++;
	}
	
	public void put(Employee employee, int index) throws Exception {
		
		// throwing handled exception for a bad index insertion operation
		ArrayIndexOutOfBoundsException e = 
				new ArrayIndexOutOfBoundsException("Bad index for insertion into list. index : "+index);
		if(index < 0 || index > listSize-1)
			throw e;
		
//		currentNode = head;
		Node newNode = new Node();
		int counter = 0;
		
		do {
			newNode.setEmployee(employee);
			
			// checking if value to be inserted at the head
			// assigning newNode's tail to head & assigning newNode as head
			if(index == 0) {
				newNode.setTail(head);
				head = newNode;
				break;	
			}
			
			// checking if value to be inserted at the tail
			// currentNode's ie tail node's tail points to newNode 
			if(index == listSize-1) {
				setCurrentNodeToTail();
				currentNode.setTail(newNode);
				break;
			}
			
			// checking if value to be inserted elsewhere
			if(index < listSize-1) {
				
				// **** recording the node previous to the insertion index
				// assigning head for insertion index at 1 
				// else, iterating to next node
				currentNode = counter == 0 ? head : currentNode.getTail();
				
				// checking if counter is just before the insertion index (index-1)
				if(counter == index-1) {
					
					// newNode tail points to recorded previous node's tail
					// ie next element newNode tail points to next node at insertion index
					newNode.setTail(currentNode.getTail());
					
					// previous recorded node's tail points to newNode at insertion index
					currentNode.setTail(newNode);
					
				}
				
				counter++;
			}
			
		}while(counter != index);
		
		listSize++;
		setCurrentNodeToTail();
	}
	
	public void printAll() {
		setCurrentNodeToTail();
		
		if(listSize == 0 && head == null)
			System.out.println("****\nThe list is empty");
		else {
			currentNode = head;
			
			System.out.println("****");
			
			while(true) {
				System.out.println(currentNode.getEmployee());	
				
				// retaining the currentNode value to proceed with addition into list
				if(currentNode.getTail()!=null)
					currentNode = currentNode.getTail();
				// breaking the loop when last node's tail is found null ie
				// it should have reached the tail node
				else
					break;
			}
		}
	}
	
	public int size() {
		return listSize;
	}
	
	public boolean isEmpty() {
		return listSize == 0;
	}
	
	public boolean delete(int index) {
		
		// throwing handled exception for a bad index insertion operation
		ArrayIndexOutOfBoundsException e = new ArrayIndexOutOfBoundsException(
				"Bad index for insertion into list. index : " + index);
		if (index < 0 || index > listSize - 1)
			throw e;
		
		setCurrentNodeToTail();
		
		if(index == 0) {
			head = head.getTail();
			
//			OR ** alternate method : null-ifying the head node to remove referenes
			/*currentNode = head;
			currentNode = currentNode.getTail();
//			nullifyHead();
			head = null;
			head = currentNode;*/
		}
		else{
			
			// starting from head into currentNode and iterating hence, 
			// but just before deletion index
			currentNode = head;
			while(index > 1) {
				currentNode = currentNode.getTail();
				index--;
			}
			
			// skipping the immediate node and 
			// assigning immediate node's tail to currentNode's tail
			currentNode.setTail(currentNode.getTail().getTail());
			
		}
		
//		currentNode = head;
		
//		return currentNode.getEmployee();
		listSize--;
		return true;
	}
	
	public boolean delete(Employee employee) {
		
		// checking if head's employee equals employee to be deleted
		if(head.getEmployee().equals(employee)) {
			head = head.getTail();
			listSize--;
			return true;
		}
		// 
		else {
			currentNode = head;
			
			// iterates through the list till conditions satisfy
			while(!currentNode.getTail().getEmployee().equals(employee) 
				// if next node's employee equals employee to be deleted
					&& 
				// if next node is the tail node	
					currentNode.getTail().getTail() != null) {
				
				currentNode = currentNode.getTail();
			}
			
			// skipping immediate next node and 
			// assigning immediate next node's tail to currentNode's tail
			if(currentNode.getTail().getEmployee().equals(employee)) {
				currentNode.setTail(currentNode.getTail().getTail());
				listSize--;
				return true;
			}
		}
		
		return false;
	}
	
	/*private void nullifyHead() {
		head.setEmployee(null);
		head.setTail(null);
	}*/
	
	private void setCurrentNodeToTail() {
		while(true) {
			if(currentNode.getTail() != null)
				currentNode = currentNode.getTail();
			else
				break;
		}
	}
}
