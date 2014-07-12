
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		boolean carray = false;
		ListNode ptr1 = l1;
		ListNode ptr2 = l2;
		ListNode ptr = dummy;
		while(ptr1 != null && ptr2 != null){
			int val = carray ? (val = ptr1.val + ptr2.val + 1) : (val = ptr1.val + ptr2.val);
			ptr.next = new ListNode(val%10);
			carray = val/10 == 0 ? false:true;
			ptr = ptr.next;
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		
		if(ptr1 == null){
			while(ptr2 != null){
				int val = carray ? (ptr2.val + 1) : ptr2.val;
				ptr.next = new ListNode(val%10);
				carray = val/10 == 0 ? false:true;
				ptr = ptr.next;
				ptr2 = ptr2.next;
			}
		}
		
		if(ptr2 == null){
			while(ptr1 != null){
				int val = carray ? (ptr1.val + 1) : ptr1.val;
				ptr.next = new ListNode(val%10);
				carray = val/10 == 0 ? false:true;
				ptr = ptr.next;
				ptr1 = ptr1.next;
			}
		}
		if(carray){
			ptr.next = new ListNode(1);
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);l1.next = new ListNode(4);l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);l2.next = new ListNode(6);l2.next.next = new ListNode(7);
		l2.next.next.next = new ListNode(9);
		AddTwoNumbers add2num = new AddTwoNumbers();
		PublicMethods.printLinkedList(add2num.addTwoNumbers(null, null));
//		System.out.println(add2num.addTwoNumbers(l1, l2));
	}
}
