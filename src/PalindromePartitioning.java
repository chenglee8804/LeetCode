
import java.util.ArrayList;
import java.util.Collections;



public class PalindromePartitioning {
	public ArrayList<ArrayList<String>> partition(String s) {
		int length = s.length();
		//initial a indicator:
		boolean[][] indicator = new boolean[length][];
		for(int i = 0; i < length; ++i){
			indicator[i] = new boolean[length];
			for(int j = 0; j < length; ++j){
				indicator[i][j] = false; 
			}
		}
		
		for(int i = length - 1; i >= 0; --i){
			for(int j = i; j < length; ++j){
				indicator[i][j] = (s.charAt(i) == s.charAt(j)) && ((j - i) < 2 || (indicator[i+1][j-1])); 
			}
		}
		
		ArrayList<ArrayList<String>> result = helper1(s, indicator, 0);
		for(int i = 0; i < result.size(); ++i){
			Collections.reverse(result.get(i));
		}
		
//		printMatrix(indicator);
		return result;
	}
	
	
	public ArrayList<ArrayList<String>> helper1(String inputString, boolean[][] indicator, int startPosition) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		if(startPosition > indicator.length - 1){
			ArrayList<String> ss = new ArrayList<>();
			result.add(ss);
			return result;
		}
		if(startPosition == indicator.length - 1){
			ArrayList<String> ss = new ArrayList<>();
			ss.add(inputString.substring(startPosition));
			result.add(ss);
			return result;
		}
		for(int i = startPosition; i < indicator.length; ++i){
			if(indicator[startPosition][i] == true){
				ArrayList<ArrayList<String>> tempResult = helper1(inputString, indicator, i + 1);
				for(int j = 0; j < tempResult.size(); ++j){
					tempResult.get(j).add(inputString.substring(startPosition, i+1));
				}
				result.addAll(tempResult);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
//		String s = new String("abc");
//		System.out.println(s.length());
		PalindromePartitioning pp = new PalindromePartitioning();
		System.out.println(pp.partition("aab"));
		
	}
}
