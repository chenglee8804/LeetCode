
public class MedianOfTwoSortedArrays {
	
	public double findMedianSortedArrays(int[] A, int[] B) {
		int total = A.length + B.length;
		if(total%2 == 1)
			return 1.0*findKth(A, 0, A.length, B, 0, B.length, total/2 + 1);
		return (findKth(A, 0, A.length, B, 0, B.length, total/2) + 
				findKth(A, 0, A.length, B, 0, B.length, total/2 + 1))/2.0;
	}
	
	public int findKth(int[] A, int aStart, int aSize,
			int[] B,int bStart, int bSize, int k) {
		if(aSize == 0) return B[bStart + k - 1];
		if(bSize == 0) return A[aStart + k - 1];
		if(k == 1)
			return Math.min(A[aStart], B[bStart]);
		
		if(aSize >= bSize){
			int ib = Math.min(bSize, k/2);
			int ia = k - ib;
			if(A[aStart + ia - 1] < B[bStart + ib - 1]){
				return findKth(A, aStart + ia, aSize - ia, B, bStart, bSize, k - ia);
			}else if(A[aStart + ia - 1] > B[bStart + ib - 1]){
				return findKth(A, aStart, aSize, B, bStart + ib, bSize - ib, k - ib);
			}else{
				return A[aStart + ia - 1];
			}
		}else{
			int ia = Math.min(aSize, k/2);
			int ib = k - ia;
			if(A[aStart + ia - 1] < B[bStart + ib - 1]){
				return findKth(A, aStart + ia, aSize - ia, B, bStart, bSize, k - ia);
			}else if(A[aStart + ia - 1] > B[bStart + ib - 1]){
				return findKth(A, aStart, aSize, B, bStart + ib, bSize - ib, k - ib);
			}else{
				return A[aStart + ia - 1];
			}
		}
	}
	
	public static void main(String[] args) {
		int[] A = new int[]{2,3};
		int[] B = new int[]{1,5,8,9,9,12,15};
		MedianOfTwoSortedArrays mtsa = new MedianOfTwoSortedArrays();
		System.out.println(mtsa.findMedianSortedArrays(A, B));
	}
}
