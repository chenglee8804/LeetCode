
public class SingleNumberII {
	public int singleNumber(int[] A) {
		int intLength = Integer.SIZE;
		int[] count = new int[intLength];
		
		for(int i = 0; i < A.length; ++i){
			for(int j = 0; j < intLength; ++j){
				count[j] += (A[i] >> j) & 1;
				count[j] %= 3; 
			}
		}
		
		int result = 0;
		for(int i = 0; i < intLength; ++i){
			result += (count[i] << i);
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(4&1);
		SingleNumberII sn2 = new SingleNumberII();
		System.out.println(sn2.singleNumber(new int[]{3,3,4,7,3,6,7,7,6,8,6,8,8}));
	}
}