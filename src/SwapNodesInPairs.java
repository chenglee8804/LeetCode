
public class SwapNodesInPairs {

	/**
	 * @param args
	 */
	
	public ListNode swapPairs(ListNode head){
		if(head == null)
			return null;
		if(head.next == null)
			return head;
		ListNode pointer = head;
		ListNode newHead = head.next;
		int counter = 1;
		ListNode lastNode = head;
		while(pointer.next != null){
			ListNode temp = pointer.next;
			if(counter%2 == 1){
				lastNode = pointer;
				if(pointer.next.next == null)
					pointer.next = null;
				else if(pointer.next.next.next == null)
					pointer.next = pointer.next.next;
				else
					pointer.next = pointer.next.next.next;
			}else{
				pointer.next = lastNode;
			}
			pointer = temp;
			counter++;
		}
		
		if(counter %2 == 0)
			pointer.next = lastNode;
		
		return newHead;
	}
	
	public void printList (ListNode head){
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ListNode headListNode = new ListNode(1);
		 headListNode.next = new ListNode(2);
		 headListNode.next.next = new ListNode(3);
		 headListNode.next.next.next = new ListNode(4);
//		 headListNode.next.next.next.next = new ListNode(5);
//		 headListNode.next.next.next.next.next = new ListNode(6);
//		 headListNode.next.next.next.next.next.next = new ListNode(7);
		 
		 SwapNodesInPairs sw = new SwapNodesInPairs();
		 sw.printList(sw.swapPairs(headListNode));
	}

}
