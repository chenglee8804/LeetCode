
public class LinkedListCycle {

	/**
	 * @param args
	 */
	
	public boolean hasCycle(ListNode head){
		ListNode fast = head;
		ListNode slow = head;
		if(head == null||(head != null && head.next == null)){
			return false;
		}
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode headListNode = null;
		//ListNode headListNode = new ListNode(1);
		//headListNode.next = new ListNode(2);
		//headListNode.next.next = new ListNode(3);
		//headListNode.next.next.next = new ListNode(4);
		//headListNode.next.next.next.next = headListNode;
		
		LinkedListCycle lsc = new LinkedListCycle();
		System.out.println(lsc.hasCycle(headListNode));
	}
}
