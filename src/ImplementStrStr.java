
public class ImplementStrStr {
	public String strStr(String hayStack, String needle) {
		int hayStackLength = hayStack.length();
		int needleLength = needle.length();
		
		if(hayStackLength == 0 && needleLength == 0)
			return "";
		if(needleLength == 0)
			return hayStack;
		
		for(int i = 0; i < hayStackLength; ++i){
			if(hayStackLength - i + 1 < needleLength)
				return null;
			int j = i;
			int k = 0;
			while(k < needleLength && j < hayStackLength && hayStack.charAt(j) == needle.charAt(k)){
				j++;
				k++;
				if(k == needleLength){
					return hayStack.substring(i);
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		ImplementStrStr imss = new ImplementStrStr();
		System.out.println(imss.strStr("This is a simple string", "simple"));
	}
}
