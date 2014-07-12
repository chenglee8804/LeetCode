
public class PalindromePartitioningII {
	
	public int minCut(String s) {
		int length = s.length();
		boolean[][] matrix  = new boolean[length][];
		int[] f = new int[length + 1];
		for(int i = 0; i < length; ++i){
			matrix[i] = new boolean[length];
//			matrix[i][i] = true;
		}
		
		for(int i = 0; i <= length; ++i){
			f[i] = length - i - 1;
		}
		
		for(int i = length - 1; i >= 0; --i){
			for(int j = i; j < length; ++j){
				char si = s.charAt(i);
				char sj = s.charAt(j);
				if((si == sj) && ((j - i) < 2 || matrix[i + 1][j - 1])){
					matrix[i][j] = true;
					f[i] = Math.min(f[j + 1] + 1, f[i]);
				}
			}
		}
		
//		PublicMethods.printBoolMatrix(matrix);
		return f[0];
	}
	
	public static void main(String[] args) {
		PalindromePartitioningII p2 = new PalindromePartitioningII();
		System.out.println(p2.minCut("aabaaa"));
	}
	
}
