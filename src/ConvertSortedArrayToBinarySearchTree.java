
public class ConvertSortedArrayToBinarySearchTree {

	/**
	 * @param args
	 */
	
	public TreeNode sortedArrayToBST(int[] num){
		if(num.length == 0)
			return null;
		return helper(num, 0, num.length - 1);
	}
	
	public TreeNode helper(int[] num, int left, int right){
		if(left > right)
			return null;
		if(left == right){
			TreeNode result = new TreeNode(num[left]);
			return result;
		}
		
		int mid = (left + right)/2;
		TreeNode result = new TreeNode(num[mid]);
		result.left = helper(num, left, mid-1);
		result.right = helper(num, mid + 1, right);
		return result;
	}
	
	public void printTree(TreeNode root){
		if(root == null){
			System.out.print("# ");
			return;
		}
		System.out.print(root.val + " ");
		printTree(root.left);
		printTree(root.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[]{1,2,3};
		ConvertSortedArrayToBinarySearchTree cccc = new ConvertSortedArrayToBinarySearchTree();
		TreeNode rootNode = cccc.sortedArrayToBST(num);
		cccc.printTree(rootNode);
	}

}
