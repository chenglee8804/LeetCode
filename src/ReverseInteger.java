
public class ReverseInteger {

	/**
	 * @param args
	 */
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
		ReverseInteger ri = new ReverseInteger();
		System.out.println(ri.reverse(0));

	}

}
