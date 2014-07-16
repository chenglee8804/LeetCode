import java.util.Hashtable;


class MinimumWindowSubstring {

	/**
	 * @param args
	 */
	
	public String minWindow(String S, String T) {
		Hashtable<Character, Integer> ht = new Hashtable<>();
		for(int i = 0; i < T.length(); i++){
			char ch = T.charAt(i);
			if(ht.containsKey(ch)){
				ht.put(ch, ht.get(ch) + 1);
			}else{
				ht.put(ch, 1);
			}
		}
		
		int first = 0;
		int second = 0;
		
		
		for(int i = 0; i < S.length(); ++i){
			char temp = S.charAt(i);
			//if()
		}
		
		return "";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = new String("ADOBECODEBANC");
		String T = new String("ABCC");
		
		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		System.out.println(mws.minWindow(S, T));
	}

}
