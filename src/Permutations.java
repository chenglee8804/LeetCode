import java.util.ArrayList;


public class Permutations {

	/**
	 * @param args
	 */
	
	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	public ArrayList<ArrayList<Integer>> permute(int[] num){
		result.clear();
		ArrayList<Integer> A = new ArrayList<>();
		ArrayList<Integer> R = new ArrayList<>();
		
		for(int i = 0; i < num.length; i++){
			A.add(num[i]);
		}
		
		helper(A, R);
		return result;
	}
	
	public void helper(ArrayList<Integer> A, ArrayList<Integer> R){
		//int arraySize = A.size();
		if(A.size() == 0){
			result.add(R);
			return;
		}
		for(int i = 0; i < A.size(); i++){
			ArrayList<Integer> RR = new ArrayList<Integer>();
			RR.addAll(R);
			RR.add(A.get(i));
//			System.out.print(A.get(i) + " ");
			ArrayList<Integer> B = new ArrayList<Integer>();
			B.addAll(A);
			B.remove(i);
			helper(B,RR);
		}
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations p = new Permutations();
		int[] A = new int[]{};
		System.out.println(p.permute(A));
	}

}
