import java.util.ArrayList;


public class GrayCode {

	/**
	 * @param args
	 */
	public ArrayList<Integer> grayCode(int n){
		int number = (int)Math.pow(2, n);
		ArrayList<Integer> result = new ArrayList<>();
		if(n == 0){
			result.add(0);
			return result;
		}
		if(n == 1){
			result.add(0);result.add(1);
			return result;
		}
		
		for(int i = 0; i < number; i++){
			
			int[] digits = new int[n];
			int[] digits2 = new int[n];
			int remain = i%(int)Math.pow(2, n -1);
			digits[0] = i/(int)Math.pow(2, n -1);
			
			for(int j = 1; j < n - 1; j++){
				digits[j] = (int)(remain/(int)Math.pow(2, n -1 -j));
				remain = remain%(int)Math.pow(2, n -1 -j);
			}
			digits[n-1] = remain;
			digits2[0] = digits[0];
			for(int j = 1; j < n; j++){
				if(digits[j-1] == 1)
					digits2[j] = 1 - digits[j];
				else
					digits2[j] = digits[j];
			}
			
			int sum = 0;
			for(int j = 0; j < n ; j++){
				sum = sum + (int)digits2[j]*(int)Math.pow(2, n-1-j);
			}
			result.add(sum);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrayCode gc = new GrayCode();
		System.out.println(gc.grayCode(7));
	}

}
