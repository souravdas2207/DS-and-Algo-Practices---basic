package lists;

public class EmployeeNode {
	public Employee employee;
	public EmployeeNode next;
	
	public EmployeeNode(Employee employee) {
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}
	
	public EmployeeNode getNext() {
		return next;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public void setNext(EmployeeNode next) {
		this.next = next;
	}
	
	public String toString() {
		return this.employee.toString();
	}
	
}
