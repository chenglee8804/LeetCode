
class ListNode{
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class ReverseLinklistII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode ptrM = getPointer(m, dummy);
		ListNode ptrN = getPointer(n, dummy);
		
		ListNode ptrPrev = ptrN.next;
		ListNode ptrCurrent = ptrM;
		ListNode ptrTemp = null;
		for(int i = m; i <= n; ++i){
			ptrTemp = ptrCurrent.next;
			ptrCurrent.next = ptrPrev;
			ptrPrev = ptrCurrent;
			ptrCurrent = ptrTemp;
		}
		
		ListNode ptrMPrev = getPointer(m-1, dummy);
		ptrMPrev.next = ptrPrev;
		return dummy.next;
	}
	
	public ListNode getPointer(int n, ListNode head) {
		ListNode pointer = head;
		for(int i = 0; i < n; ++i){
			pointer = pointer.next;
		}
		return pointer;
	}
		
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ReverseLinklistII rlII = new ReverseLinklistII();
		ListNode newHead = rlII.reverseBetween(head, 1, 4);
		PublicMethods.printLinkedList(newHead);
	}
}
