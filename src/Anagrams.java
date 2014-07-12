import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Anagrams {
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();
		if(strs.length == 0)
			return result;
		Map<String, ArrayList<String>> group = new HashMap<String, ArrayList<String>>();
		int length = strs.length;
		for(int i = 0; i < length; ++i){
			String temp = strs[i];
			char[] t = temp.toCharArray();
			sortString(t, 0, t.length - 1);
			temp = new String(t);
			if(group.containsKey(temp))
				group.get(temp).add(strs[i]);
			else {
				ArrayList<String> r = new ArrayList<>();
				r.add(strs[i]);
				group.put(temp, r);
			}
		}
		
		for(String s: group.keySet()){
			if(group.get(s).size() > 1){
				result.addAll(group.get(s));
			}
		}
		return result;
	}
	
	public void sortString(char[] ss, int start, int end) {
		if(ss.length == 0)
			return;
//		char[] ss = s.toCharArray();
		int p = (start + end)/2;
		char pivot = ss[p];
		int i = start;
		int j = end;
		while(i < j){
			while(i < p && pivot >= ss[i]){
				++i;
			}
			if(i < p){
				ss[p] = ss[i];
				p = i;
			}
			while(j > p && pivot <= ss[j]){
				--j;
			}
			if(j > p){
				ss[p] = ss[j];
				p = j;
			}
		}
		ss[p] = pivot;
		if(p - start > 1){
			sortString(ss, start, p - 1);
		}
		if(end - p > 1){
			sortString(ss, p + 1, end);
		}
	}
	
	public static void main(String[] args) {
//		String test = "dirtyroom";
//		String[] s = new String[]{"dirtyroom", "dormitory", "eat", "tea"};
		String[] ss = new String[]{""};
		Anagrams ana = new Anagrams();
//		ana.sortString(test, 0, test.length() - 1);
//		System.out.println(test);
		System.out.println(ana.anagrams(ss));
	}
}
