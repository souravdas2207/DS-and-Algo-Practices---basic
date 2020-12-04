package trees;

public class TreeCaller {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BinarySearchTree tree = new BinarySearchTree();
		
		int[] input = {12, 16, 7, 20, 17, 8, 5, 10, 9, 1, 15, 19, 21};
		
		for(int a : input)
			tree.add(a);
		
		System.out.println(tree.getMax());
		System.out.println(tree.getMin());
		System.out.println(tree.contains(0));
		
		System.out.println("\nIn-order traversal : ");
		tree.inOrderTraversal();
		
		System.out.println("\nPre-order traversal : ");
		tree.preOrderTraversal();
		
		System.out.println("\nPost-order traversal : ");
		tree.postOrderTraversal();
		
		tree.delete(20);
		System.out.println("\nPost delete :: In-order traversal : ");
		tree.inOrderTraversal();
	}

}
