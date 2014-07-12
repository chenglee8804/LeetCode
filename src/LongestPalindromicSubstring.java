
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		boolean[][] matrix = new boolean[s.length()][];
		for(int i = 0; i < s.length(); ++i){
			matrix[i] = new boolean[s.length()];
			matrix[i][i] = true;
		}
		int start = 0, end = 0;
		int longest = 1;
		for(int i = s.length() - 1; i >= 0; --i){
			for(int j = i; j < s.length(); ++j){
				matrix[i][j] = (s.charAt(i) == s.charAt(j)) && ((j - i <2) || matrix[i + 1][j - 1]);
				if(j - i + 1 > longest && matrix[i][j] == true){
					start = i;
					end = j;
					longest = j - i + 1;
				}
			}
		}
//		PublicMethods.printBoolMatrix(matrix);
		return s.substring(start,end+1);
	}
	
	public static void main(String[] args) {
		String s = "abbacssca";
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindrome(s));
	}
}
