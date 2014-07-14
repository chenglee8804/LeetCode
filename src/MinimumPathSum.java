
public class MinimumPathSum {

	/**
	 * @param args
	 */
	public int minPathSum(int[][] grid){
		int numRow = grid.length;
		int numCol = grid[0].length;
		int[][] temp = grid;
		//add the first row:
		for(int i = 1; i < numRow; i++){
			temp[0][i] = temp[0][i-1] + temp[0][i]; 
		}
		for(int j = 1; j < numCol; j++){
			temp[j][0] = temp[j-1][0] + temp[j][0];
		}
		
		for(int i = 1; i < numRow; i++){
			for(int j = 1; j < numCol; j++){
				
			}
		}
		return temp[numRow-1][numCol-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
