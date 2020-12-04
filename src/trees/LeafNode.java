package trees;

public class LeafNode {
	
	private int value;
	private LeafNode leftChild;
	private LeafNode rightChild;
	
	public LeafNode(int value) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
	}
	public void insert(int value) {
		// avoiding duplicates
		if(this.value == value)
			return;
		
		// if new value is lesser than the current leaf node value
		else if(value < this.value) {
			
			// if left child is not initialized
			if(leftChild == null) {
				leftChild = new LeafNode(value);
				return;
			}
			// calling insert method recursively to find the appropriate leaf
			else
				leftChild.insert(value);
		}
		
		// if new value is greater than the current leaf node value
		else if(value > this.value) {
			
			// if right child is not initialized
			if(rightChild == null) {
				rightChild = new LeafNode(value);
				return;
			}
			
			// calling insert method recursively to find the appropriate leaf
			else
				rightChild.insert(value);
		}
		
	}
	public void traverseInOrder() {
		
		if(leftChild != null)
			leftChild.traverseInOrder();
		
		System.out.print(this.getValue()+", ");
		
		if(rightChild != null)
			rightChild.traverseInOrder();
	}
	public void traversePreOrder() {
		
		System.out.print(this.getValue()+", ");
		
		if(leftChild != null)
			leftChild.traversePreOrder();
		
		if(rightChild != null)
			rightChild.traversePreOrder();
		
	}
	public void postOrderTraversal() {
		
		if(leftChild != null)
			leftChild.postOrderTraversal();
		
		if(rightChild != null)
			rightChild.postOrderTraversal();
		
		System.out.print(this.getValue()+", ");
	}
	
	public int getValue() {
		return value;
	}
	public LeafNode getLeftChild() {
		return leftChild;
	}
	public LeafNode getRightChild() {
		return rightChild;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public void setLeftChild(LeafNode leftChild) {
		this.leftChild = leftChild;
	}
	public void setRightChild(LeafNode rightChild) {
		this.rightChild = rightChild;
	}
	
}
