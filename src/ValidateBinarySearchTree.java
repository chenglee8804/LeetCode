
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		// TODO Auto-generated constructor stub
		val = x;
	}
}


public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean helper(TreeNode root, int min, int max) {
		if(root == null)
			return true;
		return (root.val > min) && (root.val < max) 
				&& helper(root.left, min, root.val) 
				&& helper(root.right, root.val, max);
	}
//	public boolean helper(TreeNode root, int rootValue){
//		if(root.left == null && root.right == null)
//			return true;
//		
//		if(root.left == null && root.right != null){
//			if(root.right.val > root.val)
//				return (root.right.val > rootValue) && helper(root.right, rootValue);
//		}
//		if(root.left != null && root.right == null){
//			if(root.left.val < root.val )
//				return (root.left.val < rootValue) && helper(root.left, rootValue);
//		}
//		
//		if(root.left != null && root.right != null){
//			if(root.left.val < rootValue && root.right.val > rootValue)
//				return helper(root.left, rootValue) && helper(root.right, rootValue);
//		}
//		
//		return false;
//	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(20);
		ValidateBinarySearchTree vbst = new ValidateBinarySearchTree();
		System.out.println(vbst.isValidBST(root));
	}
}
