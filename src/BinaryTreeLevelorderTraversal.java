import java.util.ArrayList;


public class BinaryTreeLevelorderTraversal {

	/**
	 * @param args
	 */
	
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int max_depth = this.maxDepth(root);
		for(int i = 1; i <= max_depth; i++){
			result.add(getLevelNode(root, i));
		}
		return result;
	}
	
	public ArrayList<Integer> getLevelNode(TreeNode root, int level){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		if(level == 1){
			if(root != null)
				temp.add(root.val);
			return temp;
		}else {
			if(root.left != null)
				temp.addAll(getLevelNode(root.left, level - 1));
			if(root.right != null)
				temp.addAll(getLevelNode(root.right, level - 1));
			return temp;
		}
	}
	
	public int maxDepth(TreeNode root) {
		if(root == null){
			return 0;
		}else{
			return (Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub\
//		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//		ArrayList<Integer> e = new ArrayList<Integer>();
		TreeNode rootNode = new TreeNode(1);
		rootNode.left = null;
		rootNode.right = new TreeNode(2);
		rootNode.right.left = new TreeNode(3);
		rootNode.right.right = new TreeNode(4);
		BinaryTreeLevelorderTraversal btlot = new BinaryTreeLevelorderTraversal();
		System.out.println(btlot.levelOrder(rootNode));
	}

}
