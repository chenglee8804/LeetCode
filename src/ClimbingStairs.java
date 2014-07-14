

public class ClimbingStairs {

	/**
	 * @param args
	 */
	
//	public int climbStairs(int n) {
//		if(n == 1)
//			return 1;
//		if(n == 2)
//			return 2;
//		return climbStairs(n-1) + climbStairs(n-2);
//    }
	
	public int climbStairs(int n) {
//		Hashtable<Integer, Integer> table = new Hashtable<>();
//		table.put(1, 1);
//		table.put(2, 2);
		int first = 1;
		int second = 2;
		int result = 0;
		if(n == 1)
			return 1;
		if(n == 2)
			return 2;
		for(int i = 2; i < n; i++){
			result = first + second;
			first = second;
			second = result;
		}
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClimbingStairs cStairs = new ClimbingStairs();
		System.out.println(cStairs.climbStairs(44));
	}

}
