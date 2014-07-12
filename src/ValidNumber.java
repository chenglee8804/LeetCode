
public class ValidNumber {
	public boolean isNumber(String s) {
		try {
			Double.parseDouble(s);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		 ValidNumber vn = new ValidNumber();
		 System.out.println(vn.isNumber("10.03f"));
	}
}
