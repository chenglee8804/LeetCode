
public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
		TreeNode current = root;
		while(current != null){
			if(current.left != null){
				TreeNode curLeft = current.left;
				//find the last node for current left branch:
				while(curLeft.right != null || curLeft.left != null){
					if(curLeft.right == null && curLeft.left != null){
						curLeft = curLeft.left;
						continue;
					}
					curLeft = curLeft.right;
				}
				if(curLeft.left == null){
					curLeft.right = current.right;
				}
				current.right = current.left;
				current.left = null;
				current = current.right;
			}else{
				current = current.right;
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		
		root.left.right.left = new TreeNode(7);
		root.right.left.right = new TreeNode(11);
		
		root.left.right.left.right = new TreeNode(8);
		root.left.right.left.right.left = new TreeNode(9);
		root.left.right.left.right.right = new TreeNode(10);
		
		FlattenBinaryTreeToLinkedList fl = new FlattenBinaryTreeToLinkedList();
		fl.flatten(null);
	}
}
