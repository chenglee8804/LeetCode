import java.util.ArrayList;
import java.util.Stack;


public class BinaryTreeInorderTraversal {

	/**
	 * @param args
	 */
	public ArrayList<Integer> inorderTraversal(TreeNode root){
		ArrayList<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if(root == null)
			return result;
//		stack.push(root);
		
		TreeNode node = root;
//		TreeNode lastVisitedNode = null;
		
		while(!stack.isEmpty() || node != null){
			/*TreeNode visitingNode = stack.peek();
			if(visitingNode.left != null && visitingNode.left != lastVisitedNode){
				stack.push(visitingNode.left);
			}else {
				result.add(visitingNode.val);
				lastVisitedNode = visitingNode;
				TreeNode temp = stack.pop();
				if(temp.right != null)
					stack.push(temp.right);
			}*/
			if(node != null){
				stack.push(node);
				node = node.left;
			}else{
				node = stack.pop();
				result.add(node.val);
				node = node.right;
			}
			
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode rootNode = new TreeNode(1);
		rootNode.left = new TreeNode(2);
		
		rootNode.right = new TreeNode(3);
		rootNode.right.left = new TreeNode(4);
		rootNode.right.left.right = new TreeNode(5);
		
		BinaryTreeInorderTraversal btit = new BinaryTreeInorderTraversal();
		System.out.println(btit.inorderTraversal(rootNode));
	}

}
