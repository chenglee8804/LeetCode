
public class ReorderList {
	public void reorderList(ListNode head) {
		if(head == null || head.next == null)
			return;
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = slow;
		slow = slow.next;
		fast.next = null;
		
		//2 list, head & slow:
		ListNode l2 = reverseList(slow);
		ListNode l1 = head;
		//merge two list:
		while(l1.next != null){
			ListNode temp = l1.next;
			l1.next = l2;
			l2 = l2.next;
			l1.next.next = temp;
			l1 = temp;
		}
		l1.next = l2;
	}
	
	public ListNode reverseList(ListNode head) {
		if(head == null)
			return head;
		ListNode current = head.next;
		ListNode preCurrent = head;
		while(current != null){
			ListNode temp = current.next;
			current.next = preCurrent;
			preCurrent = current;
			//current = current.next;
			current = temp;
		}
		head.next = null;
		return preCurrent;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(7);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(6);
		head.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next = new ListNode(3);
		//head.next.next.next.next.next.next.next = new ListNode(4);
		
		ReorderList rl = new ReorderList();
		rl.reorderList(head);
		PublicMethods.printLinkedList(head);
	}
	
}
