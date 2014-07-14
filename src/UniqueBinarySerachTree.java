
public class UniqueBinarySerachTree {

	/**
	 * @param args
	 */
	
	public int numTrees(int n){
		if(n == 0)
			return 1;
		if(n == 1)
			return 1;
		int result = 0;
		for(int i = 0; i <= n-1; i++){
			result = result + numTrees(n-1-i)*numTrees(i);
		}
		return result;
			
 	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBinarySerachTree ubdt = new UniqueBinarySerachTree();
		System.out.println(ubdt.numTrees(5));
	}

}
