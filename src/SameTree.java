
public class SameTree {

	/**
	 * @param args
	 */
	
	
	public boolean isSameTree(TreeNode p, TreeNode q){
		
		if(p == null && q == null){
			return true;
		}
		
		if(p == null && q != null){
			return false;
		}
		
		if(p != null && q == null){
			return false;
		}
		
		if(p.val == q.val){
			return true && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode rootNode = new TreeNode(1);
		rootNode.left = null;
		rootNode.right = new TreeNode(2);
		rootNode.right.left = new TreeNode(3);
		rootNode.right.right = null;
		
		TreeNode rootNode2 = null;
//		rootNode2.left = null;
//		rootNode2.right = new TreeNode(2);
//		rootNode2.right.left = new TreeNode(3);
//		rootNode2.right.right = new TreeNode(4);
		
		SameTree st = new SameTree();
		System.out.println(st.isSameTree(rootNode, rootNode2));
	}

}
