
public class SymmetricTree {

	/**
	 * @param args
	 */
	
	public boolean isSymmetric(TreeNode root){
		if(root == null)
			return true;
		else
			return symmetricalEqual(root.left, root.right);
	}
	
	public boolean symmetricalEqual(TreeNode a, TreeNode b){
		if(a == null && b == null)
			return true;
		else if(a != null && b == null || a == null && b != null)
			return false;
		else if(a.val == b.val)
			return true && symmetricalEqual(a.right, b.left) 
					&& symmetricalEqual(a.left, b.right);
		else
			return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode rootNode = new TreeNode(1);
		rootNode.left = null;
		rootNode.left = new TreeNode(2);
		rootNode.left.right = new TreeNode(3);
		rootNode.left.left = null;
		
		rootNode.right = new TreeNode(2);
		rootNode.right.left = new TreeNode(3);
		rootNode.right.right = null;
		
		SymmetricTree st = new SymmetricTree();
		System.out.println(st.isSymmetric(rootNode));
	}

}
