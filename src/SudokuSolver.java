
public class SudokuSolver {
	public char[][] boardData;
	
	public void solveSudoku(char[][] board) {
		boardData = board;
		solveSu(boardData);
		board = boardData;
	}
	
	public boolean solveSu(char[][] boardData) {
		for(int i = 0; i < 9; ++i){
			for(int j = 0; j < 9; ++j){
				if(boardData[i][j] == '.'){
					for(int k = 1; k <= 9; k++){
						boardData[i][j] = (char)(k + '0');
						if(isValid(boardData, i, j) && solveSu(boardData))
							return true;
						boardData[i][j] = '.'; 
					}
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean isValid(char[][] boardData, int x, int y) {
		for(int i = 0; i < 9; i++){
			if(i != x && boardData[i][y] == boardData[x][y])
				return false;
		}
		for(int i = 0; i < 9; i++){
			if(i != y && boardData[x][i] == boardData[x][y])
				return false;
		}
		for(int i = 3*(x/3); i < 3*(x/3 + 1); ++i){
			for(int j = 3*(y/3); j < 3*(y/3 + 1); ++j){
				if((i != x || j != y) && boardData[i][j] == boardData[x][y])
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		char[][] board = new char[9][9];
		board[0] = new String("..9748...").toCharArray();
		board[1] = new String("7........").toCharArray();
		board[2] = new String(".2.1.9...").toCharArray();
		board[3] = new String("..7...24.").toCharArray();
		board[4] = new String(".64.1.59.").toCharArray();
		board[5] = new String(".98...3..").toCharArray();
		board[6] = new String("...8.3.2.").toCharArray();
		board[7] = new String("........6").toCharArray();
		board[8] = new String("...2759..").toCharArray();
		
		SudokuSolver sv = new SudokuSolver();
		sv.solveSudoku(board);
	}
}
