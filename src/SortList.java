
public class SortList {
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = slow;
         		slow = slow.next;
		fast.next = null;
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);
		return mergeTwoLists(l1, l2);
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		for(ListNode ptr = dummy; l1 != null || l2 != null; ptr = ptr.next){
			int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
			int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
			if(val1 <= val2){
				ptr.next = l1;
				l1 = l1.next;
			}else {
				ptr.next =  l2;
				l2 = l2.next;
			}
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(7);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(6);
		head.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next.next.next = new ListNode(4);
		
		SortList sl = new SortList();
		ListNode re = sl.sortList(head);
		PublicMethods.printLinkedList(re);
	}
}
