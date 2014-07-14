
public class MaximumDepthOfBinaryTree {

	/**
	 * @param args
	 */
	
	public int maxDepth(TreeNode root) {
		if(root == null){
			return 0;
		}else{
			return (Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode rootNode = new TreeNode(1);
		rootNode.left = null;
		rootNode.right = new TreeNode(2);
		rootNode.right.left = new TreeNode(3);
		rootNode.right.right = null;
		
		MaximumDepthOfBinaryTree mdbtBinaryTree = new MaximumDepthOfBinaryTree();
		System.out.println(mdbtBinaryTree.maxDepth(rootNode));

	}

}
