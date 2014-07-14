

public class SortColors {

	/**
	 * @param args
	 */
	public void sortColors(int[] A){
		int i = -1;
		int j = -1;
		int k = -1;
		for(int n = 0; n < A.length; n++){
			if(A[n] == 0 ){
				A[++i] = 2;
				A[++j] = 1;
				A[++k] = 0;
				continue;
			}
			if(A[n] == 1 ){
				A[++i] = 2;
				A[++j] = 1;
				continue;
			}
			if(A[n] == 2 ){
				A[++i] = 2;
				continue;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[]{1,0,2,2,0,0,1,1,1,2,0,2,2,0,0,1,1,0};
		SortColors sc = new SortColors();
		sc.sortColors(A);
		for(int i = 0; i < A.length; i++){
			System.out.print(A[i]+ " ");
		}
	}

}
