
public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		dummy.next = head;
		ListNode preCurrent = dummy;
		ListNode current = head;
		
		while(current != null){
			boolean duplicated = false;
			while(current.next != null && current.val == current.next.val){
				duplicated = true;
				current.next = current.next.next;
			}
			if(duplicated){
				preCurrent.next = current.next;
				current = current.next;
				continue;
			}
			preCurrent = current;
			current = current.next;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next.next = new ListNode(5);
		
		RemoveDuplicatesFromSortedListII rm = new RemoveDuplicatesFromSortedListII();
		PublicMethods.printLinkedList(rm.deleteDuplicates(head));

	}
}
