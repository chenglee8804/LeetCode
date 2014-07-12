
public class JumpGameII {
	public int jump(int[] A) {
		if(A.length == 1) return 0;
		int step = 0;
		int canReach = 0;
		int reached = 0;
		for(int i = 0; i < A.length; ++i){
			if(i > reached){
				reached = canReach;
				step++;
//				System.out.print(i + " ");
			}
			canReach = Math.max(canReach, i + A[i]);	
		}
		return step;
	}
	
	public static void main(String[] args) {
		int[] A = new int[]{2,3,0,1,4,1,3,2,0,2,1};
		JumpGameII jg2 = new JumpGameII();
		System.out.println(jg2.jump(A));
	}
}
