

public class NQueenII {
	private int[] columnState;
	private int[] leftDiag;
	private int counter;
	private int[] rightDiag;
	
	public int totalNQueens(int n) {
		columnState = new int[n];
		leftDiag = new int[2*n];
		rightDiag = new int[2*n];
		this.counter = 0;
		//initialize:
		for(int i = 0; i < n; ++i){
			columnState[i] = 0;
		}
		for(int i = 0; i < 2*n; ++i){
			leftDiag[i] = 0;
		}
		for(int i = 0; i < 2*n; ++i){
			rightDiag[i] = 0;
		}
		
		int[] map = new int[n];
		for(int i = 0; i < n; ++i){
			map[i] = -1;
		}
		helper(map, 0);
		return counter;
	}
	
	public void helper(int[] map, int nthQueen) {
		int N = map.length;
		if(nthQueen == N){
			counter++;
			return;
		}
		
		for(int i = 0; i < N; ++i){
			if(columnState[i] == 0 && rightDiag[nthQueen + i] == 0 && leftDiag[i - nthQueen + N] == 0){
				map[nthQueen] = i;
				columnState[i] = 1;
				rightDiag[nthQueen + i] = 1;
				leftDiag[i - nthQueen + N] = 1;
				helper(map, nthQueen + 1);
				map[nthQueen] = -1;
				columnState[i] = 0;
				rightDiag[nthQueen + i] = 0;
				leftDiag[i - nthQueen + N] = 0;
			}else {
				continue;
			}
		}
	}
	
	public static void main(String[] args) {
		NQueenII nq2 = new NQueenII();
		System.out.println(nq2.totalNQueens(4));
	}
}
