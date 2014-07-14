
public class RemoveElement {

	/**
	 * @param args
	 */
	public int removeElement(int[] A, int elem){
		int len = A.length;
		for(int i = 0; i < len; i++){
			if(A[i] == elem){
				A[i] = A[len - 1];
				i--;
				len--;
			}
		}
		return len;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
