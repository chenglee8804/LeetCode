
import java.util.ArrayList;

public class NQueen {
	private int[] columnState;
	private int[] leftDiag;
	private int[] rightDiag;
		
	public ArrayList<String[]> solveNQueens(int n) {
		columnState = new int[n];
		leftDiag = new int[2*n];
		rightDiag = new int[2*n];
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
		
		ArrayList<String[]> result = new ArrayList<String[]>();
		int[] map = new int[n];
		for(int i = 0; i < n; ++i){
			map[i] = -1;
		}
		helper(map, 0, result);
		return result;
	}
	
	public void helper(int[] map, int nthQueen, ArrayList<String[]> result) {
		int N = map.length;
		if(nthQueen == N){
			String[] temp = new String[N];
			for(int k = 0; k < N; ++k){
				temp[k] = ""; 
				for(int m = 0; m < N; ++m){
					if(m == map[k])
						temp[k] += "Q";
					else {
						temp[k] += "."; 
					}
				}
			}
			result.add(temp);
			return;
		}
		
		for(int i = 0; i < N; ++i){
			if(columnState[i] == 0 && rightDiag[nthQueen + i] == 0 && leftDiag[i - nthQueen + N] == 0){
				map[nthQueen] = i;
				columnState[i] = 1;
				rightDiag[nthQueen + i] = 1;
				leftDiag[i - nthQueen + N] = 1;
				helper(map, nthQueen + 1, result);
				map[nthQueen] = -1;
				columnState[i] = 0;
				rightDiag[nthQueen + i] = 0;
				leftDiag[i - nthQueen + N] = 0;
			}else {
				continue;
			}
		}
	}
	
	public void mark(int[][] matrix, int x, int y) {
		int n = matrix.length - 1;
		int row = x; int col = y;	
		for(int i = 0; i <= n; ++i){
			matrix[x][i] = 2;
			matrix[i][y] = 2;
		}
		while(row <= n && col <= n){
			matrix[row++][col++] = 2;
		} 
		row = x; col = y;
		while(row >= 0 && col >= 0){
			matrix[row--][col--] = 2;
		}
		row = x; col = y;
		while(row >= 0 && col <= n){
			matrix[row--][col++] = 2;
		}
		row = x; col = y;
		while(row <= n && col >= 0){
			matrix[row++][col--] = 2;
		}
		matrix[x][y] = 1;
	}
	
	public boolean isAllNotZero(int[][] matrix) {
		int n = matrix.length;
		for(int i = 0; i < n; ++i){
			for(int j = 0; j < n; ++j){
				if(matrix[i][j] == 0)
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		NQueen nq = new NQueen();
		ArrayList<String[]> result = nq.solveNQueens(4);
		for(int i = 0; i < result.size(); ++i){
			int length = result.get(0).length;
			for(int j = 0; j < length; ++j){
				System.out.println(result.get(i)[j]);
			}
			System.out.println();
		}
	}
}
