

public class PopulatingNextRightPointerInEachNode {

	/**
	 * @param args
	 */
	public void connect(TreeLinkNode root) {
		if(root == null)
			return;
		if(root.left == null && root.right == null){
			root.next = null;
			return;
		}
		TreeLinkNode tempRoot = root;
		tempRoot.next = null;
		while(tempRoot != null){
			TreeLinkNode startPoint = tempRoot;
			while(startPoint != null){
				if(startPoint.left == null )
					return;
				startPoint.left.next = startPoint.right;
				if(startPoint.next != null){
					startPoint.right.next = startPoint.next.left;
				}else {
					startPoint.right.next = null;
				}
				startPoint = startPoint.next;
			}
			tempRoot = tempRoot.left;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode root = new TreeLinkNode(0);
		root.left = new TreeLinkNode(1);
		root.right = new TreeLinkNode(2);
		PopulatingNextRightPointerInEachNode pppp = new PopulatingNextRightPointerInEachNode();
		pppp.connect(root);
	}

}
