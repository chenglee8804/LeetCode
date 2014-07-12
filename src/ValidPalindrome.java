
public class ValidPalindrome {
	public boolean isPalindrome(String ss) {
		int i = 0, j = ss.length() - 1;
		String s = ss.toLowerCase();
		while(i < j){
			int dista = s.charAt(i) - 'a';
			int distN = s.charAt(i) - '0';
			if(!((0 <= dista && dista <= 25)||(0 <= distN && distN <= 9))){
				++i;
				continue;
			}
			dista = s.charAt(j) - 'a';
			distN = s.charAt(j) - '0';
			if(!((0 <= dista && dista <= 25)||(0 <= distN && distN <= 9))){
				--j;
				continue;
			}
			if(s.charAt(i) != s.charAt(j)) return false;
			++i;--j;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "race a car";
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(vp.isPalindrome(s));
	}
}
