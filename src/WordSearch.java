
public class WordSearch {
	private int row;
	private int col;
	private boolean[][] visited;
	//private boolean result = false;
	
	public boolean exist(char[][] board, String word) {
		this.row = board.length;
		this.col = board[0].length;
		for(int i = 0; i < row; ++i){
			for(int j = 0; j < col; ++j){
				if(dfs(board, word, i, j))
					return true;
			}
		}
		return false;
	}
	
	public boolean dfs(char[][] board, String word, int x, int y) {
		if(word.length() == 0){
			return true;
		}
		
		if(word.charAt(0) == board[x][y]){
			visited[x][y] = true;
			if(y - 1 >= 0 && visited[x][y - 1] == false){
				if(dfs(board, word.substring(1), x, y - 1))
					return true;
			}
			if(y + 1 < this.col && visited[x][y + 1] == false){
				if(dfs(board, word.substring(1), x, y + 1))
					return true;
			}
			if(x + 1 < this.row && visited[x + 1][y] == false){
				if(dfs(board, word.substring(1), x + 1, y))
					return true;
			}
			if(x - 1 >= 0 && visited[x - 1][y] == false){
				if(dfs(board, word.substring(1), x - 1, y))
					return true;
			}
			visited[x][y] = false; 
		}
		return false;
	}
	
	public static void main(String[] args) {
		char[][] board = new char[3][4];
		board[0] = new char[]{'A','B','C','E'};
		board[1] = new char[]{'S','F','C','S'};
		board[2] = new char[]{'A','D','E','E'};
		WordSearch ws = new WordSearch();
		System.out.println(ws.exist(board, "BCCE"));
	}
}
