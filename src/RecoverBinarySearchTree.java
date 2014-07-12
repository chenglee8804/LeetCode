
public class RecoverBinarySearchTree {
	//Morris traversal
	private TreeNode error1 = null;
	private TreeNode error2 = null;
	
	public void recoverTree(TreeNode root) {
		if(root == null)
			return;
		TreeNode cur = root, predecessor = null, prev = null;
		while(cur != null){
			if(cur.left == null){
				if(prev != null && prev.val > cur.val){
					if(error1 == null)
						error1 = prev;
					error2 = cur;
				}
				System.out.print(cur.val + " ");
				prev = cur;
				cur = cur.right;
			}else{
				//find the predecessor of current node:
				predecessor = cur.left;
				while(predecessor.right != null && predecessor.right != cur){
					predecessor = predecessor.right;
				}
				if(predecessor.right == null){
					predecessor.right = cur;
					cur = cur.left;
				}else{
					predecessor.right = null;
					if(prev != null && prev.val > cur.val){
						if(error1 == null)
							error1 = prev;
						error2 = cur;
					}
					System.out.print(cur.val + " ");
					prev = cur;
					cur = cur.right;
				}
			}
		}
		int temp = error1.val;
		error1.val = error2.val;
		error2.val = temp;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		root.right.left = new TreeNode(7);
		
		RecoverBinarySearchTree rbst = new RecoverBinarySearchTree();
		rbst.recoverTree(null);
		System.out.println();
		rbst.recoverTree(root);
	}
}
