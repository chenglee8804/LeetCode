
public class SingleNumber {

	/**
	 * @param args
	 */
	public int singleNumber(int[] A) {
		int x = 0;
		for(int i = 0; i < A.length; i++){
			x = x ^ A[i];
		}
		return x;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[]{1,3,2,1,2,3,4,5,6,5,6,0,0};
		SingleNumber sn = new SingleNumber();
		System.out.println(sn.singleNumber(array));
		System.out.println(723 & 1);
	}

}
