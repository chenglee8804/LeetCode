
public class EditDistance {
	public int minDistance(String word1, String word2) {
		int l1 = word1.length() + 1;
		int l2 = word2.length() + 1;
		int[][] matrix = new int[l1][];
		for(int i = 0; i < l1; ++i){
			matrix[i] = new int[l2];
		}
		
		for(int i = 0; i < l1; ++i){
			matrix[i][0] = i;
		}
		
		for(int i = 0; i < l2; ++i){
			matrix[0][i] = i;
		}
		
		for(int i = 1; i < l1; ++i){
			for(int j = 1; j < l2; ++j){
				char c1 = word1.charAt(i - 1);
				char c2 = word2.charAt(j - 1);
				if(c1 == c2){
					matrix[i][j] = matrix[i-1][j-1];
				}else {
					int minVal = Math.min(matrix[i-1][j], matrix[i][j-1]);
					matrix[i][j] = 1 + Math.min(matrix[i-1][j-1], minVal); 
				}
			}
		}
		PublicMethods.print2DArray(matrix);
		return matrix[l1 - 1][l2 - 1];
	}
	
	public static void main(String[] args) {
		EditDistance ed = new EditDistance();
		System.out.println(ed.minDistance("distance", "brutal"));
	}
}
