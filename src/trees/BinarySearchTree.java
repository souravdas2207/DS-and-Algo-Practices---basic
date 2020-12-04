package trees;

public class BinarySearchTree {
	
	// root node
	private LeafNode node = null;
	
	private static LeafNode rewireSubTreeNodeRoot;
	
	public void add(int value) {
		
		// inserting into the root node - checking if node is null
		if(node == null) {
			node = new LeafNode(value);
		}
		// if root node initialized - inserting into left or right child
		else {
			node.insert(value);
		}
	}
	
	public int getMin() throws Exception {
		Exception e = new Exception("no values in the tree");
		
		if(node == null) 
			throw e;
		
		// assigning the root to temp variable to detect the last left subtree
		LeafNode tempLeftChild = node;
		
		// reassigning and retaining the subsequent left subtree and last left child node leaf, respectively
		while((tempLeftChild = tempLeftChild.getLeftChild() == null ? tempLeftChild : tempLeftChild.getLeftChild()).getLeftChild() != null);
		
		// returning the min value ie the deepest left child node/leaf
		return tempLeftChild.getValue();
	}
	
	private LeafNode getMin(LeafNode rightSubTreeRoot) {
		
		rewireSubTreeNodeRoot = rightSubTreeRoot;
		
		while((rightSubTreeRoot = rightSubTreeRoot.getLeftChild() == null ? rightSubTreeRoot : rightSubTreeRoot.getLeftChild()).getLeftChild() != null)
			if(rightSubTreeRoot.getLeftChild().getLeftChild() == null)
				rewireSubTreeNodeRoot = rightSubTreeRoot;
		
		return rightSubTreeRoot;
	}
	
	public int getMax() throws Exception {
		Exception e = new Exception("no values in the tree");
		
		if(node == null)
			throw e;
		
		// assigning the root to temp variable to detect the last right subtree
		LeafNode tempRightChild = node;
		
		// reassigning & retaining the subsequent right subtree and last right child node leaf, respectively
		while((tempRightChild = tempRightChild.getRightChild() == null ? tempRightChild : tempRightChild.getRightChild()).getRightChild() != null);
		
		// returning the max value ie the deepest right child node/leaf
		return tempRightChild.getValue();
	}
	
	private LeafNode getMax(LeafNode leftSubTreeRoot) {
		
		rewireSubTreeNodeRoot = leftSubTreeRoot;
		
		while((leftSubTreeRoot = leftSubTreeRoot.getRightChild() == null ? leftSubTreeRoot : leftSubTreeRoot.getRightChild()).getRightChild() != null)
			if(leftSubTreeRoot.getRightChild().getRightChild() == null)
				rewireSubTreeNodeRoot = leftSubTreeRoot;
		
		return leftSubTreeRoot;
	}
	
	public boolean contains(int value) {
		
		LeafNode tempLeaf;
		
		if(node.getValue() == value)
			return true;
		else {
			tempLeaf = node;
			do {
				
				/*tempLeaf = value < tempLeaf.getValue() ? tempLeaf.getLeftChild() : tempLeaf.getRightChild();
				if(tempLeaf.getValue() == value)
					return true;*/
				
				// assigning a node into tempLeaf according to BST and checking if value equals
				if((tempLeaf = value < tempLeaf.getValue() ? tempLeaf.getLeftChild() : tempLeaf.getRightChild()).getValue() == value)
					return true;
				
			}while(tempLeaf.getLeftChild() != null || tempLeaf.getRightChild() != null);
		}
		
		return false;
	}
	
	public void delete(int value) {
		
		if(node == null)
			System.out.println("No values in the tree");
		else
			node = delete(node, value);
	}
	private LeafNode delete(LeafNode node, int value) {
		
		if(value < node.getValue())
			node.setLeftChild(delete(node.getLeftChild(), value));
		else if(value > node.getValue())
			node.setRightChild(delete(node.getRightChild(), value));
		else {
			if(node.getLeftChild() == null)
				return node.getRightChild();
			else if(node.getRightChild() == null)
				return node.getLeftChild();
			else if(node.getLeftChild() != null && node.getRightChild() != null) {
				
				// storing the subTree root node into a temp variable
				LeafNode tempNode;
				
				// either to at the left subTree or the right subTree
				
				// while handling the right subTree
				
				// assigning the min of the right subTree to subTree root
				tempNode = getMin(node.getRightChild());
				
				if(tempNode.getValue() == rewireSubTreeNodeRoot.getValue()) {
					tempNode.setLeftChild(node.getLeftChild());
				}
				else {
					// re-wiring the the displaced min of the right subTree with min's right subTree
					rewireSubTreeNodeRoot.setLeftChild(tempNode.getRightChild());
					
					// re-wiring/re-mapping the left and right subTree of the subTreeRoot to the found min
					tempNode.setLeftChild(node.getLeftChild());
					tempNode.setRightChild(node.getRightChild());
				}
				
				/*// while handling left subTree
				
				// assigning the max of the left subTree to subTree root
				tempNode = getMax(node.getLeftChild());
				
				// if replacement node (tempNode) and re-wiring node are both same
				if(tempNode.getValue() == rewireSubTreeNodeRoot.getValue()) {
					tempNode.setRightChild(node.getRightChild());
				}
				else {
					// re-wiring the displaced max of the left subTree with max's left subTree
					rewireSubTreeNodeRoot.setRightChild(tempNode.getLeftChild());
					
					// re-wiring/re-mapping the left and right subTree of the subTreeRoot to the found max
					tempNode.setLeftChild(node.getLeftChild());
					tempNode.setRightChild(node.getRightChild());
				}*/
				
				// preserving the binary search tree
				// assigning the new root to subTreeRoot to be returned
				node = tempNode;
			}
		}
		
		// node / subtree root is returned at the end of each delete recursive call
		// to maintain the binaryTree
		return node;
	}
	
	public void inOrderTraversal() {
		if(node != null)
			node.traverseInOrder();
	}
	
	public void preOrderTraversal() {
		if(node != null)
			node.traversePreOrder();
	}
	
	public void postOrderTraversal() {
		if(node != null)
			node.postOrderTraversal();
	}
	
}
