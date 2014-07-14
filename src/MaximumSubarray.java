
public class MaximumSubarray {

	/**
	 * @param args
	 */

	
	
	/*public int maxSubArrayDviConq(int[] A, int left, int right){
		if(left == right)
			return A[left];
		
		int mid = left+right/2;
		
	}*/
	
	
	
	public int maxSubArray(int[] A){
		if(A.length == 0)
			return 0;
		if(A.length == 1)
			return A[0];
		int[] bestResultIfContain = new int[A.length];
		bestResultIfContain[0] = A[0];
		int maxResult = A[0];
		for(int i = 1; i < A.length; i++){
			if(bestResultIfContain[i - 1] <= 0)
				bestResultIfContain[i] = A[i];
			else {
				bestResultIfContain[i] = A[i] + bestResultIfContain[i -1];
			}
			maxResult = Math.max(maxResult, bestResultIfContain[i]);
		}
		
		return maxResult;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
