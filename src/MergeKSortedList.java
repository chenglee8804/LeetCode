import java.util.ArrayList;


public class MergeKSortedList {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if(lists.size() == 0)
			return null;
		ListNode pListNode = null;
		for(int i = 0; i < lists.size(); ++i){
			pListNode = mergeTwoLists(pListNode, lists.get(i));
		}
		
		return pListNode;
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
		
	}
}
