
public class ReverseWordInString {
	public String reverseWords(String s) {
		if(s.length() == 0)
			return s;
		String result = "";
		int subStart = 0;
		int subEnd = 0;
		for(int i = s.length() - 1; i >= 0; --i){
			if(s.charAt(i) != ' '){
				subEnd = i;
				while(i >= 0 && s.charAt(i) != ' '){
					--i;
				}
				subStart = i + 1;
				if(i == -1){
					result += s.substring(subStart,subEnd + 1);
				}else{
					result += s.substring(subStart,subEnd + 1) + " ";
				}
			}
		}
		if(result != "" && result.charAt(result.length() - 1) == ' ')
			return result.substring(0, result.length() - 1);
		return result;
	}
	
	public static void main(String[] args) {
		ReverseWordInString r = new ReverseWordInString();
		System.out.println(r.reverseWords(""));
	}
}
