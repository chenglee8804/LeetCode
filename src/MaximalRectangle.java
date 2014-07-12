
public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		int row = matrix.length;
		if(row == 0)
			return 0;
		int col = matrix[0].length;
		
		int[][] m = new int[row][col];
		
		for(int i = 0; i < row; ++i){
			for(int j = 0; j < col; ++j){
				if(matrix[i][j] == '1'){
					if(j == 0)
						m[i][j] = 1;
					else
						m[i][j] = m[i][j-1] + 1;
				}
			}
		}
		
		int maxArea = 0;
		for(int i = 0; i < row; ++i){
			for(int j = 0; j < col; ++j){
				if(m[i][j] != 0){
					int height = i;
					int width = m[i][j];
					for(; height >= 0; height--){
						width = Math.min(m[height][j], width);
						int area = width * (i - height + 1);
						maxArea = Math.max(maxArea, area);
					}
				}
			}
		}
		//PublicMethods.print2DArray(m);
		return maxArea;
	}
	
	public static void main(String[] args) {
		MaximalRectangle maxR = new MaximalRectangle();
		char[][] matrix  = new char[6][5];
		matrix[0] = new char[]{'1','1','1','1','1'};
		matrix[1] = new char[]{'1','0','1','1','1'};
		matrix[2] = new char[]{'1','1','1','1','1'};
		matrix[3] = new char[]{'1','1','1','1','1'};
		matrix[4] = new char[]{'1','1','1','0','1'};
		matrix[5] = new char[]{'1','1','0','1','1'};
		System.out.println(maxR.maximalRectangle(matrix));
	}
}
