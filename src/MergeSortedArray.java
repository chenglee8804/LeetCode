
public class MergeSortedArray {
	public void merge(int[] A, int m, int[] B, int n) {
		int countA = m - 1;
		int countB = n - 1;
		for(int i = n + m - 1; i >= 0; --i){
			if(countA >= 0 && countB >= 0 && A[countA] > B[countB]){
				A[i] = A[countA];
				countA--;
				continue;
			}
			if(countA >= 0 && countB >= 0 && A[countA] <= B[countB]){
				A[i] = B[countB];
				countB--;
				continue;
			}
		}
		//still have B
		while(countB >= 0){
			A[countB] = B[countB];
			countB--;
		}
	}
	
	public static void main(String[] args) {
		int[] A = new int[]{2,4,7,9,11,11,13,0,0,0,0,0,0};
		int[] B = new int[]{3,3,6,8,12,17};
		MergeSortedArray msa = new MergeSortedArray();
		msa.merge(A, 7, B, 6);
		PublicMethods.printArray(A);
	}
}
