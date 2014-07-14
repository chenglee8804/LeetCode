
public class SearchInsertPosition {

	/**
	 * @param args
	 */
	
	public int searchInsert(int[] A, int target){
		if(target < A[0])
			return 0;
		for(int i = 1; i < A.length; i++){
			if(A[i - 1] < target && target < A[i])
				return i;
			if(A[i - 1] == target)
				return i-1;
		}
		if(A[A.length - 1] == target)
			return A.length - 1;
		else
			return A.length;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInsertPosition sip = new SearchInsertPosition();
		int[] A = new int[]{1,3,5,6,7};
		System.out.println(sip.searchInsert(A, 6));
	}

}
