
public class BalancedBinaryTree {

	/**
	 * @param args
	 */
	public boolean isBalanced(TreeNode root){
		if(root == null)
			return true;
		if(Math.abs(calHeight(root.left) - calHeight(root.right)) <= 1){
			if(isBalanced(root.left) && isBalanced(root.right))
				return true;
		}
		return false;
	}
	
	
	public int calHeight(TreeNode root){
		if(root == null){
			return 0;
		}
		return 1 + Math.max(calHeight(root.left), calHeight(root.right));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode rootNode = new TreeNode(1);
		rootNode.left = new TreeNode(2);
		
		rootNode.right = new TreeNode(3);
		rootNode.right.left = new TreeNode(4);
		rootNode.right.right = new TreeNode(5);
		
		BalancedBinaryTree bbt = new BalancedBinaryTree();
		System.out.println(bbt.isBalanced(rootNode));
	}

}
