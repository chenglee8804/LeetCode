
public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || head.next == null)
			return head;
		if(k < 2)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		for(ListNode prev = dummy, end = head; end != null; end = prev.next ){
			for(int i = 1; i < k && end != null; ++i){
				end = end.next;
			}
			if(end == null)
				break;
			prev = reverse(prev, prev.next, end);
		}
		return dummy.next;
	}
	
	public ListNode reverse(ListNode prev, ListNode start, ListNode end) {
//		ListNode endNext = end.next;
		ListNode current = start.next;
		ListNode preCurrent = start;
		while(current != end){
			ListNode temp = current.next;
			current.next = preCurrent;
			preCurrent = current;
			current = temp;
		}
		start.next = end.next;
		end.next = preCurrent;
		prev.next = end;
		return start;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		
		ReverseNodesInKGroup rnkg = new ReverseNodesInKGroup();
		ListNode result = rnkg.reverseKGroup(head, 3);
		PublicMethods.printLinkedList(result);
	}
}
