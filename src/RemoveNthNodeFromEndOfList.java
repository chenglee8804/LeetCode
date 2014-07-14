
public class RemoveNthNodeFromEndOfList {

	/**
	 * @param args
	 */
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode first = head;
		ListNode second = head;
		ListNode secondPre = head;
		while(first != null){
			first = first.next;
			n--;
			if(n < 0){
				second = second.next;
			}
			if(n < -1){
				secondPre = secondPre.next;
			}
		}
		//return second;
		if(second == secondPre){
			return head.next;
		}
		secondPre.next= secondPre.next.next;
		return head;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ListNode headListNode = null;
		ListNode headListNode = new ListNode(1);
		headListNode.next = new ListNode(2);
		headListNode.next.next = null;
		//headListNode.next.next.next = null;
//		headListNode.next.next.next.next = new ListNode(5);
//		headListNode.next.next.next.next.next = null;
		
		RemoveNthNodeFromEndOfList rmEndOfList = new RemoveNthNodeFromEndOfList();
		ListNode head = rmEndOfList.removeNthFromEnd(headListNode, 1);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}

}
