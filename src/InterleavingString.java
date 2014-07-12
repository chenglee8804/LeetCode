
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3){
		int l1 = s1.length();
		int l2 = s2.length();
		if(s3.length() != l1 + l2) return false;
		boolean[][] matrix = new boolean[l1 + 1][];
		for(int i = 0; i <= l1; ++i){
			matrix[i] = new boolean[l2 + 1];
		}
		matrix[0][0] = true;
		for(int i = 1; i <= l1; ++i){
			matrix[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1))
					&& matrix[i - 1][0];
		}
		for(int i = 1; i <= l2; ++i){
			matrix[0][i] = s2.charAt(i - 1) == s3.charAt(i - 1)
					&& matrix[0][i - 1];
		}
		for(int i = 1; i<= l1; ++i){
			for(int j = 1; j <= l2; ++j){
				matrix[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1)) && matrix[i-1][j]
						|| (s2.charAt(j-1) == s3.charAt(i+j-1)) && matrix[i][j-1];
			}
		}
//		PublicMethods.printBoolMatrix(matrix);
		return matrix[l1][l2];
	}
	
	public static void main(String[] args) {
		InterleavingString iterSt = new InterleavingString();
		System.out.println(iterSt.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}
}
