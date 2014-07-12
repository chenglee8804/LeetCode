
public class SurroundedRegions {
	public void solve(char[][] board) {
		if(board.length <= 1)
			return;
		
		int down = board.length - 1;
		int right = board[0].length - 1;
		int up = 0;
		int left = 0;
		helper(board, left+1, right-1, up+1, down-1);
	}
	
	public void helper(char[][] board, int left, int right, int up, int down) {
		if(left > right || up > down){
			return;
		}
		if(isClosed(board, left, right, up, down)){
			//fill and return
			fillBoard(board, left, right, up, down);
			return;
		}else{
			helper(board, left+1, right-1, up+1, down-1);
		}
	}
	
	private void fillBoard(char[][] board, int left, int right, int up, int down) {
		for(int i = left; i <= right; i++){
			for(int j = up; j <= down; j++){
				board[j][i] = 'X';
			}
		}
	}
	
	private boolean isClosed(char[][] B, int l, int r, int u, int d){
		for(int i = u; i <= d; ++i){
			if(B[i][l] == 'O' && B[i][l - 1] == 'O')
				return false;
			if (B[i][r] == 'O' && B[i][r + 1] == 'O')
				return false;
		}
		for(int i = l; i <= r; ++i){
			if(B[u][i] == 'O' && B[u - 1][i] == 'O')
				return false;
			if(B[d][i] == 'O' && B[d + 1][i] == 'O')
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		char[][] board = new char[5][5];
		board[0] = new String("OXXOX").toCharArray();
		board[1] = new String("XOOXO").toCharArray();
		board[2] = new String("XOXOX").toCharArray();
		board[3] = new String("OXOOO").toCharArray();
		board[4] = new String("XXOXO").toCharArray();
		SurroundedRegions sr = new SurroundedRegions();
		sr.solve(board);
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
