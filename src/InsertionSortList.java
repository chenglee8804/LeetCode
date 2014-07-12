
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		//dummy.next = head;
		ListNode current = head;
		while(current != null){
			ListNode insertPos = findInsertPosition(dummy, current.val);
			ListNode temp = current.next;
			current.next = insertPos.next;
			insertPos.next = current;
			current = temp;
		}
		return dummy.next;
	}
	
	public ListNode findInsertPosition(ListNode dummy, int x) {
		ListNode insertPos = dummy.next;
		ListNode insertPosPre = dummy;
		while(insertPos != null){
			if(insertPos.val > x)
				break;
			insertPosPre = insertPos;
			insertPos = insertPos.next;
		}
		return insertPosPre;
	}
	
	public static void main(String[] args) {
//		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		ListNode head = new ListNode(9);
//		dummy.next = head;
		head.next = new ListNode(5);
		head.next.next = new ListNode(11);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(10);
		InsertionSortList isl = new InsertionSortList();
//		System.out.println(isl.findInsertPosition(dummy, 0).val);
		PublicMethods.printLinkedList(isl.insertionSortList(head));
	}
	
}
