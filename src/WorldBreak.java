import java.util.HashSet;
import java.util.Set;


public class WorldBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		int length = s.length();
		boolean[] f = new boolean[length+1];
		f[0] = true;
		for(int i = 1; i <= length; ++i){
			for(int j = i - 1; j >= 0; --j){
				if(dict.contains(s.subSequence(j, i)) && f[j]){
					f[i] = true;
					break;
				}
			}
		}
		return f[length];
	}
	
	public static void main(String[] args) {
		WorldBreak wb = new WorldBreak();
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		System.out.println(wb.wordBreak("leetcode", dict));
	}
}