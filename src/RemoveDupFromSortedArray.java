
public class RemoveDupFromSortedArray {

	/**
	 * @param args
	 */
	
	public int removeDupFast(int[] A){
		if(A.length == 0)
			return 0;
		int currentIndex = 0;
		for(int i = 1; i < A.length; i++){
			if(A[i] != A[currentIndex]){
				A[currentIndex + 1] = A[i];
				currentIndex++;
			}
		}
		return currentIndex+1;
	}
	/*public int removeDup(int[] A){
		int len = A.length;
		if(len == 0)
			return 0;
		int currentIndex = 0;
		for(int i = 1; i < len; i++){
			if(A[currentIndex] != A[i]){
				int counter = 0;
				for(int j = i; j < len; j++){
					A[currentIndex + 1 + counter] = A[j];
					counter++;
				}
				len = len - (i - currentIndex - 1);
				currentIndex = currentIndex + 1;
			}
		}
		if(currentIndex != len -1){
			//remove the tail;
			len = currentIndex + 1;
		}
		return len;
	}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[]{1,2,2};
		RemoveDupFromSortedArray rnfeol = new RemoveDupFromSortedArray();
		System.out.println(rnfeol.removeDupFast(A));
	}

}
