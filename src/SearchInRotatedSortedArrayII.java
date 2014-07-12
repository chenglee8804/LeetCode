
public class SearchInRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
		if(A.length == 1 && A[0] == target)
			return true;
		int start = 0;
		int end = A.length - 1;
		
		while(start < end){
			int mid = (start + end)/2;
			if(A[mid] == target){
				return true;
			}
			if(A[start] < A[mid]){
				if(A[start] <= target && target < A[mid]){
					end = mid;
				}else {
					start = mid + 1;
				}
			}else if(A[start] > A[mid]){
				if(A[mid] < target && target <= A[end]){
					start = mid + 1;
				}else{
					end = mid;
				}
			}else{
				++start;
			}
		}
		
		if(start == end && A[start] == target)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		SearchInRotatedSortedArrayII s2 = new SearchInRotatedSortedArrayII();
		int[] A = new int[]{5,1,3};
		System.out.println(s2.search(A, 3));
	}
}
