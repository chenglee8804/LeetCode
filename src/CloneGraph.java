import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;


public class CloneGraph {

	/**
	 * @param args
	 */
	class UndirectedGraphNode{
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x){
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}
	
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		
		if(node == null)
			return null;
		
		LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
		Hashtable<UndirectedGraphNode, UndirectedGraphNode> record = new Hashtable<>();
		
		//add first node
		UndirectedGraphNode cpNode = new UndirectedGraphNode(node.label);
		record.put(node, cpNode);
		queue.add(node);
		
		while(!queue.isEmpty()){
			UndirectedGraphNode cur = queue.remove();
			
			ArrayList<UndirectedGraphNode> neighbor = new ArrayList<>(cur.neighbors);
			
			for(int i = 0; i < neighbor.size(); ++i){
				if(record.containsKey(neighbor)){
					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
