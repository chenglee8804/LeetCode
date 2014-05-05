import java.util.ArrayList;


public class LetterCombinationOfPhoneNumber {
	
	public ArrayList<String> letterCombinations(String digits){
		ArrayList<String> result = new ArrayList<>();
		if(digits.length() == 0){
			result.add("");
			return result;
		}
		for(int i = 0; i < digits.length(); ++i){
			String stringFromButton = getStringFromButton(digits.charAt(i));
			int length = stringFromButton.length();
			if(result.size() == 0){
				for(int j = 0; j < length; ++j){
					result.add("" + stringFromButton.charAt(j));
				}
			}else{
				//copy length - 1 times:
				int copySize = result.size();
				for(int j = 1; j < length; ++j){
					for(int k = 0; k < copySize; ++k){
						result.add(new String(result.get(k)));
					}
				}
				//add to tail:
				for(int j = 0; j < length; ++j){
					for(int k = 0; k < copySize; k++){
						String tempString = result.get(j*copySize + k).concat("" + stringFromButton.charAt(j));
						result.set(j*copySize + k, tempString);
					}
				}
			}
		}
		return result;
	}
	
	public String getStringFromButton(char c) {
		if(c == '2'){
			return "abc";
		}
		if(c == '3'){
			return "def";
		}
		if(c == '4'){
			return "ghi";
		}
		if(c == '5'){
			return "jkl";
		}
		if(c == '6'){
			return "mon";
		}
		if(c == '7'){
			return "pqrs";
		}
		if(c == '8'){
			return "tuv";
		}
		if(c == '9')
			return "wxyz";
		return "";
	}
	
	public static void main(String[] args) {
		LetterCombinationOfPhoneNumber lcpn = new LetterCombinationOfPhoneNumber();
		System.out.println(lcpn.letterCombinations(""));
	}
}
