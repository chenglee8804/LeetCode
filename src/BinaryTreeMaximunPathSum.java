
public class BinaryTreeMaximunPathSum {
	private int maxSum;
	
	public int dfs(TreeNode root){
		if(root == null) return 0;
		int l = dfs(root.left);
		int r = dfs(root.right);
		
		int sum = root.val;
		if(l > 0)
			sum += l;
		if(r > 0)
			sum += r;
		maxSum = Math.max(maxSum, sum);
		if(Math.max(l, r) > 0)
			return Math.max(l, r) + root.val;
		return root.val;
	}
	
	public int maxPathSum(TreeNode root) {
		maxSum = Integer.MIN_VALUE;
		dfs(root);
		return maxSum;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(8);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(11);
		root.left.right.left = new TreeNode(4);
		root.left.right.right = new TreeNode(7);
		root.right.left = new TreeNode(1);
		BinaryTreeMaximunPathSum btmp = new BinaryTreeMaximunPathSum();
		System.out.println(btmp.maxPathSum(root));
	}
}
