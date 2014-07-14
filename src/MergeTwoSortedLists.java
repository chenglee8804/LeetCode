
public class MergeTwoSortedLists {

	/**
	 * @param args
	 */
	
	public ListNode mergeTowLists(ListNode l1, ListNode l2){
//		ListNode resultHead = null;
		ListNode l1Pointer = l1;
		ListNode l2Pointer = l2;
	
		ListNode pretail = null;
		
		if(l1 == null && l2 == null)
			return null;
		if(l1 == null && l2!=null)
			return l2;
		if(l1!=null && l2 == null)
			return l1;
		
		if(l1Pointer.val < l2Pointer.val)
			pretail = l1Pointer;
		else {
			pretail = l2Pointer;
		}
		
		int counter = 0;
		
		while(l1Pointer != null && l2Pointer != null){
			
			if(l1Pointer.val < l2Pointer.val){
				ListNode temp = l1Pointer;
				l1Pointer = l1Pointer.next;
				temp.next = l2Pointer;
				if(counter != 0)
					pretail.next = temp;
				pretail = temp;
				
			}else {
				ListNode temp = l2Pointer;
				l2Pointer = l2Pointer.next;
				temp.next = l1Pointer;
				if(counter != 0)
					pretail.next = temp;
				pretail = temp;
			}
			
			counter++;
				
		}
		
		if(l1Pointer == null && l2Pointer != null){
			pretail.next.next = l2Pointer.next;
		}
		if(l1Pointer != null && l2Pointer == null){
			pretail.next.next = l1Pointer.next;
		}
		
		if(l1.val < l2.val)
			return l1;
		else
			return l2;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ListNode headListNode = new ListNode(0);
//		 headListNode.next = new ListNode(1);
//		 headListNode.next.next = new ListNode(3);
//		 headListNode.next.next.next = new ListNode(8);
		 
		 ListNode headListNode2 = new ListNode(0);
//		 headListNode2.next = new ListNode(4);
//		 headListNode2.next.next = new ListNode(5);
//		 headListNode2.next.next.next = new ListNode(4);
		 
		 MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
		 ListNode result = mtsl.mergeTowLists(headListNode, headListNode2);
		 ListNode r = result;
		 while(r!=null){
			 System.out.print(r.val);
			 System.out.print(' ');
			 r = r.next;
		 }
	}

}
