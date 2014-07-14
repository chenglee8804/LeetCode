
public class LinkedListCycleII {

	/**
	 * @param args
	 */
    public ListNode detectCycle(ListNode head){
	ListNode fast = head;
	ListNode slow = head;
	if(head == null || (head != null &&  head.next == null)){
	    return null;
	}
	while(fast != null && fast.next != null){
	    fast = fast.next.next;
	    slow = slow.next;
	    if(fast == slow){
		break;
	    }
	    
	}
	
	if(fast == null || fast.next == null){
	    return null;
	    
	}
	fast = head;
	while(fast != slow){
	    fast = fast.next;
	    slow = slow.next;
	}
	return slow;
	/*
	  test color
	 */
	
    }
	public static void main(String[] args) {
	    // TODO Auto-generated method stub
	    ListNode headListNode = new ListNode(1);
	    headListNode.next = new ListNode(2);
	    headListNode.next.next = new ListNode(3);
	    headListNode.next.next.next = new ListNode(4);
	    headListNode.next.next.next.next = new ListNode(5);
	    headListNode.next.next.next.next.next = new ListNode(6);
	    headListNode.next.next.next.next.next.next = new ListNode(7);
	    headListNode.next.next.next.next.next.next.next = new ListNode(8);
	    headListNode.next.next.next.next.next.next.next.next = headListNode.next.next.next;
	    LinkedListCycleII lscII = new LinkedListCycleII();
	    System.out.println(lscII.detectCycle(headListNode).val);

	    ListNode headListNode2 = new ListNode(1);
	    headListNode2.next = headListNode2;
	    System.out.println(lscII.detectCycle(headListNode2).val);

	    ListNode headListNode3 = new ListNode(1);
	    headListNode3.next = new ListNode(2);	    
	    headListNode3.next.next = headListNode3.next;
	    System.out.println(lscII.detectCycle(headListNode3).val);

	    ListNode headListNode4 = new ListNode(1);
	    headListNode4.next = new ListNode(2);
	    headListNode4.next.next = new ListNode(3);
	    System.out.println(lscII.detectCycle(headListNode4));
	    
	}

}
