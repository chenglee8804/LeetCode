
public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		if(s1.equals(s2)) return true;
		int val1 = 0, val2 = 0;
		int size = s1.length();
		for(int i = 0; i < s1.length(); ++i){
			val1 += s1.charAt(i) - 'a';
			val2 += s2.charAt(i) - 'a';
		}
		if(val1 != val2) return false;
		for(int i = 1; i < s1.length(); ++i){
			if(isScramble(s1.substring(0,i), s2.substring(0,i)) && 
					isScramble(s1.substring(i), s2.substring(i)))
				return true;
			if(isScramble(s1.substring(0,i), s2.substring(size - i)) &&
					isScramble(s1.substring(i), s2.substring(0,size - i)))
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		ScrambleString ss = new ScrambleString();
		System.out.println(ss.isScramble("rgtae", "great"));
	}
}
