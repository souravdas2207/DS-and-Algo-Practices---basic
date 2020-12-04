package doublyLinkedList;

public class Node {
	private Employee employee;
	private Node head = null;
	private Node tail;
	
	public Employee getEmployee() {
		return employee;
	}
	public Node getHead() {
		return head;
	}
	public Node getTail() {
		return tail;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public void setHead(Node head) {
		this.head = head;
	}
	public void setTail(Node tail) {
		this.tail = tail;
	}
		
}
