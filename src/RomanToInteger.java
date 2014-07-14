
public class RomanToInteger {

	/**
	 * @param args
	 */
	public int romanToInt(String s) {
		//int number = 0;
		if(s.isEmpty() == true)
			return 0;
		if(s.startsWith("M"))
			return 1000 + romanToInt(s.substring(1));
		if(s.startsWith("CM"))
			return 900 + romanToInt(s.substring(2));
		if(s.startsWith("D"))
			return 500 + romanToInt(s.substring(1));
		if(s.startsWith("CD"))
			return 400 + romanToInt(s.substring(2));
		if(s.startsWith("C"))
			return 100 + romanToInt(s.substring(1));
		if(s.startsWith("XC"))
			return 90 + romanToInt(s.substring(2));
		if(s.startsWith("L"))
			return 50 + romanToInt(s.substring(1));
		if(s.startsWith("XL"))
			return 40 + romanToInt(s.substring(2));
		if(s.startsWith("X"))
			return 10 + romanToInt(s.substring(1));
		if(s.startsWith("IX"))
			return 9 + romanToInt(s.substring(2));
		if(s.startsWith("V"))
			return 5 + romanToInt(s.substring(1));
		if(s.startsWith("IV"))
			return 4 + romanToInt(s.substring(2));
		if(s.startsWith("I"))
			return 1 + romanToInt(s.substring(1));
		//return number;
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RomanToInteger rti = new RomanToInteger();
		System.out.println(rti.romanToInt("XX"));

	}

}
