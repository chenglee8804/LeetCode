
public class RemoveDupFromSortedList {

	/**
	 * @param args
	 */
	
	public ListNode deleteDup(ListNode head){
		ListNode pointer = head;
		if(pointer == null)
			return null;
		if(pointer.next == null)
			return pointer;
		while(pointer.next != null){
			if(pointer.val == pointer.next.val)
				pointer.next = pointer.next.next;
			else{
				pointer = pointer.next;
			}
		}
		return head;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
