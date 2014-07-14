import java.util.ArrayList;
import java.util.Stack;


public class BinaryTreePreorderTraversal {

	/**
	 * @param args
	 */
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		TreeNode currentNode = root;
		Stack<TreeNode> parentStack = new Stack<TreeNode>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if(root == null){
			return result;
		}
		
		parentStack.push(root);
		
		while(parentStack.isEmpty() == false){
			if(currentNode != null){
				result.add(currentNode.val);
				parentStack.push(currentNode);
				currentNode = currentNode.left;
			}
			else{
				currentNode = parentStack.pop();
				currentNode = currentNode.right;
			}
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode rootNode = new TreeNode(1);
		rootNode.left = null;
		rootNode.right = new TreeNode(2);
		rootNode.right.left = new TreeNode(3);
		rootNode.right.right = null;
		BinaryTreePreorderTraversal bt = new BinaryTreePreorderTraversal();
		ArrayList<Integer> preorderArrayList = bt.preorderTraversal(rootNode);
		for(int i = 0; i < preorderArrayList.size(); i++){
			System.out.print(preorderArrayList.get(i) + " ");
		}
	}

}
