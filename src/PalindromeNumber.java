
public class PalindromeNumber {

	/**
	 * @param args
	 */
	
	public boolean isPalindrome(int x){
		if(x < 0)
			return false;
		if(x == reverse(x))
			return true;
		else {
			return false;
		}
	}
	
	public int reverse(int x) {
        int number = x;
		int reverseNum = 0;
		while(number != 0){
			reverseNum = reverseNum*10 + number%10;
			number = number/10;
		}
        return reverseNum;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeNumber pn	= new PalindromeNumber();
		System.out.println(pn.isPalindrome(-1234321));
	}

}
