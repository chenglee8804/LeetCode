
public class DistinctSubsequences {
	public int numDistinct(String s, String t) {
		int tLength = t.length();
		int[] f = new int[tLength + 1];
		f[0] = 1;
		for(int i = 0; i < s.length(); ++i){
			for(int j = t.length() - 1; j >= 0; --j){
				char cs = s.charAt(i);
				char ct = t.charAt(j);
				if(cs == ct)
					f[j + 1] += f[j];
			}
		}
		return f[tLength];
	}
	
	public static void main(String[] args) {
		DistinctSubsequences ds = new DistinctSubsequences();
		System.out.println(ds.numDistinct("rabbabit", "rabbit"));
	}
}
