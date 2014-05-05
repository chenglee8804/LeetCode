import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class WordBreakII {
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> result = new ArrayList<>();
		if(s.length() == 0)
			return result;
		int length = s.length();
		boolean[] f = new boolean[length + 1];
		boolean[][] matrix = new boolean[length][];
		f[0] = true;
		
		for(int i = 0; i < length; i++){
			matrix[i] = new boolean[length];
		}
		
		for(int i = 1; i <= length; ++i){
			for(int j = i - 1; j >= 0; --j){
				if(f[j] && dict.contains(s.subSequence(j, i))){
					f[i] = true;
					matrix[i-1][j] = true;
				}
			}
		}
		
//		PublicMethods.printBoolMatrix(matrix);
		String temp = "";
		genResultFromMatrix(s, temp, matrix, 0, result);
		return result;
	}
	
	public void genResultFromMatrix(String s, String temp, boolean[][] matrix, int start, ArrayList<String> result) {
		if(start == s.length()){
			result.add(temp.substring(0, temp.length()-1));
//			temp = "";
			return;
		}
		
		for(int i = start; i < matrix.length; ++i){
			if(matrix[i][start] == true){
				int l = s.subSequence(start, i+1).length();
				temp += s.subSequence(start, i+1) + " ";
				genResultFromMatrix(s, temp, matrix, i+1, result);
				temp = temp.substring(0, temp.length() - l - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		WordBreakII wb2 = new WordBreakII();
		Set<String> dict = new HashSet<>();
		dict.add("cat");dict.add("cats");dict.add("and");
		dict.add("sand");dict.add("dog");
		System.out.println(wb2.wordBreak("catsanddog", dict));
	}
}
