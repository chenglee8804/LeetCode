
class RandomListNode{
	int label;
	RandomListNode next, random;
	RandomListNode(int x){
		this.label = x;
	}
}

public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode ptr = head;
		while(ptr != null){
			RandomListNode temp = new RandomListNode(ptr.label);
			temp.next = ptr.next;
			ptr.next = temp;
			ptr = temp.next;
		}
		
		ptr = head;
		while(ptr != null){
			if(ptr.random != null){
				ptr.next.random = ptr.random.next;
			}
			ptr = ptr.next.next;
		}
		
		//Seperate:
		RandomListNode dummy = new RandomListNode(0);
		for(RandomListNode current = head, newPtr = dummy; current != null;){
//			RandomListNode node = current.next.next;
			newPtr.next = current.next;
			newPtr = newPtr.next;
			current.next = current.next.next;
			current = current.next;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		RandomListNode head = new RandomListNode(1);
		CopyListWithRandomPointer cprp = new CopyListWithRandomPointer();
		cprp.copyRandomList(head);
	}
}
