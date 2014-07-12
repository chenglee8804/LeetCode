
public class AddBinary {
	public String addBinary(String a, String b) {
		String result = "";
		String reverseA = reverseString(a);
		String reverseB = reverseString(b);
		int carry = 0;
		for(int i = 0; i < Math.max(reverseA.length(), reverseB.length()); ++i){
			int ai = i >= reverseA.length() ? 0 : reverseA.charAt(i) - '0';
			int bi = i >= reverseB.length() ? 0 : reverseB.charAt(i) - '0';
			int ri = (ai+bi+carry)%2;
			carry = (ai+bi+carry)/2;
			if(ri == 0){
				result += "0";
			}else {
				result += "1";
			}
		}
		if(carry == 1)
			result += "1";
		return reverseString(result);
	}
	
	public String reverseString(String a) {
		int length = a.length();
		String result = "";
		for(int i = length - 1; i >= 0; --i){
			result += a.charAt(i);
		}
		return result;
	}
	
	public static void main(String[] args) {
//		String test = new String("abcd");
		AddBinary ab = new AddBinary();
		System.out.println(ab.addBinary("0", "0"));
	}
}
