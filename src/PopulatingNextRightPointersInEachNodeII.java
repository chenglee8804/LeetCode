class TreeLinkNode{
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) {
		val = x;
	}
}

public class PopulatingNextRightPointersInEachNodeII {
	public void connect(TreeLinkNode root) {
		while(root != null){
			TreeLinkNode mostLeft = null;
			TreeLinkNode prevNode = null;
			for(; root != null; root = root.next){
				if(mostLeft == null){
					if(root.left != null)
						mostLeft = root.left;
					else
						mostLeft = root.right;
				}
				
				if(root.left != null){
					if(prevNode != null){
						prevNode.next = root.left;
					}
					prevNode = root.left;
				}
				
				if(root.right != null){
					if(prevNode != null){
						prevNode.next = root.right;
					}
					prevNode = root.right;
				}
			}
			root = mostLeft;
		}
	}
	
	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(5);
		root.left = new TreeLinkNode(8);
		root.right = new TreeLinkNode(2);
		root.left.left = new TreeLinkNode(7);
		root.left.right = new TreeLinkNode(11);
		root.left.right.left = new TreeLinkNode(4);
		root.left.right.right = new TreeLinkNode(7);
		root.right.right = new TreeLinkNode(1);
		
		PopulatingNextRightPointersInEachNodeII pnrpe = new PopulatingNextRightPointersInEachNodeII();
		pnrpe.connect(root);
	}
}
