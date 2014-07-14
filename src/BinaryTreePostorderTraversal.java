import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

	/**
	 * @param args
	 */
	
	public ArrayList<Integer> postorderTraversal(TreeNode root){
		Stack<TreeNode> parentStack = new Stack<TreeNode>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if(root == null){
			return result;
		}	
		parentStack.push(root);
		TreeNode lastnodevisited = null;
		TreeNode currentNode = root.left;
		
		while(parentStack.isEmpty() == false){
			if(currentNode != null){
				parentStack.push(currentNode);
				currentNode = currentNode.left;
			}
			else{
				TreeNode topNode = parentStack.peek();
				if(topNode.right != null && lastnodevisited != topNode.right){
					currentNode = topNode.right;
				}
				else{
					parentStack.pop();
					result.add(topNode.val);
					lastnodevisited = topNode;
				}
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
		BinaryTreePostorderTraversal bt = new BinaryTreePostorderTraversal();
		ArrayList<Integer> postorderArrayList = bt.postorderTraversal(rootNode);
		for(int i = 0; i < postorderArrayList.size(); i++){
			System.out.print(postorderArrayList.get(i) + " ");
		}

	}

}
