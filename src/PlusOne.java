

public class PlusOne {

	/**
	 * @param args
	 */
	
	public int[] plusOne(int[] digits) {
		int jinwei;
		if((digits[digits.length-1]+1) >= 10)
			jinwei = 1;
		else
			jinwei = 0;
		digits[digits.length - 1] = (digits[digits.length-1]+1) % 10;
		for(int i = digits.length - 2; i >=0 ; i--){
			digits[i] = digits[i] + jinwei;
			if(digits[i] >= 10)
				jinwei = 1;
			else
				jinwei = 0;
			digits[i] = digits[i]%10;
		}
		
		if(jinwei == 1){
			int[] newDigits = new int[digits.length+1];
			newDigits[0] = 1;
			for(int j = 1; j < newDigits.length; j++)
				newDigits[j]= digits[j-1];
			return newDigits;
		}
		return digits;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] dig = new int[]{9,9,9};
		PlusOne po = new PlusOne();
		int[] result = po.plusOne(dig);
		for(int i = 0; i < result.length; i++)
			System.out.println(result[i]);
	}

}
