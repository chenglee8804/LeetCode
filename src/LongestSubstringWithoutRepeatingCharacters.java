import java.util.HashMap;
import java.util.Map;


public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int length = s.length();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0;
		int maxCount = 0;
		for(int i = 0; i < length; ++i){
			if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start){
				maxCount = Math.max(maxCount, i-start);
				start = map.get(s.charAt(i)) + 1;
			}
			map.put(s.charAt(i), i);
		}
		maxCount = Math.max(maxCount, s.length() - start);
		return maxCount;
	}
	
	public static void main(String[] args) {
		String s = new String("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco");
		LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(ls.lengthOfLongestSubstring(s));
	}
}
